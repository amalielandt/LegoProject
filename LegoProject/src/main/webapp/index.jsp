<%-- 
    Document   : login
    Created on : 21-03-2019, 12:36:12
    Author     : sofieamalielandt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>LEGOHOUSE</title>  
        <style>
            .index input[type=radio]{
                display: inline;
               align-items: center;
            }

            .index span {
                position:absolute;
                left: 47%;
            }
        </style>
    </head>
    <body>
        <%
            String message = (String) session.getAttribute("message");
        %>
        <br><br>
    <center class="index" id="index"> 
        <img src="images/people.png" width="20%">
        <div>
            <p>ENTER EMAIL AND PASSWORD</p><br>   
            <form action="Legohouse" method="post">
                EMAIL <input type ="text" name ="email" value="" minlength="4" required>
                <br><br>
                PASSWORD <input type ="password" name ="password" value="" minlength="4" required>
                <br><br>
                <button name="command" value="login">Login</button><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio" name="role" id="customer" value="customer" checked="checked"><span>CUSTOMER</span></label>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio" name="role" id="employee" value="employee"><span>EMPLOYEE</span></label><br><br>
                <button name="command" value="createuser">Create user</button>

                <%
                    if (message != null)
                    {
                        out.println("<br><br><br>" + message);
                        session.removeAttribute("message");
                    }
                %>
            </form> 
        </div> 

    </center>


</body>
</html>

