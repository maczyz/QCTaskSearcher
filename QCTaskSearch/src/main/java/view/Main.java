package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String WINDOW_TITLE = "QC Task Searcher";

    // The main container - usually a window with a border and the typical minimize, maximize and close buttons.
    // Inside the Stage you add a Scene which can, of course,
    // be switched out by another Scene. Inside the Scene the actual JavaFX nodes like AnchorPane, TextBox, etc. are added.
    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("QC Task Searcher");

        initRootLayoutAndShowMainWindow();

        showMainWindow();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayoutAndShowMainWindow() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/fxml/QCTaskWindow.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);

            // CSS
            String cssPath = this.getClass().getResource("/fxml/application.css").toExternalForm();
            scene.getStylesheets().add(cssPath);

            primaryStage.setScene(scene);
            primaryStage.setTitle(WINDOW_TITLE);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the main window inside the root layout.
     */
    public void showMainWindow() {
        try {
            // Load main window.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/fxml/QCTaskWindow.fxml"));
            AnchorPane qcTaskWindow = (AnchorPane) loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * 
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
