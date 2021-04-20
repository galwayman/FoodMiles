<%-- 
    Document   : viewFaveItems
    Created on : 24-Feb-2021, 21:08:15
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>View Fave Items</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./SelectSuperMarket/selectsuperMarket.css">
        <link rel="stylesheet" href="./SelectFoodType/selectFoodType.css">

    <header class="food-miles-header">
        View Fave Items
    </header>
</head>
<body  class="default-background">
    <div style="padding-bottom: 80px;margin-top: 5%">
        <c:forEach var="f" items="${faveItems}">
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

    </div>

</body>
</html>

