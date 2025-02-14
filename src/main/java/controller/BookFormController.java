package controller;

import com.google.inject.Inject;
import dto.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.custom.BookService;


public class BookFormController {

    @FXML
    private TableColumn colGenre;

    @FXML
    private TableColumn colISBN;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colStatus;

    @FXML
    private TableColumn colTitle;

    @FXML
    private TableView tbIBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtId;

    @Inject
    BookService service;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        String txtIdText = txtId.getText();
        String txtISBNText = txtISBN.getText();
        String txtTitleText = txtTitle.getText();
        String txtAuthorText = txtAuthor.getText();
        String txtGenreText = txtGenre.getText();

        Book book = new Book(txtIdText, txtISBNText, txtTitleText, txtAuthorText, txtGenreText);
        boolean isAdded = service.addBook(book);
        System.out.println("isAdded: " + isAdded); // Debugging line
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Book Added").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Book not Added").show();
        }


    }

    @FXML
    void btnDeleteBookOnAction(ActionEvent event) {
        boolean isDelete = service.deleteBook(txtId.getText());
        if (isDelete){
            new Alert(Alert.AlertType.INFORMATION,"Book Deleted").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Book not Deleted").show();
        }
    }

    @FXML
    void btnReloadBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateBookOnAction(ActionEvent event) {

    }

}