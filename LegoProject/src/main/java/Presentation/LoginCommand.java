/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DataException;
import Function.FunctionManager;
import Function.User;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class LoginCommand implements Command
{

    private String target;

    LoginCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException, SQLException
    {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = manager.login(email, password);

        if (user != null)
        {
            session.setAttribute("user", user);
            
            return target;
        } else
        {

        session.setAttribute("message", "Wrong password or username");
        return "index.jsp";
        }
    }

}
