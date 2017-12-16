package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.FxmlUtils;

public class Main extends Application {

    private static final String WINDOW_TITLE = "QC Task Searcher";

    private static final String ANCHOR_PANE_MAIN_FXML = "/fxml/QCTaskWindow.fxml";

    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("QC Task Searcher");

        try {
            initRootLayoutAndShowMainWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initRootLayoutAndShowMainWindow() throws IOException {
        rootLayout = (AnchorPane) FxmlUtils.fxmlLoader(ANCHOR_PANE_MAIN_FXML);

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);

        // CSS
        String cssPath = this.getClass().getResource("/fxml/application.css").toExternalForm();
        scene.getStylesheets().add(cssPath);

        primaryStage.setScene(scene);
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
