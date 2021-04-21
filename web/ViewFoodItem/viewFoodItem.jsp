<%--
    Document   : viewFoodItem
    Created on : 07-Feb-2021, 23:49:09
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Select Food Item</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./ViewFoodItem/viewFoodItem.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script src="./libs/jquery/1.10.1/jquery.min.js"></script>
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title> ${f.foodName}</title>
    <header class="view-food-header">
        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    ${f.foodName}
                </div>
            </div>
        </div>

    </header>
</head>
<body class="default-background">

    <div class="viewFoodImage">
        <img src="data:image/jpg;base64,${f.foodItemPic}" class="food-pic"/>
    </div>
    <div>


        <form id="form" name="form" action="./UpdateCart" method="get">



            <label>
                <input type="hidden" name="addUserIDCart" id="addUserIDCart" value="${uLog.getUserID()}"/>
                <input type="hidden" name="selectFIDirection" id="selectFIDirection" value="${selectFIDirection}"/>
            </label>     
            <label>
                <input type="hidden" name="addFoodItemIDCart" id="addFoodItemIDCart" value="${f.foodItemID}"/>
            </label> 

            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-sm-12">
                        <label for="addFoodQTYCart" class="text-info-view-food" style="width: 30rem; text-align: center;">
                            Select QTY
                        </label>
                        <select class="form-control option-view-food" id="addFoodQTYCart" name="addFoodQTYCart">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                            <option>13</option>
                            <option>14</option>
                            <option>15</option>
                        </select> 
                    </div>
                    <div class="col-lg-6 col-sm-12">
                        <label for="addJourney" class="text-info-view-food"style="width: 30rem;text-align: center;">
                            Select Origin Country</label>
                        <select class="form-control option-view-food" id="addJourney" name="addJourney">
                            <c:forEach var="fc" items="${foodCountry}">
                                <option value="${fc.journeyID} ">${fc.foodCountryName} </option>
                            </c:forEach>
                        </select>    
                    </div>



                </div>

                <div class="row">
                    <div class="col-4">

                    </div>
                    <div class="col-4" style="text-align: center">

                        <button type="submit" class="btn add-food-item"><i class="fas fa-shopping-cart"></i></button>

                    </div>
                    <div class="col-4">

                    </div>

                </div>

            </div>



        </form>
            
    </div>

</body>
</html>
