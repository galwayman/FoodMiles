<%-- 
    Document   : viewShoppingCart
    Created on : 23-Feb-2021, 22:21:09
    Author     : coola
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
        <link rel="stylesheet" href="viewShoppingCart.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        
    <header class="shopping-cart-header">

        <div class="container">
            <div class="row">

                
                    <div class="col-1" >
                    <i class="icon-arrow-left" onclick="window.location = '../index.jsp'"> </i>
                </div>
               

                
                <div class="col-11">
                    Shopping Cart
                </div>
            </div>
        </div>
    </header>


</head>
<body style="text-align: center;font-size: 20px">

    <c:if test="${empty scItems}">
        <div class="empty-cart-text">
            Sorry you need to add items to the cart first
        </div>
    </c:if>
    <c:if test="${fn:length(scItems) > 0}">
        <c:forEach var="s" items="${scItems}">
            
            

            <div class="row" style="height: 70px;
                 padding-top: 10px;">
                <div class="col-2" 
                     style="padding-top: 10px;">
                    <form method="post" action="../ModifyCart">
                        <input type="hidden" name="foodItemID" id="foodItemID" value="${s.foodItemID}">
                        <button type="submit" style=" background: #2d6d2d; color: white;
                                font-size: 20px;" class="btn modify-button">
                            <i class="icon-edit"></i>
                        </button>
                    </form>

                </div> 
                <div class="col-5" 
                     style="padding-top: 10px;">
                    ${s.getFoodName()} 
                </div> 
                <div class="col-2" 
                     style="padding-top: 10px;">
                    ${s.getFoodQTY()}
                </div> 
                <div class="col-2" 
                     style="padding-top: 10px;">
                    ${s.getFoodCarbon()}
                </div> 
            </div>

        </c:forEach>
        <form id="form" name="form" action="../CalculateFoodMiles" method="get">
            <div class="row">
                <div class="col-2" 
                     style="padding-top: 10px;">
                </div> 
                <div class="col-5 cart-text" 
                     style="padding-top: 10px;">
                    Total Carbon: 
                </div> 
                <div class="col-2 cart-text" 
                     style="padding-top: 10px;">
                    ${totalScore}
                </div> 
                <div class="col-2" 
                     style="padding-top: 10px;">
                    <input type="hidden" name="cScore" id="cScore" value="${totalScore}"/>

                    <button class="btn cart-button" type="submit">
                        Add
                    </button>


                </div> 
            </div>
        </form>
    </c:if>




</body>
</html>
