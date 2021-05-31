<%-- 
    Document   : viewCountries
    Created on : 21-Feb-2021, 23:24:35
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
        <link rel="stylesheet" href="./DisplayUsers/displayUsers.css">
        <link rel="stylesheet" href="viewCountries.css">
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    <header class="edit-country-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    View Countries
                </div>


            </div>
    </header>
</head>
<body>
    <div style="text-align: right;
         padding-right: 2%;
         margin-top: 10%;
         position: fixed;
         z-index: 100;
         width: 100%;">
        <button type="button" 
                class="btn add-country" 
                onclick="window.location = '../AddNewStartCountry/addNewStartCountry.jsp'">
            Add New
        </button>  
    </div>

    <h1 class="countries-title" style="margin-top: 60px">Start Countries</h1>

    <div class="container display-country-title">
        <div class="row">

            <div class="col-4">
                Country ID
            </div>
            <div class="col-6">
                Country Name
            </div>




        </div>

    </div>

    <c:forEach var="c" items="${startCountries}">
        <div class="container">
            <div class="row" style="border-top: 1px solid #2d6d2d; padding-bottom: 10px; padding-top: 11px;">
                <div class="col-4">
                    ${c.startCountryID}
                </div>
                <div class="col-4">
                    ${c.startCountryName}
                </div>
                <div class="col-4" style="max-height: 8rem">
                    <img src="data:image/jpg;base64,${c.startCountryFlag}" style="max-width: 100px;
                         height: 50px;
                         width: 74px;
                         padding-top: 3px;    max-height: 15rem;"/>
                </div>
            </div>
        </div>
    </c:forEach> 



    <h1 class="countries-title">End Countries</h1>
    <div class="container display-country-title">
        <div class="row">

            <div class="col-4">
                Country ID
            </div>
            <div class="col-6">
                Country Name
            </div>



        </div>

    </div>

    <c:forEach var="c" items="${endCountries}">
        <div class="container">
            <div class="row" style="border-top: 1px solid #2d6d2d; padding-bottom: 10px; padding-top: 11px;">
                <div class="col-4">
                    ${c.endCountryID}
                </div>
                <div class="col-4">
                    ${c.endCountryName}
                </div>

                <div class="col-4" style="max-height: 8rem">
                    <img src="data:image/jpg;base64,${c.endCountryFlag}" style="max-width: 100px;
                         height: 50px; padding-top: 3px;  
                         width: 74px;
                         max-height: 15rem;"/>
                </div>

            </div>

        </div>
    </c:forEach> 




</body>
</html>