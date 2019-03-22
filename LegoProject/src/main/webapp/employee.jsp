<%-- 
    Document   : employee
    Created on : 22-03-2019, 11:00:46
    Author     : sofieamalielandt
--%>

<%@page import="java.util.List"%>
<%@page import="Function.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<%@include file = "header.jsp" %>
<form action="Legohouse" method ="POST"> 
    <center id="order">
        <ul>
            <li><p><h1>YOUR PREVIOUS ORDERS</h1></p></li>
            <% 
                List<Order> allorders = (List<Order>) session.getAttribute("allorders");
                for (Order o : allorders)
                {
                    out.println("<li><a href=\"Legohouse?command=employeeorder&selected=" + o.getOrder_id() + "\">" + o + "</a></li>");
                }
            %>
        </ul>
    </center>
</form>
</body>
</html>
