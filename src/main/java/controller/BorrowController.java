package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.Book;
import dto.User;
import jakarta.inject.Inject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import service.custom.BookService;
import service.custom.UserService;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BorrowController implements Initializable {

    //@Inject
    BookService service = new BookServiceImpl();

    //@Inject
    UserService UserService = new UserServiceImpl();
    @FXML
    private DatePicker borrowedDate;

    @FXML
    private JFXComboBox  cmbBookId;

    @FXML
    private JFXComboBox  cmbUserId;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBorrowDate;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private Label lblNetTotal;

    @FXML
    private DatePicker returnedDate;

    @FXML
    private TableView<?> tbCart;

    @FXML
    private JFXTextField txtBorrowId;

    @FXML
    void AddToCartAction(ActionEvent event) {

    }

    @FXML
    void placeOrderAction(ActionEvent event) {

    }

    private void loadBookIds(){
        cmbBookId.setItems(setBookIds());
    }

    public void loadUserIds(){
        cmbUserId.setItems(setUserIds());
    }

    public ObservableList<String>setBookIds(){
        ObservableList<String> bookIds = FXCollections.observableArrayList();
        List<Book> all = service.getAll();
        System.out.println(all);
        all.forEach(book -> {
            bookIds.add(book.getId());
        });
        return bookIds;

    }

    public ObservableList<String>setUserIds(){
        ObservableList<String> userIds = FXCollections.observableArrayList();
        List<User> all = UserService.getAll();
        System.out.println(all);
        all.forEach(user -> {
            userIds.add(user.getId());
        });
        return userIds;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadBookIds();


    }

}
