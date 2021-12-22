package com.worldskills.wsapp.controller;

import com.worldskills.wsapp.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private Label usersList;

    @FXML
    protected void onGetUsersButtonClick() {
        usersList.setText(userService.getUsers().toString());
    }
}
