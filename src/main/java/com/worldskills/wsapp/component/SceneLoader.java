package com.worldskills.wsapp.component;

import com.worldskills.wsapp.WsapplicationApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {

    private SceneLoader() {
    }

    public static void loadNewScene() {
        FXMLLoader loader = new FXMLLoader(WsapplicationApplication.class.getResource("/view/login.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/view/images/logo.png"));
        stage.setTitle("Test");
        stage.setResizable(false);
        stage.show();
    }
}