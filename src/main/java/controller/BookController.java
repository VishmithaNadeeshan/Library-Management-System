package controller;

import com.google.inject.Inject;
import com.jfoenix.controls.JFXComboBox;
import dto.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;
//import repository.db.DBConnection;
import service.custom.BookService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    public JFXComboBox cmbAvailability;
    public TableView tableBooks;
    public TableColumn colId;
    public TableColumn colISBN;
    public TableColumn colTitle;
    public TableColumn colAuthor;
    public TableColumn colGenre;
    public TableColumn colAvailability;
    @Inject
    BookService service;
    @FXML
    private TextField txtAuthor;
    @FXML
    private TextField txtGenre;
    @FXML
    private TextField txtISBN;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtId;
//  ServiceFactory.getInstance().getServiceType(ServiceType.BOOK);

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        String txtIdText = txtId.getText();
        String txtISBNText = txtISBN.getText();
        String txtTitleText = txtTitle.getText();
        String txtAuthorText = txtAuthor.getText();
        String txtGenreText = txtGenre.getText();
        String value = cmbAvailability.getValue().toString();

        if (txtIdText.isEmpty() || txtISBNText.isEmpty() || txtTitleText.isEmpty() || txtAuthorText.isEmpty() || txtGenreText.isEmpty() || value.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "ALL FIELD MUST BE FILLED OUT").show();
        } else {
            Book book = new Book(txtIdText, txtISBNText, txtTitleText, txtAuthorText, txtGenreText, value);
            boolean isBookAdded = service.addBook(book);
            if (isBookAdded) {
                new Alert(Alert.AlertType.INFORMATION, "BOOK ADDED").show();
                clearText();
            } else {
                new Alert(Alert.AlertType.ERROR, "BOOK NOT ADDED").show();
                clearText();
            }
        }
    }

    private void clearText() {
        txtId.clear();
        txtISBN.clear();
        txtTitle.clear();
        txtAuthor.clear();
        txtGenre.clear();
    }

    @FXML
    void btnSearchBookOnAction(ActionEvent event) {
        Book book = service.searchBook(txtId.getText());

        if (book != null) {
            txtISBN.setText(book.getISBN());
            txtTitle.setText(book.getTitle());
            txtAuthor.setText(book.getAuthor());
            txtGenre.setText(book.getGenre());
        } else {
            new Alert(Alert.AlertType.ERROR, "BOOK NOT FOUND").show();
        }
    }

    @FXML
    void btnUpdateBookOnAction(ActionEvent event) {
        String txtIdText = txtId.getText();
        String txtISBNText = txtISBN.getText();
        String txtTitleText = txtTitle.getText();
        String txtAuthorText = txtAuthor.getText();
        String txtGenreText = txtGenre.getText();
        String value = cmbAvailability.getValue().toString();
        Book book = new Book(txtIdText, txtISBNText, txtTitleText, txtAuthorText, txtGenreText, value);
        boolean isBookUpdate = service.updateBook(book);

        if (isBookUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "BOOK UPDATED SUCCESSFULLY").show();
            clearText();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO UPDATE BOOK").show();
            clearText();
        }
    }

    @FXML
    void btnDeleteBookOnAction(ActionEvent event) {
        if (service.deleteBook(txtId.getText())) {
            new Alert(Alert.AlertType.INFORMATION, "BOOK DELETED SUCCESSFULLY").show();
            clearText();
        } else {
            new Alert(Alert.AlertType.ERROR, "FAILED TO DELETE BOOK. PLEASE TRY AGAIN").show();
            clearText();
        }
    }

    @FXML
    void btnReloadBooksOnAction(ActionEvent event) {
        loadTable();
    }

    public void loadCMB() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("Available");
        observableList.add("Not Available");
        cmbAvailability.setItems(observableList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCMB();
    }

    private void loadTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("iSBN"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));

        ObservableList<Book> booksObservable = FXCollections.observableArrayList();

        service.getAll().forEach(book -> {
            booksObservable.add(book);
        });

        tableBooks.setItems(booksObservable);
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        loadTable();
    }

//    public void btnGetBookReportOnAction(ActionEvent actionEvent) {
//        try {
//            JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/report/Book.jrxml");
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (JRException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
}
