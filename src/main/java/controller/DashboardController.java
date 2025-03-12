package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class DashboardController {
    public AnchorPane loadFormContent;

    public void btnBookManagementOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/book-form.fxml");

        assert resource != null;

       Parent load = FXMLLoader.load(resource);

       loadFormContent.getChildren().clear();
       loadFormContent.getChildren().add(load);
    }

    public void btnUserManagementOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/user-form.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    public void btnBorrowAndReturnOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/borrow-form.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    public void btnReportingOnAction(ActionEvent actionEvent) {
    }

    public void btnFineManagementOnAction(ActionEvent actionEvent) {
    }
}
