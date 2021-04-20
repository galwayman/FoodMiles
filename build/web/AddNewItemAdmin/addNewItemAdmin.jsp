<%--
Document   : addNewItemAdmin
Created on : 12-Mar-2021, 22:39:32
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
        <link rel="stylesheet" href="./AddNewItemAdmin/addNewItemAdmin.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
        <header class="default-header-foodmiles" >

            <div class="container">
                <div class="row">

                    <div class="col-1" onclick="goBack()">
                        <i class="icon-arrow-left"></i>
                    </div>
                    <div class="col-11">
                        View Food Items
                    </div>
                </div>
        </header>


    </head>


    <body>

        <form class="margin-top" method="post"  enctype="multipart/form-data" action="../AddNewFoodItemAdmin">
            <div id="mystyle" class="myform">



                <div class="food-item-add">
                    <label class="add-country-text" for="foodNameAdmin">
                        <span>Item Name</span>
                    </label>
                    <input type="text" class="food-item-add-input" name="foodNameAdmin" id="foodNameAdmin" value="Orange"/>
                </div>

                <div class="food-item-add">
                    <label class="add-country-text" for="organicAdmin">
                        <span>Organic</span>
                    </label>
                    <input type="text" class="food-item-add-input"  name="organicAdmin" id="organicAdmin" value="1"/>
                </div>

                <div class="food-item-add">
                    <label class="add-country-text" for="irishSourcedAdmin">
                        <span>Irish Sourced</span>
                    </label>
                    <input type="text"  class="food-item-add-input"  name="irishSourcedAdmin" value="1" id="irishSourcedAdmin" />
                </div>

                <div class="food-item-add">
                    <label class="add-country-text" for="foodClassAdmin">
                        <span>Item Class</span>
                    </label>
                    <input type="text" class="food-item-add-input"  name="foodClassAdmin" value="Fruit" id="foodClassAdmin" />
                </div>

                <div class="food-item-add">
                    <label class="add-country-text" for="foodTypeAdmin">
                        <span>Item Type</span>
                    </label>
                    <input type="text" class="food-item-add-input"  name="foodTypeAdmin" value="Orange"id="foodTypeAdmin" />
                </div>
                <div class="food-item-add">
                    <label class="add-country-text" for="foodWeightAdmin">
                        <span>Item Weight</span>
                    </label>
                    <input type="text" class="food-item-add-input"  name="foodWeightAdmin" value="0.235"id="foodWeightAdmin" />
                </div>

                <div class="food-item-add"> 
                    <label class="add-country-text" for="foodImageAdmin">
                        <span>Image</span>
                    </label>
                    <input type="file" style="width: 68%;" id="foodImageAdmin" name="foodImageAdmin">
                </div>

                <button type="submit" class="btn add-button">Add New Food Item</button>
                <div class="spacer"></div>
            </div>
        </form>

    </body>
</html>
