package repository.custom.Impl;

import db.DBConnection;
import entity.BookEntity;
import repository.CRUDRepository;
import repository.custom.BookDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class BookDaoImpl implements BookDao {


    @Override
    public boolean Save(BookEntity entity) {
        String SQL = "INSERT INTO Books VALUES(?,?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,entity.getId());
            preparedStatement.setObject(2,entity.getISBN());
            preparedStatement.setObject(3,entity.getTitle());
            preparedStatement.setObject(4,entity.getAuthor());
            preparedStatement.setObject(5,entity.getGenre());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public boolean update(String s, BookEntity entity) {
        return false;
    }

    @Override
    public boolean delete(String s ) {
        String SQL = "DELETE from Books WHERE book_id  = '"+s+"'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            return connection.createStatement().executeUpdate(SQL) > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public BookEntity search(BookEntity entity) {
        return null;
    }

    @Override
    public List<BookEntity> getAll() {
        return List.of();
    }
}
