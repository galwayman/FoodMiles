<%-- 
    Document   : AddNewJourney
    Created on : 08-Mar-2021, 21:12:27
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
        <link rel="stylesheet" href="addNewJourneyLeg.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
       
    <header class="edit-country-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="window.location = '../adminHomePage.jsp'">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Add New Journey Leg
                </div>
            </div>
    </header>


</head>
    <body>




        <form style="margin-left: 10%" action="../AddNewLeg" method="get">
            <div class="form-group">
                <label for="startC" class="food-item-add">Select Start Country</label>
                <select class="form-control selectjl" name="startC" id="startC">
                    <c:forEach var="s" items="${startCountriesJourney}">
                        <option value="${s.startCountryID} ">
                            ${s.startCountryName}
                        </option>
                    </c:forEach>

                </select>
                <br>

            </div>

            <div class="form-group">
                <label for="endC" class="food-item-add">Select End Country</label>
                <select class="form-control selectjl" name="endC" id="endC">
                    <c:forEach var="s" items="${endCountriesJourney}">
                        <option value="${s.endCountryID} ">
                            ${s.endCountryName}
                        </option>
                    </c:forEach>
                </select>
                <br>
            </div>

            <div class="form-group">
                <label for="tu" class="food-item-add">Add Delivery Type</label>
                <select class="form-control selectjl" name="tu" id="tu">
                    <c:forEach var="s" items="${deliveryTypeJourney}">
                        <option value="${s.deliveryID} ">
                            ${s.deliveryName}
                        </option>
                    </c:forEach>
                </select>
                <br>
            </div>

            <label for="dt" class="food-item-add">Distance Traveled KM</label>
            <input type="text" class="form-control selectjl" name="dt" id="dt" value="504">

            <button type="submit" class="btn add-button">Add</button>           

        </form>


    </body>
</html>
