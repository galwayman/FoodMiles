<%-- 
    Document   : index
    Created on : 04-Feb-2021, 11:52:37
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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" 
              href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="homeStyles.css">
        <header class="food-miles-header">
            FoodMiles
        </header>
    </head>


    <body scroll="no" 
          class="default-background 
                 homescreen-body">

                    <div id="div1">
                            <div class="button-border" 
                                 href="getSuperMarkets" 
                                 style="cursor: pointer;"
                                 onclick="window.location = 'getSuperMarkets'">
                                    <div class="icon-styles">
                                       <i class="fas fa-store-alt"></i>
                                    </div>
                                    <div class="button-title divHover">
                                        Search Store
                                    </div>
                            </div>
                    </div> 

                    <div id="div2">
                            <div class="button-border" 
                                 style="cursor: pointer;" 
                                 onclick="window.location = 'StoreLocations/storeLocations.jsp'">
                                    <div class="icon-styles">
                                        <i class="icon-map-marker"></i> 
                                    </div>
                                    <div class="button-title divHover">
                                        Store Locations
                                    </div>
                            </div>
                    </div>
        
                    <div id="div3">
                            <div class="button-border" 
                                 style="cursor: pointer;"
                                 onclick="window.location = 'Info/info.jsp'">
                                    <div class="icon-styles">
                                        <i class="icon-info"></i>
                                    </div>
                                    <div class="button-title divHover">
                                        Info
                                    </div>
                            </div>
                    </div>

                    <div id="div4">
                            <div class="button-border" 
                                 style="cursor: pointer;" 
                                 onclick="window.location = 'getShoppingCart'">
                                    <div class="icon-styles divHover">
                                        <i class="icon-shopping-cart"></i> 
                                    </div>
                                    <div class="button-title divHover">
                                        Shopping Cart
                                    </div>
                            </div>
                    </div>


                    <div class="row custom-footer">
                        
                        <div class="col icon-button" 
                             style="cursor: pointer;" 
                             onclick="window.location = 'Profile Page/profilePage.jsp'">
                               <i class="fas fa-user"></i>
                        </div>
                        
                        <div class="col icon-button" 
                             style="cursor: pointer;" 
                             onclick="location.href='https://www.instagram.com/foodmilesapp/'" 
                                href="https://www.instagram.com/foodmilesapp/">
                                <i class="icon-instagram" 
                                    href="https://www.instagram.com/foodmilesapp/"> 
                                </i>
                        </div>
                        <div class="col icon-button" 
                             style="cursor: pointer;" 
                             onclick="window.location = 'getFaveItems'">
                            <i class="fas fa-heart"></i>


                        </div>
                        <div class="col icon-button" 
                             style="cursor: pointer;" 
                             onclick="window.location = 'getUserScores'">
                                <i class="icon-cloud"></i>
                        </div>
                    </div>

    </body>
</html>
