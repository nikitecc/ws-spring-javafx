package com.worldskills.wsapp.component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class SceneLoader {

    private final ApplicationContext applicationContext;

    public SceneLoader(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void loadScene(Map<String, String> sceneParams) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneParams.get("path_to_fxml")));

        try {
            loader.setControllerFactory(applicationContext::getBean);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(sceneParams.get("path_to_logo")));
        stage.setTitle(sceneParams.get("title"));
        stage.setResizable(false);
        stage.show();
    }
}
