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
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class EmployeeOrderCommand implements Command
{

    private String target;

    public EmployeeOrderCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException, SQLException
    {
        HttpSession session = request.getSession();
        int order_id = Integer.parseInt(request.getParameter("selected"));
        Order order = manager.getOrder(order_id);
        session.setAttribute("oldorder", order);
        ItemList list = manager.calcLegoHouse(order);
        session.setAttribute("oldlist", list);

        return target;
    }

}
