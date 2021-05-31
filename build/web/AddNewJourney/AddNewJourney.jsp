<%-- 
    Document   : AddNewJourney
    Created on : 09-Mar-2021, 13:26:13
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
        <link rel="stylesheet" href="../AddNewJourney/AddNewJourney.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#chk").click(function () {
                    $(".info").toggle(700);
                });

                var checkbox = $('input[type="checkbox"]');
                var button = $('#check');

                if (checkbox.is(':checked')) {
                    button.removeProp('disabled');
                } else {
                    button.prop('disabled', 'disabled');
                }

                checkbox.on('change', function () {
                    if (checkbox.is(':checked')) {
                        button.removeProp('disabled');
                    } else {
                        button.prop('disabled', 'disabled');
                    }
                });
            });
        </script>
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
                    Create New Journey
                </div>
            </div>
    </header>
</head>
<body>

    <div class="info-box">

        <div class="container display-country-title">
            <div class="row">


                <div class="col-9">

                    <button class="btn info-btn" id="chk"><i class="fas fa-info"></i>

                    </button>
                    <div class="info" style="display:none">
                        <div>Select legs of trip. Eg Argentina > Brazil by truck</div>
                        <div>Take account of ID as this is needed when adding the Journey to the food item on next page</div>
                    </div>  
                </div>

                <div class="col-2">
                </div>

            </div>
        </div>

    </div>

    <div class="container display-country-title">
        <div class="row">

            <div class="col-3">
                Start Country
            </div>
            <div class="col-3">
                End Country
            </div>
            <div class="col-2">
                ID
            </div>
            <div class="col-2">
            </div>
        </div>
    </div>

    <form action="../addCountryToFood" method="get">

        <c:forEach items="${journeyLegsTotalTrip}" var="j">

            <div class="container">
                <div class="row">
                    <div class="col-3">
                        ${j.startCountry} 
                    </div>
                    <div class="col-3">
                        ${j.endCountry}
                    </div>
                    <div class="col-2">
                        ${j.legID}
                    </div>

                    <div class="col-2">
                        <c:if test="${j.transportUsed == '1'}">
                            <i class="fas fa-plane"></i>
                        </c:if>
                        <c:if test="${j.transportUsed == '2'}">
                            <i class="fas fa-anchor"></i>
                        </c:if>
                        <c:if test="${j.transportUsed == '3'}">
                            <i class="fas fa-truck-moving"></i>
                        </c:if>
                        <c:if test="${j.transportUsed == '4'}">
                            <i class="fas fa-subway"></i>
                        </c:if>
                        <input type="checkbox" name="addJourney" class="case" value="${j.legID}"></input>

                    </div>


                </div>
            </div>

        </c:forEach>
        <div style="text-align: center;margin-top: 20px">
            <button type="submit" id="check" class="btn modify-button">
                Create Journey
            </button>
        </div>

    </form>



</body>
</html>
