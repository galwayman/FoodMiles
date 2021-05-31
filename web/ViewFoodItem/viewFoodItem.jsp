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
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./ViewFoodItem/viewFoodItem.css">
        <link rel="stylesheet" href="viewFoodItem.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script src="./libs/jquery/1.10.1/jquery.min.js"></script>
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>



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

    <div class="display-div">
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
                            <label for="addFoodQTYCart" class="text-info-view-food" style="width: 80%;
                                   text-align: center;
                                   margin-left: 10%;">
                                Select QTY
                            </label>
                            <select style="width:80%; margin-left: 10%" class="form-control option-view-food" id="addFoodQTYCart" name="addFoodQTYCart">
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
                            <label for="addJourney" class="text-info-view-food"style="width: 80%;
                                   text-align: center;
                                   margin-left: 10%;">
                                Origin</label>
                            <select style="width:80%; margin-left: 10%" class="form-control option-view-food" id="addJourney" name="addJourney">
                                <c:forEach var="fc" items="${foodCountry}">
                                    <option value="${fc.journeyID} ">${fc.foodCountryName} </option>
                                </c:forEach>
                            </select>    
                        </div>



                    </div>



                </div>



            </form>
            <form id="form1" class="fave" name="form" action="./UpdateFave" method="get"> <!--added by aisl-->

                <label>
                    <input type="hidden" name="addFaveUserID" id="addFaveUserID" value="${uLog.getUserID()}"/>
                    <span class="small"></span>
                </label>     
                <label>
                    <input type="hidden" name="addFaveFoodItemID" id="addFaveFoodItemID" value="${f.foodItemID}"/>
                    <span class="small"></span>
                </label> 




            </form>
            <div class="row" style="text-align: center">
                <div class="col-6">
                    <button type="submit" form="form1" class="add-food-item"> <i class="far fa-heart"></i></button>
                </div>

                <div class="col-6">
                    <button type="submit" form="form" class="btn add-food-item"><i class="fas fa-shopping-cart"></i></button>
                </div>

            </div>
        </div>
    </div>





</body>
</html>
