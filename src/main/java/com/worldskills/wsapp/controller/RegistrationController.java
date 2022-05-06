package com.worldskills.wsapp.controller;

import com.jfoenix.controls.JFXButton;
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
public class RegistrationController {

    private static final Logger logger = LogManager.getLogger();

    private final UserService userService;
    private final SceneLoader sceneLoader;

    public RegistrationController(UserService userService, SceneLoader sceneLoader) {
        this.userService = userService;
        this.sceneLoader = sceneLoader;
    }

    @FXML
    private ImageView backIcon;
    @FXML
    private JFXButton registerButton;
    @FXML
    private TextField loginField;
    @FXML
    private JFXButton loginButtonInRegister;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onRegisterButtonClick() {
        User user = new User();

        user.setLogin(loginField.getText());
        user.setPassword(passwordField.getText());

        userService.saveUser(user);

        registerButton.getScene().getWindow().hide();

        Map<String, String> loginSceneParams = new HashMap<>();
        loginSceneParams.put("path_to_fxml", "/view/login.fxml");
        loginSceneParams.put("path_to_logo", "/view/images/logo.png");
        loginSceneParams.put("title", "Вход");
        sceneLoader.loadScene(loginSceneParams);

        logger.info("Пользователь {} зарегистрирован.", user);
    }

    @FXML
    protected void goBack() {
        // TODO Реализовать выход на главный экран (назад)
    }

    @FXML
    protected void goToLogin() {
        loginButtonInRegister.getScene().getWindow().hide();

        Map<String, String> loginSceneParams = new HashMap<>();
        loginSceneParams.put("path_to_fxml", "/view/login.fxml");
        loginSceneParams.put("path_to_logo", "/view/images/logo.png");
        loginSceneParams.put("title", "Вход");
        sceneLoader.loadScene(loginSceneParams);
    }
}