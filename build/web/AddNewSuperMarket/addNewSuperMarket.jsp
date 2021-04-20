<%-- 
    Document   : addNewSuperMarket
    Created on : 11-Mar-2021, 22:24:50
    Author     : coola
--%>

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
        <link rel="stylesheet" href="./addNewSuperMarket.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    <header class="edit-country-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Add New Supermarket
                </div>
            </div>
    </header>
</head>
<body>
    <form class="margin-top" method="post"  enctype="multipart/form-data" action="../AddNewSuperMarket">
            <div id="mystyle" class="myform">



                <div class="food-item-add">
                    <label class="add-country-text" for="smNameAdmin">
                        <span>SuperMarket Name</span>
                    </label>
                    <input type="text" class="food-item-add-input" name="smNameAdmin" id="smNameAdmin" value="Centra"/>
                </div>

                <div class="food-item-add"> 
                    <label class="add-country-text" for="smImageAdmin">
                        <span>Image</span>
                    </label>
                    <input type="file" style="width: 68%;" id="smImageAdmin" name="smImageAdmin">
                </div>

                <button type="submit" class="btn add-button">Add</button>
                <div class="spacer"></div>
            </div>
        </form>
</body>
</html>
