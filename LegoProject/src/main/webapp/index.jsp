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
            .index div {
                border-style: none;
                border-radius: 10px;
                padding: 25px;
                box-sizing: border-box;
                width: 400px;
                background-color: rgba(245, 245, 245, 0.8);
                text-align: center; 
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
            <p>ENTER EMAIL AND PASSWORD</p>
            <form action="Legohouse" method="post">
                <input type ="text" name ="email" placeholder="EMAIL" value="" minlength="4" required>
                <br><br>
                <input type ="password" name ="password" placeholder="PASSWORD" value="" minlength="4" required>
                <br><br>
                <button name="command" value="login">Login</button><br><br>
                <label><input type="radio" name="role" id="customer" value="customer" checked="checked"><span>CUSTOMER</span></label>
                <label><input type="radio" name="role" id="employee" value="employee"><span>EMPLOYEE</span></label><br><br>
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

