/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DataException;
import Function.FunctionManager;
import Function.Order;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class PlaceOrderCommand implements Command
{

    private String target;

    public PlaceOrderCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException, SQLException
    {
        HttpSession session = request.getSession();

        Order order = (Order) session.getAttribute("order");
        String message = manager.placeOrder(order);
        session.setAttribute("message", message);

        if (message.equals("Thank you for your order"))
        {
            session.removeAttribute("orders");
            session.removeAttribute("allorders");
        }
        
        return target;
    }

}
