<%-- 
    Document   : shop
    Created on : 21-03-2019, 12:16:31
    Author     : sofieamalielandt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<%            String message = (String) session.getAttribute("message");
%>
<center id="shop"> 
    <div>       
        <form action="Legohouse" method="post">
            LENGTH <input type ="number" name ="length" value="0"  min="5" required> (dots)
            &nbsp;&nbsp;
            WIDTH <input type ="number" name ="width" value="0" min="5" required> (dots)
            &nbsp;&nbsp;
            HEIGTH <input type ="number" name ="height" value="0" min="1" required> (bricks)

            <%
                if (message != null)
                {
                    out.println("<br><br><br>" + message);
                    session.removeAttribute("message");
                }
            %>

            <br><br><br>
            <button name="command" value="shoppingcart">Add to cart</button>

        </form>
    </div> 
</center>


</body>
</html>
