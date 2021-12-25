package com.worldskills.wsapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WsapplicationApplication extends Application {

    static {
        Font.loadFont("/view/fonts/comic-sans-ms.ttf", 10);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WsapplicationApplication.class);
        FXMLLoader loader = new FXMLLoader(WsapplicationApplication.class.getResource("/view/login.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(loader.load(), 1000, 600, false, SceneAntialiasing.BALANCED);

        stage.getIcons().add(new Image("/view/images/logo.png"));
        stage.setTitle("WorldSkills. Приложение № 20");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}