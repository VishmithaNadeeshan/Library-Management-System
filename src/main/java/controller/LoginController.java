package controller;

import com.jfoenix.controls.JFXTextField;
import dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import dto.Admin;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private JFXTextField textEmail;

    @FXML
    private JFXTextField textPassword;

    @FXML
    private JFXTextField textUsername;

    void btnLoginOnAction(ActionEvent actionEvent) {
        User user = new User();
    }
}

