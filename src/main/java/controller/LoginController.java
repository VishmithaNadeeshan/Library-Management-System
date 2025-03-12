package controller;

import com.google.inject.Inject;
import com.jfoenix.controls.JFXTextField;
import dto.User;
import entity.AdminEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import dto.Admin;
import javafx.stage.Stage;
import service.custom.AdminService;

import java.io.IOException;

public class LoginController {

    @Inject
    AdminService service;
    @FXML
    private Button btnLogin;

    @FXML
    private JFXTextField textEmail;

    @FXML
    private JFXTextField textPassword;

    @FXML
    private JFXTextField textUsername;

    @FXML
    void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        AdminEntity adminEntity = service.searchAdmin(textEmail.getText());

        if (textUsername.getText().isEmpty() || textEmail.getText().isEmpty() || textPassword.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"All filed must be filled out").show();
        }else {
            if (adminEntity.getPassword().equals(textPassword.getText())){
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
                stage.show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid Password").show();
            }
        }



    }

    public void hyperRegisterOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/register-form.fxml"))));
        stage.show();
    }
}

