<%--
    Document   : addNewStoreLocation
    Created on : 05-Apr-2021, 15:39:02
    Author     : aisli
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
        <link rel="stylesheet" href="addNewStoreLocation.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>

        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    <header class="default-header-foodmiles" style=" font-size: 25px;
            padding-top: 10px;
            padding-bottom: 10px;">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Add Store Location
                </div>
            </div>
        </div>
    </header>





</head>
<body>
    <form action="../AddStoreLocationInputs" method="post">
        <div class="form-group">
            <label class="food-item-add" for="sel1">Select Supermarket</label>
            <select class="form-control selFI"  name="superMarketLocationInput" id="superMarketLocationInput">
                <c:forEach var="s" items="${superMarketAddLocation}"> 
                    <!--superMarketAddLocation name of array-->
                    <option value="${s.superMarketID}"> <!--removed space-->
                        ${s.superMarketID}
                        ${s.superMarketName}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div>
            <span>Latitude</span>

            <input type="text"  name="latitudeInput" id="latitudeInput" placeholder="53.28409" required/>
        </div>

        <div>
            <span>Longitude</span>
            <input type="text" name="longitudeInput" id="longitudeInput" placeholder="-8.98242" required/>
        </div>

        <button type="submit"> Add Location </button>

    </form>

</body>
</html>
