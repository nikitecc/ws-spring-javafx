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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthController {

    private static final Logger logger = LogManager.getLogger();

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private ImageView backIcon;
    @FXML
    private TextField loginField;
    @FXML
    private JFXCheckBox restoreCheckBox;
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton registerButton;
    @FXML
    private JFXButton loginButtonInRegister;
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
    protected void onRegisterButtonClick() {
        User user = new User();

        user.setLogin(loginField.getText());
        user.setPassword(passwordField.getText());

        userService.saveUser(user);

        logger.info("Пользователь {} зарегистрирован.", user);
    }

    @FXML
    protected void goBack() {
        // TODO Реализовать выход на главный экран (назад)
    }

    @FXML
    protected void goToLogin() {
        SceneLoader.loadNewScene();
        loginButtonInRegister.getScene().getWindow().hide();
    }

    @FXML
    protected void goToRegistration() {

    }
}
