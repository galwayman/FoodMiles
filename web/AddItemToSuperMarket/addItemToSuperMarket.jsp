<%-- 
    Document   : addItemToSuperMarket
    Created on : 01-Mar-2021, 22:29:23
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
        <link rel="stylesheet" href="./AddItemToSuperMarket/addItemToSuperMarket.css">
        <link rel="stylesheet" href="addItemToSuperMarket.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
       
    <header class="edit-country-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="window.location = '../index.jsp'">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Add Item To SuperMarket
                </div>
            </div>
    </header>


</head>
<body>


    <form action="AddFoodToSuperMarket" class="float-div" method="post">
        <div class="form-group">
            <label class="food-item-add" for="sel1">Select Supermarket</label>
            <select class="form-control selFI" name="selectSuperMarketForFood" id="selectSuperMarketForFood">
                <c:forEach var="s" items="${superMarketAddAdmin}">
                    <option value="${s.superMarketID} ">
                        ${s.superMarketID} 
                        ${s.superMarketName}
                    </option>
                </c:forEach>

            </select>
            <br>

        </div>

        <div class="form-group">
            <label class="food-item-add" for="sel1">Select Food Item</label>
            <select class="form-control selFI" name="selectFoodItemToBeAdded" id="selectFoodItemToBeAdded">
                <c:forEach var="s" items="${foodItemsAdmin}">
                    <option value="${s.foodItemID} ">
                        ${s.foodItemID} 
                        ${s.foodName}
                    </option>
                </c:forEach>
            </select>
            <br>
        </div>

        <button type="submit" class="btn add-country">Submit</button>           

    </form>
</body>
</html>
