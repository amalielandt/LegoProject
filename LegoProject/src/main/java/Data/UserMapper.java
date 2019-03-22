/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Function.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofieamalielandt
 */
public class UserMapper
{

    private DBConnector dbc;

    public UserMapper(DBConnector dbc) throws DataException
    {
        this.dbc = dbc;

    }

    public User login(String email, String password) throws DataException
    {
        try
        {
            dbc.open();

            String query = "SELECT * FROM user "
                    + "WHERE email=? AND password=?";

            PreparedStatement statement = dbc.preparedStatement(query);

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next())
            {
                String role = rs.getString("role");
                int id = rs.getInt("user_id");
                User user = new User(id, password, email, role);
                dbc.close();
                return user;

            } else
            {
                dbc.close();
                return null;
            }
        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }

    }

    public void createUser(User user) throws DataException
    {
        try
        {
            dbc.open();
            String query = "INSERT INTO LegoHouse.user"
                    + "( `email`,`password`,`role`)"
                    + "VALUES (?,?,?);";
            
            int id = 0;
            String password = user.getPassword();
            String email = user.getEmail();
            String role = user.getRole();
            
            PreparedStatement statement = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, role);
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next())
            {
                id = rs.getInt(1);
                user.setUser_id(id);
            }
            
            dbc.close();
            
        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }
    }

    public User getUser(int user_id) throws DataException
    {
        try
        {
            dbc.open();
            String query
                    = "SELECT * "
                    + "FROM LegoHouse.user "
                    + "WHERE user_id = '" + user_id + "';";
            
            PreparedStatement statement = dbc.preparedStatement(query);
            ResultSet rs = statement.executeQuery();
            
            User user = null;
            int id = 0;
            String email = "";
            String password = "";
            String role = "";
            
            while (rs.next())
            {
                id = rs.getInt("user_id");
                email = rs.getString("email");
                password = rs.getString("password");
                role = rs.getString("role");
                
                user = new User(id, password, email, role);
            }
            dbc.close();
            
            return user;
            
        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }
    }

    public List<User> getUsers() throws DataException
    {
        try
        {
            dbc.open();
            String query
                    = "SELECT * "
                    + "FROM LegoHouse.user;";
            
            PreparedStatement statement = dbc.preparedStatement(query);
            ResultSet rs = statement.executeQuery();
            
            List<User> users = new ArrayList<>();
            int id = 0;
            String email = "";
            String password = "";
            String role = "";
            
            while (rs.next())
            {
                id = rs.getInt("user_id");
                email = rs.getString("email");
                password = rs.getString("password");
                role = rs.getString("role");
                
                users.add(new User(id, password, email, role));
            }
            dbc.close();
            
            return users;
            
        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }
    }

}
