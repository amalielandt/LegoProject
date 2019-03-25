<%-- 
    Document   : error
    Created on : 22-03-2019, 12:37:50
    Author     : sofieamalielandt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
        <%
            String message = (String) request.getAttribute("message");
        %>
    <center id="shop"> 
        <div>       
            <form action="Legohouse" method="post">
                <%
                    if (message != null)
                    {
                        out.println("<br><br><br>" + message);
                    }
                %>

                <br><br><br>
                <button name="command" value="back">Go back</button>

            </form>
        </div> 
    </center>
</body>
</html>

