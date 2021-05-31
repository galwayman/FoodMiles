<%-- 
    Document   : addNewStartCountry
    Created on : 22-Feb-2021, 21:29:00
    Author     : coola
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="addNewStartCountry.css">
    <header class="add-country-header">
        <div class="container">
        <div class="row">
          
            <div class="col-1" onclick="window.location = '../getCountries'">
                <i class="icon-arrow-left"></i>
            </div>
            <div class="col-11">
                Add New Country
            </div>
          

        </div>

        
    </header>
</head>
<body>
    <form class="margin-top div-float" method="post"  enctype="multipart/form-data"  action="../AddNewStartCountry">
        <div id="mystyle" class="myform">
            <label class="add-country-text">
                <span class="small">Name</span>
            </label>
            <input type="text" style="width: 50%;" name="startCountryName" id="startCountryName" /> 
            <div class="food-item-add"> 
                    <label class="add-country-text" for="startCountryImageAdmin">
                        <span>Image</span>
                    </label>
                    <input type="file" style="width: 50%;"  id="startCountryImageAdmin" name="startCountryImageAdmin">
                </div>
            
            <button type="submit" class="btn add-country-btn">Add New Country</button>
            <div class="spacer"></div>
        </div>
    </form>  
</body>
</html>
