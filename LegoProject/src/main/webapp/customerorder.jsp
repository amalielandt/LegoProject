<%-- 
    Document   : customerorder
    Created on : 22-03-2019, 11:43:19
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
            <%out.println("<br><b>ORDER: </b>" + order.getOrder_id() + "&nbsp;&nbsp;&nbsp;&nbsp;<b>DATE: </b>" + order.getOrder_date() + "<br>");%>
            <%out.println("<br><b>SHIPPED: </b>" + order.getShipped() + "<br><br>");%>
            <table id="shop"> 
                <tr>
                    <th><b>WALLS</b></th>
                    <th><img src="images/2x1.png" width="70%"></th>
                    <th><img src="images/2x2.png" width="50%"></th>
                    <th><img src="images/2x4.png" width="20%"></th>
                </tr>
                <%
                    if (list != null)
                    {
                        out.println("<tr>");
                        out.println("<td>Wall 1 (" + list.getWall1().get("height") + "x" + list.getWall1().get("length") + ")</td>");
                        out.println("<td>" + list.getWall1().get("2x1") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getWall1().get("2x2") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getWall1().get("2x4") + "&nbsp;&nbsp;stk. </td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td>Wall 2 (" + list.getWall2().get("height") + "x" + list.getWall2().get("length") + ")</td>");
                        out.println("<td>" + list.getWall2().get("2x1") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getWall2().get("2x2") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getWall2().get("2x4") + "&nbsp;&nbsp;stk. </td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td>Wall 3 (" + list.getWall1().get("height") + "x" + list.getWall1().get("length") + ")</td>");
                        out.println("<td>" + list.getWall1().get("2x1") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getWall1().get("2x2") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getWall1().get("2x4") + "&nbsp;&nbsp;stk. </td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td>Wall 4 (" + list.getWall2().get("height") + "x" + list.getWall2().get("length") + ")</td>");
                        out.println("<td>" + list.getWall2().get("2x1") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getWall2().get("2x2") + "&nbsp;&nbsp;stk. </td>");
                        out.println("<td>" + list.getWall2().get("2x4") + "&nbsp;&nbsp;stk. </td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td><b>Total (" + order.getHeight() + "x" + order.getLength() + "x" + order.getWidth() + ")</b></td>");
                        out.println("<td><b>" + list.getLegohouse().get("2x1") + "&nbsp;&nbsp;stk. </b></td>");
                        out.println("<td><b>" + list.getLegohouse().get("2x2") + "&nbsp;&nbsp;stk. </b></td>");
                        out.println("<td><b>" + list.getLegohouse().get("2x4") + "&nbsp;&nbsp;stk. </b></td>");
                        out.println("</tr>");
                    }
                %>
            </table>
            </form>
        </div>
    </center>
</body>
</html>