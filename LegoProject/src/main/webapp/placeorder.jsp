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
                    <th><b>Measurements</b></th>
                    <th><b>2x1</b></th>
                    <th><b>2x2</b></th>
                    <th><b>2x4</b></th>
                </tr>
                <%
                    if (list != null)
                    {
                        out.println("<tr>");
                        out.println("<td>" + order.getHeight() + "x" + order.getLength() + "x" + order.getWidth() + "</td>");
                        out.println("<td>" + list.getLegohouse().get("2x1") + "</td>");
                        out.println("<td>" + list.getLegohouse().get("2x2") + "</td>");
                        out.println("<td>" + list.getLegohouse().get("2x4") + "</td>");
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
