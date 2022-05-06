package com.worldskills.wsapp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.worldskills.wsapp.component.SceneLoader;
import com.worldskills.wsapp.entity.User;
import com.worldskills.wsapp.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginController {
    private static final Logger logger = LogManager.getLogger();

    private final UserService userService;
    private final SceneLoader sceneLoader;

    public LoginController(UserService userService, SceneLoader sceneLoader) {
        this.userService = userService;
        this.sceneLoader = sceneLoader;
    }

    @FXML
    private ImageView backIcon;
    @FXML
    private TextField loginField;
    @FXML
    private JFXCheckBox restoreCheckBox;
    @FXML
    private JFXButton registerButtonInLogin;
    @FXML
    private PasswordField passwordField;

    // TODO Заменить авторизацию на Spring Security или на какой-то провайдер
    @FXML
    protected void onLoginButtonClick() {
        User user = userService.getRegisteredUser(loginField.getText(), passwordField.getText());

        logger.info("Пользователь {} авторизован.", user);

        // TODO Реализовать переход на другой экран
    }

    @FXML
    protected void goBack() {
        // TODO Реализовать выход на главный экран (назад)
    }

    @FXML
    protected void goToRegistration() {
        registerButtonInLogin.getScene().getWindow().hide();

        Map<String, String> loginSceneParams = new HashMap<>();
        loginSceneParams.put("path_to_fxml", "/view/registration.fxml");
        loginSceneParams.put("path_to_logo", "/view/images/logo.png");
        loginSceneParams.put("title", "Регистрация");
        sceneLoader.loadScene(loginSceneParams);
    }
}