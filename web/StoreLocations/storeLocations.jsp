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
                ['Aldi', 53.27362531593625, -9.098767674017587, 1],
                ['Dunnes', 53.28089778880087, -9.077852813186555, 2],
                ['Lidl', 53.27890545710671, -9.050211672409809, 3],
                ['Tescos', 53.28019671782931, -9.047964365064605, 4]
            ];
            let map;

            function initMap() {
                const myLatLng = {lat: 53.27890545710671, lng: -9.050211672409809};
                var v_icon=''
                map = new google.maps.Map(document.getElementById("map"), {
                    center: myLatLng,
                    zoom: 13
                });
//                new google.maps.Marker({
//                    position: myLatLng,
//                    map,
//                    title: "Galway"
//                });
                for (i = 0; i < markers.length; i++) {
                    var position = new google.maps.LatLng(markers[i][1], markers[i][2]);
                    
                    if(markers[i][0] === ('Lidl')){
                        var  v_icon = 'https://maps.google.com/mapfiles/ms/icons/yellow-dot.png';
                    }
                    else if(markers[i][0] === ('Tescos')){
                     var  v_icon =    'https://maps.google.com/mapfiles/ms/icons/red-dot.png';
                    }
                    else if(markers[i][0] === ('Aldi')){
                     var  v_icon =    'https://maps.google.com/mapfiles/ms/icons/orange-dot.png';
                    }
                    else if(markers[i][0] === ('Dunnes')){
                     var  v_icon =    'https://maps.google.com/mapfiles/ms/icons/blue-dot.png';
                    }
                    

                    marker = new google.maps.Marker({
                        position: position,
                        map: map,
                        title: markers[i][0],
                        
                        
                        icon: v_icon
                        

                    });
                    google.maps.event.addListener(marker, 'click', (function (marker, i) {

                        return function () {
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
    </header>
</head>

<body>
    <div id="map"></div>

    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
    <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTHc1KF0qO20Rs88b5iYfUBe8nlN5t2n0&callback=initMap&libraries=&v=weekly"
        async
    ></script>
</body>
</html>