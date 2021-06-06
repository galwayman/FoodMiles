<%--
    Document   : selectFoodType
    Created on : 05-Feb-2021, 22:52:32
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<!DOCTYPE html>
<html>
    <head>
        <title>Select Food Item</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./SelectSuperMarket/selectsuperMarket.css">
        <link rel="stylesheet" href="./SelectFoodType/selectFoodType.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script>
            function goBack() {
                window.history.back();
            }
  
    function toggleIrish() {
            if (document.getElementById('allFood')) {

                if (document.getElementById('allFood').style.display === 'none') {
                    document.getElementById('allFood').style.display = 'block';
                    document.getElementById('irishFood').style.display = 'none';
                }
                else {
                    document.getElementById('allFood').style.display = 'none';
                    document.getElementById('irishFood').style.display = 'block';
                }
            }
    }
            
            

      </script>

    <header class="select-food-item-header">
        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Select Food Item
                </div>
            </div>
        </div>
    </header>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body  class="default-background">
    <div style="padding-bottom: 80px;margin-top: 5%">
        <button onclick="toggleIrish()" style="    margin-left: 10%;
                margin-bottom: 5%;
                margin-top: 5%;
                background: white;
                height: 100px;
                width: 134px;
                text-align: center;">
            <img src="./images/shamrock.png" style="height: 77px !important;">
        </button>




<div id="allFood"> 
    
        <c:if test="${fn:length(foodItemsFruit) > 0}">
                <div class="type-text">
                    Fruit
                </div>
                <c:forEach var="f" items="${foodItemsFruit}">

                    <form class="basic_form" action="getFoodItems" method="post">

                        <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                            <div class="row" style="max-height: 8rem">
                                <div class="col-8" style="padding-top: 10px;
                                     padding-left: 60px;
                                     width: 100px;
                                     white-space: nowrap;
                                     overflow: hidden;
                                     text-overflow: ellipsis;">
                                    ${f.foodName}
                                </div>
                                <div class="col-2" style="max-height: 8rem">
                                    <c:if test="${f.organic == '1'}">
                                        <img src="./images/Organic.png" style="height: 40% !important;">

                                    </c:if>
                                    <c:if test="${f.organic == '0'}">

                                    </c:if>
                                </div>
                                <div class="col-2" style="max-height: 8rem">
                                    <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                         height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                                </div>

                            </div>
                            <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                        </button>
                    </form>

                </c:forEach>
            </c:if>



        <c:if test="${fn:length(foodItemsVegetables) > 0}">
            <div class="type-text">
                Vegetables
            </div>
            <c:forEach var="f" items="${foodItemsVegetables}">

                <form class="basic_form" action="getFoodItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                        <div class="row" style="max-height: 8rem">
                            <div class="col-8" style="padding-top: 10px;
                                 padding-left: 60px;
                                 width: 100px;
                                 white-space: nowrap;
                                 overflow: hidden;
                                 text-overflow: ellipsis;">
                                ${f.foodName}
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <c:if test="${f.organic == '1'}">
                                    <img src="./images/Organic.png" style="height: 40% !important;">

                                </c:if>
                                <c:if test="${f.organic == '0'}">

                                </c:if>
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                     height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                            </div>

                        </div>
                        <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                    </button>
                </form>

            </c:forEach>
        </c:if>

        <c:if test="${fn:length(foodItemsMeat) > 0}">
            <div class="type-text">
                Meat
            </div>
            <c:forEach var="f" items="${foodItemsMeat}">

                <form class="basic_form" action="getFoodItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                        <div class="row" style="max-height: 8rem">
                            <div class="col-8" style="padding-top: 10px;
                                 padding-left: 60px;
                                 width: 100px;
                                 white-space: nowrap;
                                 overflow: hidden;
                                 text-overflow: ellipsis;">
                                ${f.foodName}
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <c:if test="${f.organic == '1'}">
                                    <img src="./images/Organic.png" style="height: 40% !important;">

                                </c:if>
                                <c:if test="${f.organic == '0'}">

                                </c:if>
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                     height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                            </div>

                        </div>
                        <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                    </button>
                </form>

            </c:forEach>
        </c:if>

        <c:if test="${fn:length(foodItemsFish) > 0}">
            <div class="type-text">
                Fish
            </div>
            <c:forEach var="f" items="${foodItemsFish}">

                <form class="basic_form" action="getFoodItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                        <div class="row" style="max-height: 8rem">
                            <div class="col-8" style="padding-top: 10px;
                                 padding-left: 60px;
                                 width: 100px;
                                 white-space: nowrap;
                                 overflow: hidden;
                                 text-overflow: ellipsis;">
                                ${f.foodName}
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <c:if test="${f.organic == '1'}">
                                    <img src="./images/Organic.png" style="height: 40% !important;">

                                </c:if>
                                <c:if test="${f.organic == '0'}">

                                </c:if>
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                     height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                            </div>

                        </div>
                        <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                    </button>
                </form>

            </c:forEach>
        </c:if>

        <c:if test="${fn:length(foodItemsDairy) > 0}">
            <div class="type-text">
                Dairy
            </div>
            <c:forEach var="f" items="${foodItemsDairy}">

                <form class="basic_form" action="getFoodItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                        <div class="row" style="max-height: 8rem">
                            <div class="col-8" style="padding-top: 10px;
                                 padding-left: 60px;
                                 width: 100px;
                                 white-space: nowrap;
                                 overflow: hidden;
                                 text-overflow: ellipsis;">
                                ${f.foodName}
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <c:if test="${f.organic == '1'}">
                                    <img src="./images/Organic.png" style="height: 40% !important;">

                                </c:if>
                                <c:if test="${f.organic == '0'}">

                                </c:if>
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                     height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                            </div>

                        </div>
                        <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                    </button>
                </form>

            </c:forEach>
        </c:if>

    </div>
 </div>   

 
 
 <div id="irishFood"  style="display:none"> 
        <c:if test="${fn:length(irishItemsFruit) > 0}">
                <div class="type-text">
                    Fruit
                </div>
                <c:forEach var="f" items="${irishItemsFruit}">

                    <form class="basic_form" action="getFoodItems" method="post">

                        <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                            <div class="row" style="max-height: 8rem">
                                <div class="col-8" style="padding-top: 10px;
                                     padding-left: 60px;
                                     width: 100px;
                                     white-space: nowrap;
                                     overflow: hidden;
                                     text-overflow: ellipsis;">
                                    ${f.foodName}
                                </div>
                                <div class="col-2" style="max-height: 8rem">
                                    <c:if test="${f.organic == '1'}">
                                        <img src="./images/Organic.png" style="height: 40% !important;">

                                    </c:if>
                                    <c:if test="${f.organic == '0'}">

                                    </c:if>
                                </div>
                                <div class="col-2" style="max-height: 8rem">
                                    <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                         height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                                </div>

                            </div>
                            <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                        </button>
                    </form>

                </c:forEach>
            </c:if>



        <c:if test="${fn:length(irishItemsVegetables) > 0}">
            <div class="type-text">
                Vegetables
            </div>
            <c:forEach var="f" items="${irishItemsVegetables}">

                <form class="basic_form" action="getFoodItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                        <div class="row" style="max-height: 8rem">
                            <div class="col-8" style="padding-top: 10px;
                                 padding-left: 60px;
                                 width: 100px;
                                 white-space: nowrap;
                                 overflow: hidden;
                                 text-overflow: ellipsis;">
                                ${f.foodName}
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <c:if test="${f.organic == '1'}">
                                    <img src="./images/Organic.png" style="height: 40% !important;">

                                </c:if>
                                <c:if test="${f.organic == '0'}">

                                </c:if>
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                     height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                            </div>

                        </div>
                        <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                    </button>
                </form>

            </c:forEach>
        </c:if>

        <c:if test="${fn:length(irishItemsMeat) > 0}">
            <div class="type-text">
                Meat
            </div>
            <c:forEach var="f" items="${irishItemsMeat}">

                <form class="basic_form" action="getFoodItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                        <div class="row" style="max-height: 8rem">
                            <div class="col-8" style="padding-top: 10px;
                                 padding-left: 60px;
                                 width: 100px;
                                 white-space: nowrap;
                                 overflow: hidden;
                                 text-overflow: ellipsis;">
                                ${f.foodName}
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <c:if test="${f.organic == '1'}">
                                    <img src="./images/Organic.png" style="height: 40% !important;">

                                </c:if>
                                <c:if test="${f.organic == '0'}">

                                </c:if>
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                     height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                            </div>

                        </div>
                        <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                    </button>
                </form>

            </c:forEach>
        </c:if>

        <c:if test="${fn:length(irishItemsFish) > 0}">
            <div class="type-text">
                Fish
            </div>
            <c:forEach var="f" items="${irishItemsFish}">

                <form class="basic_form" action="getFoodItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                        <div class="row" style="max-height: 8rem">
                            <div class="col-8" style="padding-top: 10px;
                                 padding-left: 60px;
                                 width: 100px;
                                 white-space: nowrap;
                                 overflow: hidden;
                                 text-overflow: ellipsis;">
                                ${f.foodName}
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <c:if test="${f.organic == '1'}">
                                    <img src="./images/Organic.png" style="height: 40% !important;">

                                </c:if>
                                <c:if test="${f.organic == '0'}">

                                </c:if>
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                     height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                            </div>

                        </div>
                        <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                    </button>
                </form>

            </c:forEach>
        </c:if>

        <c:if test="${fn:length(irishItemsDairy) > 0}">
            <div class="type-text">
                Dairy
            </div>
            <c:forEach var="f" items="${irishItemsDairy}">

                <form class="basic_form" action="getFoodItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button"onclick="window.location = 'getFoodItems'">
                        <div class="row" style="max-height: 8rem">
                            <div class="col-8" style="padding-top: 10px;
                                 padding-left: 60px;
                                 width: 100px;
                                 white-space: nowrap;
                                 overflow: hidden;
                                 text-overflow: ellipsis;">
                                ${f.foodName}
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <c:if test="${f.organic == '1'}">
                                    <img src="./images/Organic.png" style="height: 40% !important;">

                                </c:if>
                                <c:if test="${f.organic == '0'}">

                                </c:if>
                            </div>
                            <div class="col-2" style="max-height: 8rem">
                                <img src="data:image/jpg;base64,${f.foodItemPic}" style="max-width: 100%;
                                     height: 90% !important; padding-top: 3px;    max-height: 15rem;"/>
                            </div>

                        </div>
                        <INPUT TYPE="HIDDEN" NAME="foodID" VALUE="${f.foodItemID}">
                    </button>
                </form>

            </c:forEach>
        </c:if>

    </div>
 
  

</body>
</html>
