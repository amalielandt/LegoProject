/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DataException;
import Function.FunctionManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sofieamalielandt
 */
@WebServlet(name = "Legohouse", urlPatterns =
{
    "/Legohouse"
})
public class FrontController extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            FunctionManager manager = FunctionManager.getInstance();

            String path = request.getParameter("command");
            Command command = CommandController.from(path);

            String target = command.execute(request, response, manager);
            RequestDispatcher dispatcher = request.getRequestDispatcher(target);
            dispatcher.forward(request, response);

        } catch (CommandException ce)
        {
            request.setAttribute("message", ce.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(ce.getTarget());
            dispatcher.forward(request, response);
            
        } catch (IOException | ServletException | DataException e)
        {
            request.setAttribute("message", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        service(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        service(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}
