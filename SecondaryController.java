package Unit6Game;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("primary");
    }

}