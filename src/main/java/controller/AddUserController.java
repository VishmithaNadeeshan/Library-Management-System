package controller;

import com.google.inject.Inject;
import dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import service.custom.UserService;

import java.time.LocalDate;

public class AddUserController {

    @Inject
    UserService service;
    @FXML
    private TextField txtMembershipDate;
    @FXML
    private TextField txtContact;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;


    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String date = txtDate.getValue().toString();


        User user = new User(id, name, contact, date);
        boolean isUserAdded = service.addUser(user);
        if (isUserAdded) {
            new Alert(Alert.AlertType.INFORMATION, "User ADDED").show();
            clearText();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "User NOT ADDED").show();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        boolean isDeleted = service.deleteUser(txtID.getText());
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"User Deleted").show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"error").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        User user = service.searchUser(txtID.getText());
        if (user != null) {
            txtName.setText(user.getName());
            txtContact.setText(user.getContact());
            txtMembershipDate.setText(user.getDate().toString());

        } else {
            new Alert(Alert.AlertType.ERROR, "User NOT FOUND").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String date = txtDate.getValue().toString();


        User user = new User(id, name, contact, date);
        boolean isUpdate = service.updateUser(user);
        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "BOOK UPDATED SUCCESSFULLY").show();
            clearText();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO UPDATE BOOK").show();
            clearText();
        }

    }
    private void clearText() {
        txtID.clear();
        txtName.clear();
        txtContact.clear();
        txtMembershipDate.clear();

    }
}
