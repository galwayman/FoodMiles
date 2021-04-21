<%-- 
    Document   : login
    Created on : 18-Feb-2021, 10:08:51
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>
            FoodMiles Home Page
        </title>
        <meta charset="UTF-8">
        <meta name="viewport" 
              content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" 
              href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
              crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="homeStyles.css">
        <link rel="stylesheet" href="./Login Page/login.css">
    </head>
    <body class="homescreen-body">

        <div class="login-white-box">

            <h1 class="title-login gradient-text">
                FOODMILES
            </h1>
            <form 
                id="form" 
                name="form" 
                class="login-forms" 
                action="loginDirect" 
                method="get" >
                <div class="form-group">
                    <label for="userEmailLogin" 
                           class="login-inputs label-login">
                        Email
                    </label>
                    <input type="email" 
                           name="userEmailLogin" 
                           class="form-control input-login" 
                           id="userEmailLogin" 
                           aria-describedby="emailHelp"
                           value="Jack@Jack.com" 
                           placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="userPasswordLogin" 
                           class="login-inputs label-login-pass">
                        Password
                    </label>
                    <input type="password" 
                           name="userPasswordLogin" 
                           class="form-control input-login" 
                           id="userPasswordLogin" 
                           value="password" 
                           placeholder="Password">
                </div>

                <input type="submit" class="btn login-submit"></input> 
            </form>

            <div class="register-button" 
                 stye="cursor:pointer !important;" 
                 onclick="window.location = 'UserReg/userReg.jsp'">
                    Register
            </div>
        </div>

    </body>
</html>
