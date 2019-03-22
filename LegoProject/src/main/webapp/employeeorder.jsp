<%-- 
    Document   : employeeorder
    Created on : 22-03-2019, 12:56:38
    Author     : sofieamalielandt
--%>

<%@page import="Function.ItemList"%>
<%@page import="Function.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<%    Order order = (Order) session.getAttribute("oldorder");
    ItemList list = (ItemList) session.getAttribute("oldlist");
%>
<form action="Legohouse" method="post">
    <center id="shop">
        <div>
            <%
                out.println("<br><b>ORDER: </b>" + order.getOrder_id() + "&nbsp;&nbsp;&nbsp;&nbsp;<b>DATE: </b>" + order.getOrder_date() + "<br>");
                out.println("<b>USER ID: </b>" + order.getUser().getUser_id() + "<b> - EMAIL: </b>" + order.getUser().getEmail().toUpperCase());
                out.println("<br><br><b>SHIPPED: </b>" + order.getShipped() + "<br><br>");
            %>
            <table id="shop"> 
                <tr>
                    <th><b>MEASUREMENTS</b></th>
                    <th><img src="images/2x1.png" width="70%"></th>
                    <th><img src="images/2x2.png" width="50%"></th>
                    <th><img src="images/2x4.png" width="20%"></th>
                </tr>
                <%
                    if (list != null)
                    {
                        out.println("<tr>");
                        out.println("<td>" + order.getHeight() + "x" + order.getLength() + "x" + order.getWidth() + "</td>");
                        out.println("<td>" + list.getLegohouse().get("2x1") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getLegohouse().get("2x2") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getLegohouse().get("2x4") + "&nbsp;&nbsp;stk. </td>");
                        out.println("</tr>");
                    }
                %>
            </table>
            
            <%
                if(order.getShipped().equals("Order is not shipped yet"))
            out.println("<br><br><button name=\"command\" value=\"shipped\">Order is shipped</button>");
                    %>
            </form>
        </div>
    </center>
</body>
</html>
