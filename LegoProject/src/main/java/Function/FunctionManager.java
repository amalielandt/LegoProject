package Function;

import Data.DBFacade;
import Data.DataException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sofieamalielandt
 */
public class FunctionManager
{

    private static FunctionManager instance = null;
    private DBFacade db;
    private Calculate c;

    public FunctionManager() throws DataException
    {
        db = DBFacade.getInstance();
        c = new Calculate();
    }

    public static FunctionManager getInstance() throws DataException
    {
        if (instance == null)
        {
            instance = new FunctionManager();
        }
        return instance;
    }

    public User login(String email, String password) throws DataException, SQLException
    {
        return db.login(email, password);
    }

    public String createUser(User user) throws DataException, SQLException
    {
        String res = "";
        List<User> users = db.getUsers();

        for (User u : users)
        {
            if (u.getEmail().equals(user.getEmail()))
            {
                res = "Email is already in use";
            }
        }

        if (res.isEmpty())
        {
            db.createUser(user);

            res = "User is now created";
        }

        return res;
    }

    public void isShipped(Order order) throws SQLException, DataException
    {
        String shipped = db.orderShipped(order.getOrder_id());
        order.setShipped(shipped);
    }

    public ItemList calcLegoHouse(Order order)
    {
        HashMap<String, Integer> legohouse = c.calcHouse(order);

        if (legohouse != null)
        {
            ItemList lego = new ItemList(legohouse);
            return lego;
        }

        return null;
    }

    public String placeOrder(Order order) throws DataException, SQLException
    {
        String res = "";

        if (order != null)
        {
            db.placeOrder(order);
            res = "Thank you for your order";
        } else
        {
            res = "Your order could not be placed";
        }

        return res;

    }
    
    public Order getOrder(int order_id) throws SQLException, DataException
    {
        return db.getOrder(order_id);
    }
    
    public List<Order> getOrders(User user) throws SQLException, DataException
    {
        return db.getOrders(user.getUser_id());
    }
    
    public List<Order> getAllOrders() throws SQLException, DataException
    {
        return db.getAllOrders();
    }
}
