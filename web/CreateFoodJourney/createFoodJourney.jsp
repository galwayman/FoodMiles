<%-- 
    Document   : createFoodJourney
    Created on : 19-Mar-2021, 22:49:57
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
        <link rel="stylesheet" href="createFoodJourney.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script>
            function goBack() {
                onclick = "window.location = './index.jsp'"
            }
        </script>
    <header class="edit-country-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Add Country to Food Item
                </div>
            </div>
    </header>


</head>

<body>

    <form style="margin-left: 10%" action="../createNewJourney" method="post">
        <div class="form-group">
            <label for="sfi" class="food-item-add">Select Food Item</label>
            <select class="form-control selectjl" name="sfi" id="sfi">

                <c:forEach var="s" items="${foodForFoodJourney}">
                    <option value="${s.getFoodItemID()} ">
                        ${s.getFoodName()}
                    </option>
                </c:forEach>

            </select>
            <br>

        </div>


        <div class="form-group">
            <label for="sj" class="food-item-add">Select Journey</label>
            <select class="form-control selectjl" name="sj" id="sj">

                <c:forEach var="s" items="${countryForFoodJourney}">
                    <option value="${s} ">
                        ${s}
                    </option>
                </c:forEach>  
            </select>
            <br>

        </div>

        <button type="submit" class="btn add-button">Add</button>           

    </form>


</body>


</html>
