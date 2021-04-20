<%-- 
    Document   : displaySuperMarketAdmin
    Created on : 11-Mar-2021, 22:12:10
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
        <link rel="stylesheet" href="./DisplaySuperMarketAdmin/displaySuperMarketAdmin.css">
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
                    Add New Supermarket
                </div>
            </div>
    </header>
</head>
<body>
    <div style="padding-bottom: 80px;margin-top: 5%;">
        <div class="container display-country-title">
            <div class="row">

                <div class="col-4">
                    ID
                </div>
                <div class="col-6">
                    Name
                </div>


            </div>

        </div>


        <c:forEach var="c" items="${supermarketsAdmin}">
            <div class="container">
                <div class="row" style="border-top: 1px solid #2d6d2d; padding-bottom: 10px; padding-top: 11px;">
                    <div class="col-3">
                        ${c.superMarketID}
                    </div>
                    <div class="col-6">
                        ${c.superMarketName}
                    </div>
                    <div class="col-3">
                <img src="data:image/jpg;base64,${c.getSuperMarketImage()}" style="max-width: 5rem;
                    padding-top: 3px;    height: 77px;
    max-width: 90px;"/>
            </div>
                </div>
            </div>
        </c:forEach> 


        <button type="button" 
                class="btn add-country" 
                onclick="window.location = './AddNewSuperMarket/addNewSuperMarket.jsp'">
            Add New SuperMarket
        </button>
    </div>
</body>
</html>
