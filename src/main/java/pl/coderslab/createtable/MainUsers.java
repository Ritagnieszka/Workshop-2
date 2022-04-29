package pl.coderslab.createtable;

import pl.coderslab.dbutil.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainUsers {
    private static final String CREATE_TABLE_USER = "CREATE TABLE users (\n" +
            "    id INT(11) NOT NULL AUTO_INCREMENT,\n" +
            "    email VARCHAR(255) UNIQUE,\n" +
            "    username VARCHAR(255),\n" +
            "    password VARCHAR(60),\n" +
            "    PRIMARY KEY (id)\n" +
            ");";

    public static void main(String[] args) {
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preStatement = connection.prepareStatement(CREATE_TABLE_USER);
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
