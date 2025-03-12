package repository.custom.impl;

import dto.Admin;
import entity.AdminEntity;
import javafx.scene.control.Alert;
import repository.custom.AdminDao;
import repository.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean save(AdminEntity entity) {
        String SQL ="INSERT INTO admins(Username,Email,Password) VALUES(?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM admins WHERE Email=" + "'" + entity.getEmail() + "'");
            if (resultSet.next()){
                new Alert(Alert.AlertType.ERROR,"Admin Already Registered ").show();
            }else {PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setObject(1,entity.getUsername());
                preparedStatement.setObject(2,entity.getEmail());
                preparedStatement.setObject(3,entity.getPassword());
                return preparedStatement.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public AdminEntity search(String s) {
        String SQL = "SELECT * FROM admins WHERE email = "+"'"+s+"'";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(SQL);

            if (resultSet.next()){
                return new AdminEntity(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );

            }else {
                new Alert(Alert.AlertType.ERROR,"Admin not found").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean update(AdminEntity entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<AdminEntity> getAll() {
        return List.of();
    }
}
