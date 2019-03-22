/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Function.User;
import Function.Order;
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
public class OrderMapper
{

    private DBConnector dbc;
    private UserMapper um;

    public OrderMapper(DBConnector dbc, UserMapper um) throws DataException
    {
        this.dbc = dbc;
        this.um = um;

    }

    public void placeOrder(Order order) throws DataException, SQLException
    {
        dbc.open();

        String query = "INSERT INTO LegoHouse.order"
                + "(`user_id`,`length`, `width`,`height`)"
                + "VALUES (?,?,?,?);";

        int user_id = order.getUser().getUser_id();
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();
        int order_id;
        String order_date;

        PreparedStatement statement = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, user_id);
        statement.setInt(2, length);
        statement.setInt(3, width);
        statement.setDouble(4, height);
        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next())
        {
            order_id = rs.getInt(1);
            order_date = getOrder_date(order_id);
            order.setOrder_id(order_id);
            order.setOrder_date(order_date);
        }

        dbc.close();

    }

    private String getOrder_date(int order_id) throws SQLException
    {
        String query = "SELECT `order_date` FROM `order`"
                + " WHERE (`order_id` = '" + order_id + "');";

        String order_date = "";

        PreparedStatement statement = dbc.preparedStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            order_date = rs.getString("order_date");

        }

        return order_date;
    }

    public String orderShipped(int order_id) throws DataException, SQLException
    {
        dbc.open();

        String query = "UPDATE `LegoHouse`.`order`"
                + "SET `shipped` = CURRENT_TIMESTAMP WHERE (`order_id` =" + order_id + ");";

        String query2 = "SELECT `shipped` FROM `order`"
                + " WHERE (`order_id` = '" + order_id + "');";

        String shipped = "";

        PreparedStatement statement = dbc.preparedStatement(query);

        statement.executeUpdate();

        PreparedStatement statement2 = dbc.preparedStatement(query2);
        ResultSet rs = statement2.executeQuery();
        if (rs.next())
        {
            shipped = rs.getString("shipped");
        }

        dbc.close();

        return shipped;
    }

    public Order getOrder(int order_id) throws SQLException, DataException
    {
        Order order = null;

        dbc.open();
        String query = "SELECT * FROM LegoHouse.`order`"
                + "WHERE (`order_id` =" + order_id + ");";

        int id = 0;
        int user_id = 0;
        User user = null;
        String order_date = "";
        String shipped = "";
        int length = 0;
        int width = 0;
        int height = 0;

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {
            id = rs.getInt("order_id");
            user_id = rs.getInt("user_id");
            user = getUser(user_id);
            order_date = rs.getString("order_date");
            shipped = rs.getString("shipped");
            length = rs.getInt("length");
            width = rs.getInt("width");
            height = rs.getInt("height");

            order = new Order(id, user, width, length, height, order_date, shipped);
        }

        dbc.close();
        return order;
    }

    public List<Order> getOrders(int user_id) throws SQLException, DataException
    {
        List<Order> orders = new ArrayList();
        User user = um.getUser(user_id);

        dbc.open();
        String query = "SELECT * FROM LegoHouse.`order`"
                + "WHERE (`user_id` =" + user_id + ");";

        int order_id = 0;
        String order_date = "";
        String shipped = "";
        int length = 0;
        int width = 0;
        int height = 0;

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {
            order_id = rs.getInt("order_id");
            order_date = rs.getString("order_date");
            shipped = rs.getString("shipped");
            length = rs.getInt("length");
            width = rs.getInt("width");
            height = rs.getInt("height");

            orders.add(new Order(order_id, user, width, length, height, order_date, shipped));
        }

        dbc.close();
        return orders;
    }
    
    private User getUser(int user_id) throws DataException, SQLException
    {
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

        return user;
    }

    public List<Order> getAllOrders() throws SQLException, DataException
    {
        List<Order> orders = new ArrayList();

        dbc.open();
        String query = "SELECT * FROM LegoHouse.`order`;";

        int order_id = 0;
        int user_id = 0;
        User user = null;
        String order_date = "";
        String shipped = "";
        int length = 0;
        int width = 0;
        int height = 0;

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {
            order_id = rs.getInt("order_id");
            user_id = rs.getInt("user_id");
            user = getUser(user_id);
            order_date = rs.getString("order_date");
            shipped = rs.getString("shipped");
            length = rs.getInt("length");
            width = rs.getInt("width");
            height = rs.getInt("height");

            orders.add(new Order(order_id, user, width, length, height, order_date, shipped));
        }

        dbc.close();
        return orders;
    }

    public static void main(String[] args) throws DataException, SQLException
    {
        DBFacade db = DBFacade.getInstance();

        db.orderShipped(23);
    }
}
