package repository.custom.impl;

import entity.BorrowEntity;
import repository.custom.AdminDao;
import repository.custom.BorrowDao;
import repository.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BorrowDaoImpl implements BorrowDao {
    @Override
    public boolean save(BorrowEntity entity) {
        String SQL = "INSERT INTO borrow VALUES(?, ?, ?, ?, ?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,entity.getBorrowId());
            preparedStatement.setObject(2,entity.getUserId());
            preparedStatement.setObject(3,entity.getBorrowDate());
            preparedStatement.setObject(4,entity.getDewDate());
            preparedStatement.setObject(5,entity.getStatus().name());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BorrowEntity search(String string) {
        return null;
    }

    @Override
    public boolean update(BorrowEntity entity) {
        return false;
    }

    @Override
    public boolean delete(String string) {
        return false;
    }

    @Override
    public List<BorrowEntity> getAll() {
        return List.of();
    }
}
