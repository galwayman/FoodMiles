<%-- 
    Document   : editUser
    Created on : 20-Feb-2021, 23:13:37
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
        <link rel="stylesheet" href="editUser.css">
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    <header class="edit-user-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Edit User
                </div>


            </div>
    </header>
</head>

<body>
    <form id="form" name="form" action="../UpdateUserAdmin" method="post">
        <label>
            <input type="hidden" name="userID" id="userID" value="${param.userID}"/>
        </label>   
        <div>
            <label class="edit-user-label">
                <span class="small">
                    Enter Name
                </span>
            </label>
            <input type="text" name="userName" id="userName" value="${param.userName}"/>
        </div>

        <div>
            <label class="edit-user-label">
                <span class="small">
                    Enter Email
                </span>
            </label>
            <input type="text" name="userEmail" id="userEmail" value="${param.userEmail}"/>
        </div>
       


        <div style="text-align: center;margin-top: 10px;">

            <button type="submit" class="btn edit-user-btn">
                Update User
            </button>  

        </div>



    </form>
</body>

</html>
