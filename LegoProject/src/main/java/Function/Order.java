/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Data.DBFacade;
import Data.DataException;

/**
 *
 * @author sofieamalielandt
 */
public class Order
{

    private DBFacade db = null;
    private int order_id;
    private User user;
    private int width;
    private int length;
    private int height;
    private String order_date;
    private String shipped;

    public Order(User user, int width, int length, int height) throws DataException
    {
        this.user = user;
        this.width = width;
        this.length = length;
        this.height = height;
        this.db = DBFacade.getInstance();
    }

    public Order(int order_id, User user, int width, int length, int height, String order_date, String shipped) throws DataException
    {
        this.order_id = order_id;
        this.user = user;
        this.width = width;
        this.length = length;
        this.height = height;
        this.order_date = order_date;
        this.shipped = shipped;
        this.db = DBFacade.getInstance();
    }

    public int getOrder_id()
    {
        return order_id;
    }

    public User getUser()
    {
        return user;
    }

    public int getWidth()
    {
        return width;
    }

    public int getLength()
    {
        return length;
    }

    public int getHeight()
    {
        return height;
    }

    public String getOrder_date()
    {
        return order_date;
    }

    public String getShipped()
    {
        if (shipped == null)
        {
            return "Order is not shipped yet";
        } else
        {
            return shipped;
        }
    }

    public void setOrder_id(int order_id)
    {
        this.order_id = order_id;
    }

    public void setOrder_date(String order_date)
    {
        this.order_date = order_date;
    }

    public void setShipped(String shipped)
    {
        this.shipped = shipped;
    }

    @Override
    public String toString()
    {
        return "ORDER: " + order_id + ", DATE: " + order_date;
    }

}
