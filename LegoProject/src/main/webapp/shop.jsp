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
            HEIGTH (bricks) <input type ="number" name ="height" value="0" min="6" required> 
            &nbsp;&nbsp;
            LENGTH (dots) <input type ="number" name ="length" value="0"  min="12" required> 
            &nbsp;&nbsp;
            WIDTH (dots) <input type ="number" name ="width" value="0" min="12" required>     

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
