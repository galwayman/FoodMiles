<%-- 
    Document   : viewFoodItemAdmin
    Created on : 12-Mar-2021, 22:40:56
    Author     : coola
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 
              href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./ViewFoodItemAdmin/viewFoodItemAdmin.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>

        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    <header class="default-header-foodmiles" style=" font-size: 25px;
    padding-top: 10px;
    padding-bottom: 10px;">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    View Food Items
                </div>
            </div>
        </div>
    </header>

    </head>
        
<body>


    <h1 class="countries-title"></h1>

    <div class="container display-country-title">
        <div class="row">

            <div class="col-3">
                Food ID
            </div>
            <div class="col-6">
                Food Name
            </div>
            <div class="col-3">
               Picture
            </div>

        </div>

    </div>

<c:forEach var="f" items="${foodItemsAdmin}">
    <div class="container">
        <div class="row" style="border-top: 1px solid #2d6d2d; padding-bottom: 10px; padding-top: 11px;">
            <div class="col-3" style="padding-top:2rem">
                ${f.getFoodItemID()}
            </div>
            <div class="col-6" style="padding-top:2rem">
                ${f.getFoodName()}
            </div>
            <div class="col-3">
                <img src="data:image/jpg;base64,${f.getFoodItemPic()}" style="max-width: 5rem;
                    padding-top: 3px;    max-height: 15rem;"/>
            </div>
        </div>
    </div>
</c:forEach> 

<button type="button" 
        class="btn add-country" 
        onclick="window.location = './AddNewItemAdmin/addNewItemAdmin.jsp'">
    Add New Item
</button>


</body>
</html>
