<%-- 
    Document   : profilePage
    Created on : 18-Feb-2021, 10:34:01
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
        <link rel="stylesheet" href="../Profile Page/profilePage.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>

       
    <header class="edit-country-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="window.location = '../index.jsp'">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Profile Page
                </div>
            </div>
    </header>
</head>
<body>
    <div class="container profile-box">
        <div class="row">

            <div class="col-3">
            </div>
            <div class="col-6"style="text-align: center;">
                <c:if test="${uLog.getProfilePic() == '0'}">

                    <img class="profile-box-image profile-box-image-strawberry" alt="Strawberry">
                </c:if>
                <c:if test="${uLog.getProfilePic() == '1'}">
                    <img class="profile-box-image profile-box-image-banana"src="../images/Banana.png" alt="Banana">
                </c:if>
                <c:if test="${uLog.getProfilePic() == '2'}">
                    <img class="profile-box-image profile-box-image-pear"src="../images/Pear.png" alt="Pear">
                </c:if>
                     <c:if test="${uLog.getProfilePic() == '3'}">
                    <img class="profile-box-image profile-box-image-apple"src="../images/Apple.jpg" alt="Apple">
                </c:if>
                     <c:if test="${uLog.getProfilePic() == '4'}">
                    <img class="profile-box-image profile-box-image-grape" src="../images/Grape.jpg" alt="Banana">
                </c:if>

            </div>
            <div class="col-3">
            </div>
        </div>

        <div class="row">

            <div class="col-3">
            </div>
            <div class="col-6"style="text-align: center;">
                <h1>${uLog.getUserName()}</h1>
            </div>
            <div class="col-3">
            </div>
        </div>   
        <div class="row">

            <div class="col-3">
            </div>
            <div class="col-6" style="text-align: center;">
                <h1>${uLog.getUserEmail()}</h1>
            </div>
            <div class="col-3">
            </div>
        </div>  
        <div class="row">

            <div class="col-3">
            </div>
            <div class="col-6"style="text-align: center;">
                <form method="post" action="../EditUser/editUser.jsp">
                    <input type="hidden" name="userID" value="${uLog.getUserID()}">
                    <input type="hidden" name="userName" value="${uLog.getUserName()}">
                    <input type="hidden" name="userEmail" value="${uLog.getUserEmail()}">

                    <input style="background: #2d6d2d;
                           border: #2d6d2d;
                           color: white;
                           font-weight: 600;
                           width: 50%;
                           height: 46px;
                           text-align: center;" type="submit" value="Modify">
                </form>
            </div>
            <div class="col-3">
            </div>
        </div>  
    </div>




</body>
</html>
