<%-- 
    Document   : customer
    Created on : 21-03-2019, 18:57:56
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
                List<Order> orders = (List<Order>) session.getAttribute("orders");
                for (Order o : orders)
                {
                    out.println("<li><a href=\"Legohouse?command=customerorder&selected=" + o.getOrder_id() + "\">" + o + "</a></li>");
                }
            %>
        </ul>
    </center>
</form>
</body>
</html>
