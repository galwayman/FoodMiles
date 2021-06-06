<%-- 
    Document   : storeLocations
    Created on : 19-Feb-2021, 19:29:12
    Author     : coola
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Simple Map</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script src="./libs/jquery/1.10.1/jquery.min.js"></script>
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <style type="text/css">
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 100%;
            }

            /* Optional: Makes the sample page fill the window. */
            html,
            body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
        </style>
        <link rel="stylesheet" href="storeLocations.css">
        <script>

            var markers = [
                       <c:forEach var="s" items="${locations}">
                [
                '<c:out value="${s.getSuperMarketName()}"/>',
                        <c:out value="${s.getLatitude()}"/>,
                <c:out value="${s.getLongitude()}"/>,
                
                <c:out value="${s.getSuperMarketLocationID()}"/>
                ],
            </c:forEach>

            ];

            let map;

            function initMap() {
                const myLatLng = {lat: 53.27890545710671, lng: -9.050211672409809};
                var v_icon = '',
                      map = new google.maps.Map(document.getElementById("map"), {
                            center: myLatLng,
                            zoom: 13
                        });
                        

                for (i = 0; i < markers.length; i++) {
                    var position = new google.maps.LatLng(markers[i][1], markers[i][2]);

                    if (markers[i][0] === ('Lidl')) {
                        var v_icon = 'https://maps.google.com/mapfiles/ms/icons/yellow-dot.png';
                        
                    } else if (markers[i][0] === ('Tescos')) {
                        var v_icon = 'https://maps.google.com/mapfiles/ms/icons/red-dot.png';
                        
                    } else if (markers[i][0] === ('Aldi')) {
                        var v_icon = 'https://maps.google.com/mapfiles/ms/icons/purple-dot.png';
                        
                    } else if (markers[i][0] === ('Dunnes')) {
                        var v_icon = 'https://maps.google.com/mapfiles/ms/icons/blue-dot.png';
                        
                    } else if (markers[i][0] === ('SuperValue')) {
                        var v_icon = 'https://maps.google.com/mapfiles/ms/icons/green-dot.png';
                        
                    } else {
                        var v_icon = 'https://maps.google.com/mapfiles/ms/icons/pink-dot.png';
                    }


                    marker = new google.maps.Marker({
                        position: position,
                        map: map,
                        title: markers[i][0],
                        icon: v_icon

                    });
                    google.maps.event.addListener(marker, 'click', (function (marker, i) {

                        return function () {
                            window.location.href = "http://localhost:8080/FoodMiles_Version_2/getSuperMarkets";
                            //if clicked
                        };
                    })(marker, i));
                }
            }
        </script>
        <link rel="stylesheet" href="./homeStyles.css">

    <header class="default-header-foodmiles">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Store Locations
                </div>
            </div>

            </div>
    </header>
</head>

<body>
  <div id="map"></div>

    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
    <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAZGOy0TFp4KYDUgOLcsG2UxlR-bToROE4&callback=initMap&libraries=&v=weekly"
        async>
    </script>  
</body>
</html>