package controller;

import com.google.inject.Inject;
import com.jfoenix.controls.JFXTextField;
import dto.Admin;
import dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import service.custom.AdminService;
import service.custom.UserService;

public class RegisterController {
    @Inject
    AdminService service;
    @FXML
    private JFXTextField txtConfirmPassword;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if (!isEmpty()) {
            if (txtPassword.getText().equals(txtConfirmPassword.getText())) {
                Admin admin = new Admin(username, email, password);
                boolean isAdminAdded = service.addAdmin(admin);
                if (isAdminAdded) {
                    new Alert(Alert.AlertType.INFORMATION, "User ADDED").show();

                } else {
                    new Alert(Alert.AlertType.INFORMATION, "User NOT ADDED").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Check your Password").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Please fill all fields").show();
        }

    }
    private boolean isEmpty(){
        return txtUsername.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty() || txtConfirmPassword.getText().isEmpty();
    }

}
