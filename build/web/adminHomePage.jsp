<%-- 
    Document   : adminHomePage
    Created on : 20-Feb-2021, 22:01:17
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>

        <title>FoodMiles Admin Home Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

        <link rel="stylesheet" href="homeStyles.css">
        <header class="food-miles-header">Admin Home Page</header>
</head>


<body scroll="no" class="default-background homescreen-body">

    <div style="margin-top: 10px;
         margin-left: 10px;
         margin-right: 10px;">

        <div class="container-fluid">

            <div class="row">
                <div class="col-sm-4" style="margin-bottom: 10px" onclick="window.location = 'getFoodItemsAdmin'">
                    <button type="button" class="btn btn-primary btn-lg btn-block adminButtons">
                        Add Food
                    </button>
                </div>
                <div class="col-sm-4" style="margin-bottom: 10px">
                    <button type="button" class="btn btn-primary btn-lg btn-block adminButtons" onclick="window.location = 'getUsers'">
                        View Users
                    </button>
                </div>
                <div class="col-sm-4" style="margin-bottom: 10px" onclick="window.location = 'getSuperMarketsAdmin'">
                    <button type="button" class="btn btn-primary btn-lg btn-block adminButtons">
                        Add SuperMarket
                    </button>
                </div>
                
                <div class="col-sm-4" style="margin-bottom: 10px" onclick="window.location = 'getCountries'">
                    <button type="button" class="btn btn-primary btn-lg btn-block adminButtons">
                        View Countries
                    </button>
                </div>
                <div class="col-sm-4" style="margin-bottom: 10px" onclick="window.location = 'getTravelLegDetails'">
                    <button type="button" class="btn btn-primary btn-lg btn-block adminButtons">
                        Add Travel Leg
                    </button>
                </div>
                <div class="col-sm-4" style="margin-bottom: 10px" onclick="window.location = 'getJourneyLegs'">
                    <button type="button" class="btn btn-primary btn-lg btn-block adminButtons">
                        Add Journey
                    </button>
                </div>
                
                <div class="col-sm-4" style="margin-bottom: 10px" onclick="window.location = 'RetrieveFoodAndSuperMarket'">
                    <button type="button" class="btn btn-primary btn-lg btn-block adminButtons" onclick="window.location = 'getUsers'">
                        Add Item To Supermarket
                    </button>
                </div>
                
                      
               
                 <div class="col-sm-4" style="margin-bottom: 10px" onclick="window.location = 'AddNewStoreLocationAdmin'">
                    <button type="button" class="btn btn-primary btn-lg btn-block adminButtons">
                        Add Store Location
                    </button>
                </div>
                
            </div>
        </div>

    </div>


</body>
</html>
