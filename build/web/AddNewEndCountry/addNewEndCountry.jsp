<%-- 
    Document   : addNewEndCountry
    Created on : 22-Feb-2021, 21:28:35
    Author     : coola
--%>

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
        <link rel="stylesheet" href="addNewEndCountry.css">
    <header class="add-country-header">Add New End Country</header>
</head>
    <body>
        <form class="margin-top" method="post"  enctype="multipart/form-data"   action="../AddNewEndCountry">
            <div id="mystyle" class="myform">
                    
                    <label class="add-country-text">
                        <span class="small">Country Name</span>
                    </label>
                    <input type="text" name="endCountryName" id="endCountryName" />   
                    
                    <div class="food-item-add"> 
                    <label class="add-country-text" for="endCountryImageAdmin">
                        <span>Image</span>
                    </label>
                    <input type="file"   id="endCountryImageAdmin" name="endCountryImageAdmin">
                </div>
                    <button type="submit" class="btn add-country-btn">Add New End Country</button>
                    <div class="spacer"></div>
            </div>
        </form>  
    </body>
</html>
