package pl.coderslab.dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.dbutil.DBUtil;
import pl.coderslab.entity.User;

import java.sql.*;


public class UserDao {
    private static final String CREATE_USER_QUERY = "INSERT INTO users(username, email, password) VALUES (?, ?, ?);";
    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id = ?;";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM users;";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?;";


    // metoda creat - korzysta z metody BCrypt.hashpw
    public User create(User user) {
        try (Connection conn = DBUtil.connect()) {
            PreparedStatement preStatement = conn.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preStatement.setString(1, user.getUserName());
            preStatement.setString(2, user.getEmail());
            preStatement.setString(3, hashPassword(user.getPassword()));
            preStatement.executeUpdate();
            ResultSet rs = preStatement.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
                System.out.println("Inserted ID: " + rs.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // metoda BCrypt.hashpw
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    // metoda read
    public User read(int userId) {
        try (Connection conn = DBUtil.connect()) {
            PreparedStatement preStatemant = conn.prepareStatement(READ_USER_QUERY);
            preStatemant.setInt(1, userId);
            ResultSet rs = preStatemant.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
