<%-- 
    Document   : modifyCartItem
    Created on : 10-Apr-2021, 21:58:11
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Select Food Item</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./ModifyCartItem/modifyCartItem.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> ${f.foodName}</title>
    <header class="view-food-header">
        ${f.foodName}
    </header>
</head>
<body class="default-background">

    <div class="viewFoodImage">
        <img src="data:image/jpg;base64,${f.foodItemPic}" class="food-pic"/>
    </div>
    <div>

        <form id="form" name="form" action="./UpdateCart" method="get">
            <label>
                <input type="hidden" name="addUserIDCart" id="addUserIDCart" value="${uLog.getUserID()}"/>
                <span class="small"></span>
            </label>     
            <label>
                <input type="hidden" name="addFoodItemIDCart" id="addFoodItemIDCart" value="${f.foodItemID}"/>
                <span class="small"></span>
            </label> 

            <label for="addFoodQTYCart"class="text-info-view-food">Select QTY</label>
            <select class="form-control option-view-food" id="addFoodQTYCart" name="addFoodQTYCart">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>  

            <label for="addJourney" class="text-info-view-food">Select Origin Country</label>
            <select class="form-control option-view-food" id="addJourney" name="addJourney">
                <c:forEach var="fc" items="${foodCountry}">
                    <option value="${fc.journeyID} ">${fc.foodCountryName} </option>
                </c:forEach>
            </select>            
            

            <button type="submit" class="add-food-item"><i class="fas fa-shopping-cart"></i></button>
        </form>
    </div>

</body>
</html>
