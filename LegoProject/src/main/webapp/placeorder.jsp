<%-- 
    Document   : placeorder
    Created on : 21-03-2019, 17:19:25
    Author     : sofieamalielandt
--%>

<%@page import="Function.Order"%>
<%@page import="Function.ItemList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<%@include file = "header.jsp" %>
<%            
    ItemList list = (ItemList) session.getAttribute("list");
    Order order = (Order) session.getAttribute("order");
    String message = (String) session.getAttribute("message");
%>
<center id="shop">
    <div>
        <form action="Legohouse" method="post">
            <table> 
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
                        
                        session.removeAttribute("list");
                        session.removeAttribute("order");
                    }
                %>
            </table>
            <%
                out.println("<br>" + message);
                session.removeAttribute("message");
            %>
            <br><br>
            <button name="command" value="back">Go back</button>
        </form>
    </div>
</center>
</body>
</html>
