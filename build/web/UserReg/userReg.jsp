<%-- 
    Document   : userReg
    Created on : 26-Feb-2021, 21:14:33
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            #snackbar {
                visibility: hidden;
                min-width: 250px;
                margin-left: -125px;
                background-color: #ca1e1e;
                color: white;
                text-align: center;
                border-radius: 2px;
                padding: 16px;
                position: fixed;
                z-index: 1;
                left: 50%;
                bottom: 30px;
                font-size: 17px;
            }

            #snackbar.show {
                visibility: visible;
                -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
                animation: fadein 0.5s, fadeout 0.5s 2.5s;
            }

            @-webkit-keyframes fadein {
                from {bottom: 0; opacity: 0;} 
                to {bottom: 30px; opacity: 1;}
            }

            @keyframes fadein {
                from {bottom: 0; opacity: 0;}
                to {bottom: 30px; opacity: 1;}
            }

            @-webkit-keyframes fadeout {
                from {bottom: 30px; opacity: 1;} 
                to {bottom: 0; opacity: 0;}
            }

            @keyframes fadeout {
                from {bottom: 30px; opacity: 1;}
                to {bottom: 0; opacity: 0;}
            }
        </style>
        <script>


            function myFunction() {

                var x = document.getElementById("snackbar");
                x.className = "show";
                setTimeout(function () {
                    x.className = x.className.replace("show", "");
                }, 3000);
            }


        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 
              href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet"> 
        <script src="./libs/jquery/1.10.1/jquery.min.js"></script>


        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="userReg.css">
        <link rel="stylesheet" href="./UserReg/userReg.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>

        <script>
            function goBack() {
                window.history.back();
            }
        </script>
        <script>
            function resetForm() {
                document.getElementById("form1").reset();
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
        <form  id="form1" name="form" action="../UserRegistration" method="post">



            <div class="container">
                <div class="row">

                    <div class="col-5">
                        <label style="color:#2d6d2d">Name</label>
                    </div>
                    <div class="col-6">
                        <input type="text" style="border: 1px solid grey;padding-left: 10px;max-width: 100%;" name="userNameReg" id="userName" value="ori"/>
                    </div>
                </div>

                <div class="row pd-10">

                    <div class="col-5">
                        <label style="color:#2d6d2d">Email</label>
                    </div>
                    <div class="col-6">
                        <input type="text"style="border: 1px solid grey;padding-left: 10px;max-width: 100%;" name="userEmailReg" id="userEmailReg" value="ori@ori.com"/>
                    </div>
                </div>

                <div class="row pd-10">

                    <div class="col-5">
                        <label style="color:#2d6d2d">Password</label>                </div>
                    <div class="col-6">
                        <input type="text"style="border: 1px solid grey;padding-left: 10px;max-width: 100%;" name="userPasswordReg" id="userPasswordReg" value="password" />
                    </div>
                </div>
                <div class="row pd-10">

                    <div class="col-5">
                        <label style="color:#2d6d2d">First Pets Name</label>                </div>
                    <div class="col-6">
                        <input type="text" style="border: 1px solid grey;padding-left: 10px;max-width: 100%;"name="passwordQuestion" id="passwordQuestion" value="Fred" />
                    </div>
                </div>

                <div class="row pd-10">

                    <div class="col-5">
                        <button class="btn reg-button" type="submit" >Register</button>          
                    </div>
                    <div class="col-3">
                    </div>
                    <div class="col-4">
                    </div>
                </div>
            </div>


        </form>
    </div>
    <div id="snackbar">User Email or Username already exists</div>
    <c:if test="${param.message == 'hello'}">

        <script>
            myFunction();
        </script>

    </c:if>    

</body>





</html>
