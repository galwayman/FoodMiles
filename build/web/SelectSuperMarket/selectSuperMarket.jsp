<%-- 
    Document   : selectSuperMarket
    Created on : 04-Feb-2021, 11:39:46
    Author     : coola
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Select Store</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 
              href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./SelectSuperMarket/selectsuperMarket.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
       

    <header class="select-store-header">
        <div class="container">
            <div class="row">

                <div class="col-1" onclick="window.location = './index.jsp'">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Select Store
                </div>
            </div>
        </div>
        
    </header>
</head>
<body  class="default-background">
    <div style="padding-bottom: 80px;margin-top: 5%;">
        <form action="getSuperMarketItems" method="post">
            <c:forEach var="s" items="${supermarkets}">
                <form class="basic_form" action="getSuperMarketItems" method="post">

                    <button type="button submit" class="btn btn-lg btn-block super-market-button" onclick="window.location = 'getSuperMarketItems'">                
                        <div class="row">
                            <div class="col-9" 
                                 style="padding-top: 10px;">
                                ${s.superMarketID} 
                                ${s.superMarketName}
                            </div> 
                            <div class="col-3">
                                <img src="data:image/jpg;base64,${s.superMarketImage}" 
                                     style="max-width: 100%;
                                     height: 6rem !important; 
                                     padding-top: 3px;"/>
                            </div> 
                        </div>
                        <INPUT TYPE="HIDDEN" NAME="superMarket" VALUE="${s.superMarketID}">
                    </button>
                </form>



            </c:forEach>

        </form>

    </div>
</body>
</html>

