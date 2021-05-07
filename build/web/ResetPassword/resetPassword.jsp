<%-- 
    Document   : resetPassword
    Created on : 07-May-2021, 22:09:03
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
        <link rel="stylesheet" href="forgotPassword.css">
        <link rel="stylesheet" href="../ForgotPassword/forgotPassword.css">
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
                </div>
                <div class="col-11">
                    Reset Password
                </div>
            </div>
        </div>
    </header>
</head>
<body class="reg-body">
    <div>

    </div>

    <div class="margin-top box-reg">
        <form  id="formpassreset" name="form" action="../ResetPassword" method="post">



            <div class="container">
                

                
                <div class="row pd-10">

                    <div class="col-5">
                        <label style="color:#2d6d2d">New Password</label>
                    </div>
                    <div class="col-6">
                        <input type="text"
                               style="border: 1px solid grey;padding-left: 10px;max-width: 100%;" 
                               name="newPasswordReset" 
                               id="newPasswordReset" 
                               value="dog"/>
                    </div>
                </div>

            </div>
            <div class="div-align">
                 <input type="submit" class="btn reset-submit"></input> 
            </div>
           

        </form>
    </div>
    <div id="snackbar">Email doesnt exist</div>
    <c:if test="${param.message == 'hello'}">

        <script>
            myFunction();
        </script>

    </c:if>    

</body>





</html>