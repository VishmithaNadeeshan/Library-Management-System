package repository.custom.impl;

import entity.UserEntity;
import repository.custom.UserDao;
import repository.db.DBConnection;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(UserEntity entity) {
        String SQL = "INSERT INTO user VALUES(?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,entity.getId());
            preparedStatement.setObject(2,entity.getName());
            preparedStatement.setObject(3,entity.getContact());
            preparedStatement.setObject(4,entity.getDate());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public UserEntity search(String s) {
        String SQL = "SELECT * FROM user WHERE UserID='"+s+"'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()){
              return   new UserEntity(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean update(UserEntity entity) {
        String SQL = "UPDATE user SET Name=?, Contact_Information=?, Membership_Date=? WHERE UserID=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,entity.getName());
            preparedStatement.setObject(2,entity.getContact());
            preparedStatement.setObject(3,entity.getDate());
            preparedStatement.setObject(4,entity.getId());
           return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(String s) {
        String SQL = "DELETE FROM user WHERE UserID= '"+s+"'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            return connection.createStatement().executeUpdate(SQL) > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<UserEntity> getAll() {
        return List.of();
    }
}
