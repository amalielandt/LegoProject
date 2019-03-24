/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DataException;
import Function.FunctionManager;
import Function.Order;
import Function.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class CustomerCommand implements Command
{

    private String target;

    public CustomerCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException
    {

        HttpSession session = request.getSession();

        if (session.getAttribute("orders") == null)
        {
            User user = (User) session.getAttribute("user");
            List<Order> orders = manager.getOrders(user);
            session.setAttribute("orders", orders);
        }

        return target;
    }

}
