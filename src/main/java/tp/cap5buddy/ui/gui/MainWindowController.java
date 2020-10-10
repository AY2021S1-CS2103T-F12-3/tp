package tp.cap5buddy.ui.gui;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tp.cap5buddy.commons.LogsCenter;

public class MainWindowController {
    private static final Logger logger = LogsCenter.getLogger(MainWindow.class);
    private static final URL DIR = MainWindow.class.getResource("/view/tp/MainWindow.fxml");
    private Stage primaryStage;

    /**
     * Creates the controller class for the GUI to handle events.
     * @param primaryStage stage for the GUI.
     */
    public MainWindowController(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(DIR);
        try {
            AnchorPane ap = fxmlLoader.load();
            Scene sc = new Scene(ap);
            primaryStage.setScene(sc);
            primaryStage.show();
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
