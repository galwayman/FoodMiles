<%-- 
    Document   : userReg
    Created on : 26-Feb-2021, 21:14:33
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
        <link rel="stylesheet" href="userReg.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>

        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    <header class="default-header-foodmiles">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    User Registration
                </div>
            </div>
        </div>
    </header>
</head>
<body class="reg-body">
    <div>
        
    </div>
    
    <div class="margin-top box-reg">
        <form  id="form" name="form" action="../UserRegistration" method="get">



        <div class="container">
            <div class="row">

                <div class="col-4">
                    <label style="color:#2d6d2d">Name</label>
                </div>
                <div class="col-7">
                    <input type="text" style="border: 1px solid grey;padding-left: 10px" name="userNameReg" id="userName" value="ori"/>
                </div>
            </div>

            <div class="row pd-10">

                <div class="col-4">
                    <label style="color:#2d6d2d">Email</label>
                </div>
                <div class="col-7">
                    <input type="text" style="border: 1px solid grey;padding-left: 10px" name="userEmailReg" id="userEmailReg" value="ori@ori.com"/>
                </div>
            </div>

            <div class="row pd-10">

                <div class="col-4">
                    <label style="color:#2d6d2d">Password</label>                </div>
                <div class="col-7">
                    <input type="text" style="border: 1px solid grey;padding-left: 10px" name="userPasswordReg" id="userPasswordReg" value="password" />
                </div>
            </div>
            
             <div class="row pd-10">

                <div class="col-4">
                    <button class="btn reg-button" type="submit" >Register</button>          
                </div>
                  <div class="col-4">
                </div>
                <div class="col-4">
                   
                </div>
            </div>
        </div>

           
    </form>
    </div>
    
</body>
</html>
