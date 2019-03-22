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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class EmployeeCommand implements Command
{

    private String target;

    public EmployeeCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException, SQLException
    {
        HttpSession session = request.getSession();

        if (session.getAttribute("allorders") == null)
        {
            List<Order> allorders = manager.getAllOrders();
            session.setAttribute("allorders", allorders);
        }

        return target;
    }

}
