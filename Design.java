package Unit6Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Design extends JPanel implements ActionListener
{
    public Design ()
    {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawPieces(g);
    }

    private void drawGrid(Graphics g) {
        int gridSize = 8;
        int cellSize = 80;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                Color color = (row + col) % 2 == 0 ? Color.WHITE : Color.GRAY;
                g.setColor(color);
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }
    }

    private void drawPieces(Graphics g) {
        int gridSize = 8;
        int cellSize = 50;
        Image blackBishop = createImageIcon("blackBishop.png").getImage();
        Image blackKing = createImageIcon("blackKing.png").getImage();
        Image blackKnight = createImageIcon("blackKnight.png").getImage();
        Image blackPawn = createImageIcon("blackPawn.png").getImage();
        Image blackQueen = createImageIcon("blackQueen.png").getImage();
        Image blackRook = createImageIcon("blackRook.png").getImage();
        Image whiteBishop = createImageIcon("whiteBishop.png").getImage();
        Image whiteKing = createImageIcon("whiteKing.png").getImage();
        Image whiteKnight = createImageIcon("whiteKnight.png").getImage();
        Image whitePawn = createImageIcon("whitePawn.png").getImage();
        Image whiteQueen = createImageIcon("whiteQueen.png").getImage();
        Image whiteRook = createImageIcon("whiteRook.png").getImage();
    
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int x = col * cellSize;
                int y = row * cellSize;
    
                if (row == 0) {
                    if (col == 0 || col == gridSize - 1) {
                        g.drawImage(blackRook, x, y, this);
                    } else if (col == 1 || col == gridSize - 2) {
                        g.drawImage(blackKnight, x, y, this);
                    } else if (col == 2 || col == gridSize - 3) {
                        g.drawImage(blackBishop, x, y, this);
                    } else if (col == 3) {
                        g.drawImage(blackQueen, x, y, this);
                    } else if (col == 4) {
                        g.drawImage(blackKing, x, y, this);
                    }
                } else if (row == 1) {
                    g.drawImage(blackPawn, x, y, this);
                } else if (row == gridSize - 2) {
                    g.drawImage(whitePawn, x, y, this);
                } else if (row == gridSize - 1) {
                    if (col == 0 || col == gridSize - 1) {
                        g.drawImage(whiteRook, x, y, this);
                    } else if (col == 1 || col == gridSize - 2) {
                        g.drawImage(whiteKnight, x, y, this);
                    } else if (col == 2 || col == gridSize - 3) {
                        g.drawImage(whiteBishop, x, y, this);
                    } else if (col == 3) {
                        g.drawImage(whiteQueen, x, y, this);
                    } else if (col == 4) {
                        g.drawImage(whiteKing, x, y, this);
                    }
                }
            }
        }
    }  

    public void actionPerformed (ActionEvent e)
    {
        
    }
    protected static ImageIcon createImageIcon (String path)
    {
        java.net.URL imgURL = Design.class.getResource (path);
        if (imgURL != null)
            return new ImageIcon (imgURL);
        else
            return null;
    }

    public static void main (String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated (true);
        //Create and set up the window.
        JFrame frame = new JFrame ("Chess");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        //Create and set up the content pane.
        JComponent newContentPane = new Design ();
        newContentPane.setOpaque (false);
        frame.setContentPane (newContentPane);
        frame.setSize (250, 250);
        frame.setVisible (true);
    }
}
