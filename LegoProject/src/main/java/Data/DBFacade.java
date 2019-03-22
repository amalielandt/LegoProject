/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Function.Order;
import Function.User;
import java.util.List;

/**
 *
 * @author sofieamalielandt
 */
public class DBFacade
{

    private static DBFacade instance = null;
    private DBConnector dbc = new DBConnector();
    private DataSourceMySql dataSource = new DataSourceMySql();
    private UserMapper um = new UserMapper(dbc);
    private OrderMapper om = new OrderMapper(dbc, um);

    private DBFacade() throws DataException
    {
        dbc.setDataSource(dataSource.getDataSource());
    }

    public static DBFacade getInstance() throws DataException
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }

    public User login(String email, String password) throws DataException
    {
        return um.login(email, password);
    }

    public void createUser(User user) throws DataException
    {
        um.createUser(user);
    }

    public User getUser(int user_id) throws DataException
    {
        return um.getUser(user_id);
    }
    
    public List<User> getUsers() throws DataException
    {
        return um.getUsers();
    }

    public void placeOrder(Order order) throws DataException
    {
        om.placeOrder(order);

    }

    public String orderShipped(int order_id) throws DataException
    {
        return om.orderShipped(order_id);
    }

    public Order getOrder(int order_id) throws DataException
    {
        return om.getOrder(order_id);
    }
    
    public List<Order> getOrders(int user_id) throws DataException
    {
        return om.getOrders(user_id);
    }
    
    public List<Order> getAllOrders() throws DataException
    {
        return om.getAllOrders();
    }
}
