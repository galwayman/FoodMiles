<%-- 
    Document   : displayUsers
    Created on : 04-Feb-2021, 13:25:19
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./DisplayUsers/displayUsers.css">
        <link rel="stylesheet" href="displayUsers.css">
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    <header class="view-users-header">
        
        <div class="container">
        <div class="row">
          
            <div class="col-1" onclick="goBack()">
                <i class="icon-arrow-left"></i>
            </div>
            <div class="col-11">
               View Users
            </div>
          

        </div>
        </header>
</head>
<body>

    <div class="container display-user-title">
        <div class="row">
            <div class="col-1">
                ID
            </div>
            <div class="col-4">
                User Name
            </div>
            <div class="col-4">
                User Email
            </div>
            <div class="col-3">

            </div>

        </div>

    </div>

    <c:forEach var="u" items="${users}">
        <div class="container">
            <div class="row" style="border-top: 1px solid #2d6d2d; padding-bottom: 10px; padding-top: 11px;">
                <div class="col-1">
                    ${u.userID}
                </div>
                <div class="col-4">
                    ${u.userName}
                </div>
                <div class="col-4" style="overflow: hidden; text-overflow: ellipsis;">
                    ${u.userEmail}
                </div>
                <div class="col-3">
                    <form method="post" action="./EditUserAdmin/editUser.jsp">
                        <input type="hidden" name="userID" value="${u.userID}">
                        <input type="hidden" name="userName" value="${u.userName}">
                        <input type="hidden" name="userEmail" value="${u.userEmail}">
                        <button type="submit" style=" background: #2d6d2d;
                                color: white;
                                font-size: 20px;" class="btn modify-button">
                            <i class="icon-edit"></i>
                        </button>
                    </form>
                </div>

            </div>

        </div>
    </c:forEach> 



</body>
</html>
