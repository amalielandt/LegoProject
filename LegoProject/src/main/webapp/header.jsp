<%-- 
    Document   : header
    Created on : 21-03-2019, 17:40:08
    Author     : sofieamalielandt
--%>
<%@page import="Function.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>LEGOHOUSE</title>
        <style>
            .menu ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: whitesmoke;
                position: fixed;
                top: 5%;
                left: 0;
                width: 100%;  
                height: 80px;
                font-family: Avenir Next;
            }
            .menu li p {
                float: right;
                display: block;
                color: black;
                text-align: center;
                padding: 15px 15px;
                text-decoration: none;
                height: 80px;
            }

            .menu li button {
                float: right;
                display: inline-block;
                text-align: center;
                background-color: whitesmoke;
                text-decoration: none;
                padding: 20px 20px;
                position: static; width: 150px; 
                color: black;
                border: none;
                font-family: Avenir Next;
                font-size: 15px;
                height: 80px;
            }
            .menu li a {
                float: left;
                display: block;
                color: black;
                text-align: center;
                padding: 0px 16px;
                text-decoration: none;  
                height: 80px;
                display: -webkit-flex;
                -webkit-align-items: center; 
            }
            .menu li a img {
                display: block;
                text-align: center;
                padding: 0px 10px;
                width: 50px;
                height: 50px;
                text-decoration: none;  
                display: -webkit-flex;
                -webkit-align-items: center; 
            }

            .menu li a:hover, li a img:hover, .dropdown:hover {
                opacity: 0.6;
            }

            .menu button:hover {
                color: grey;
                border-radius: 0px;
            }

            #menu img{
                position: fixed;
                left:0;
                top: 16%;
            }

            #cart li a img {
                display: block;
                text-align: center;
                padding: 0px 8px;
                width: 40px;
                height: 40px;
                text-decoration: none;  
                display: -webkit-flex;
                -webkit-align-items: center; 
            }

            #order ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                background-color: rgba(245, 245, 245, 0.8);
                width: 40%; 
                border-radius: 10px;
            }

            #order li h1 {
                display: block;
                color: black;
                text-align: center;
                padding: 20px 5px;
                text-decoration: none;
            }
            #order li a {
                display: block;
                text-align: center;
                color: black;
                padding: 20px 16px;
                text-decoration: none;   
            }
            #order li a:hover {
                background-color: rgba(251, 13, 27, 1);
                color: white;
                border-radius: 10px;
            }

        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <form action="Legohouse" method="post">
            <center class="menu">
                <ul>
                    <li> <a href="shop.jsp"><img src="images/LEGO_Logo.png"></a></li>
                    <li>
                        <%
                            out.println("<a href=\"Legohouse?command=" + user.getRole() + "\"><img src=\"images/legohead.png\"></a>");
                        %>
                    </li>

                    <li><button name="command" value="logout">LOGOUT</button></li>
                    <center id="cart">
                        <li><a href="shoppingcart.jsp"><img src="images/shoppingbag.png" width="5%" height="5%"></a></li>
                    </center>
                    <li><p>
                            <%
                                out.println(user.getEmail().toUpperCase() + "&nbsp;&nbsp");
                            %>
                        </p>
                    </li>
                </ul>
            </center>
        </form>
        <br><br><br><br>
    <center id="menu">
        <img src="images/legobricks.png" width="100%">
    </center>
    <br><br><br><br><br><br><br><br><br><br>


