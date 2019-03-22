/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DataException;
import Function.FunctionManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class LogoutCommand implements Command
{
    private String target;
    
    public LogoutCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException, SQLException
    {
       HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("orders");
        session.removeAttribute("allorders");
        session.removeAttribute("order");
        session.removeAttribute("list");
        session.removeAttribute("message");
        
        return target;
    }
    
}
