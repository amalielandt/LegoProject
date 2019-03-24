/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DataException;
import Function.FunctionManager;
import Function.ItemList;
import Function.Order;
import Function.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class ShoppingcartCommand implements Command
{

    private String target;

    ShoppingcartCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException
    {
        HttpSession session = request.getSession();

        String length_input = request.getParameter("length");
        String width_input = request.getParameter("width");
        String height_input = request.getParameter("height");
        User user = (User) session.getAttribute("user");

        if (length_input != null && width_input != null && height_input != null)
        {
            int length = Integer.parseInt(length_input);
            int width = Integer.parseInt(width_input);
            int height = Integer.parseInt(height_input);

            Order order = new Order(user, width, length, height);
            session.setAttribute("order", order);

            ItemList list = manager.calcLegoHouse(order);

            if (list != null)
            {
                session.setAttribute("list", list);
                return target;
            }

        } else
        {
            return target;
        }
        return null;

    }
}
