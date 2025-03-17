package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.Book;
import dto.Borrow;
import dto.BorrowDetails;
import dto.TM.CartTM;
import dto.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import service.custom.BookService;
import service.custom.BorrowService;
import service.custom.UserService;
import service.impl.BookServiceImpl;
import service.impl.BorrowServiceImpl;
import service.impl.UserServiceImpl;
import utill.BorrowStatus;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BorrowController implements Initializable {
    @FXML
    private DatePicker txtDewDate;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtContact;
    @FXML
    private TextField txtMembershipDate;
    @FXML
    private TextField txtAvailability;
    @FXML
    private TextField txtGenre;
    @FXML
    private TextField txtAuthor;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtIsbn;
    @FXML

    //@Inject
    BookService service = new BookServiceImpl();

    //@Inject
    UserService UserService = new UserServiceImpl();

    BorrowService borrowService = new BorrowServiceImpl();
    @FXML
    private DatePicker txtBorrowedDate;

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
    private TableView<CartTM> tblCart;

    @FXML
    private JFXTextField txtBorrowId;

    @FXML
    void AddToCartAction(ActionEvent event) {



        String bookId = cmbBookId.getValue().toString();
        String userId = cmbUserId.getValue().toString();
        String borrowDate = txtBorrowedDate.getValue().toString();
        String dewDate = txtDewDate.getValue().toString();


        if (cartTms.size()<3){
            cartTms.add(new CartTM(bookId, userId, borrowDate, dewDate));
            tblCart.setItems(cartTms);
        }else {
            new Alert(Alert.AlertType.ERROR,"borrow limit exceeded").show();
        }

    }

    ObservableList<CartTM> cartTms = FXCollections.observableArrayList();
    @FXML
    boolean placeOrderAction(ActionEvent event) {
        ArrayList<BorrowDetails> borrowDetails = new ArrayList<>();

        String borrowId = txtBorrowId.getText();
        String bookId = cmbBookId.getValue().toString();
        String userId = cmbUserId.getValue().toString();
        String borrowdate = txtBorrowedDate.getValue().toString();
        String dewDate = txtDewDate.getValue().toString();

        cartTms.forEach(cartTM -> {
            borrowDetails.add(
                    new BorrowDetails(
                            borrowId,
                            cartTM.getBookId(),
                            cartTM.getBorrowDate(),
                            null
                    )


            );
        });
        Borrow borrow = new Borrow(borrowId, userId, borrowdate, dewDate, BorrowStatus.BORROWED, borrowDetails);
        boolean isPlacedOrder = borrowService.placeBorrowOrder(borrow);
        if (isPlacedOrder) {
            new Alert(Alert.AlertType.INFORMATION,"Borrow success").show();
            boolean addBorrowDetails = new BorrowDetailController().addBorrowDetail(borrow.getBorrowDetails());

            if (addBorrowDetails) {
                return true;
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Borrow faild").show();
        }
        return isPlacedOrder;
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
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("dewDate"));

        cmbUserId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                searchUserData(newValue.toString());
            }
        });

        cmbBookId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                searchBookData(newValue.toString());
            }
        });

        loadBookIds();
        loadUserIds();

    }

    public void searchBookData(String id){
        Book book = service.searchBook(id);
        txtIsbn.setText(book.getISBN());
        txtTitle.setText(book.getTitle());
        txtAuthor.setText(book.getAuthor());
        txtGenre.setText(book.getGenre());
        txtAvailability.setText(book.getAvailability());
    }

    public void searchUserData(String id){
        User user = UserService.searchUser(id);
        txtUserName.setText(user.getName());
        txtContact.setText(user.getContact());
        txtMembershipDate.setText(user.getDate());
    }
}
