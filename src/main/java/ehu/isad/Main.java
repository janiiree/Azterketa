package ehu.isad;

import ehu.isad.controller.ui.AzterketaKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;

    private AzterketaKud txanponKud;

    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailaKargatu();
        stage.setScene(scene);
        stage.show();
    }

    private void pantailaKargatu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Azterketa.fxml"));
        Parent UI = loader.load();
        scene = new Scene(UI);
        txanponKud = loader.getController();
        txanponKud.setMainApp(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
