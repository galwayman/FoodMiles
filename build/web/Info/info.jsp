<%-- 
    Document   : info
    Created on : 15-Mar-2021, 23:02:23
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
        <link rel="stylesheet" href="info.css">
        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    <header class="info-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="goBack()">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    Info
                </div>
            </div>
    </header>


</head>
   <body class="default-background">
       <button class="collapsible info-button" style="margin-top: 80px">What are food miles?</button>
        <div class="content">
            <p>
                Food Miles refers to the distance your food has to travel to get
                from where it's grown to your local supermarket shelf. <br>
                Food grown abroad travels by ship or by air transport,often with 
                multiple legs, which generates high 
                carbon emissions.
            </p>
            
            <p>
                <iframe width="560" height="315" src="https://www.youtube.com/embed/k7DQ0EEqxV4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                <br> <br> <br>
                <iframe width="560" height="315" src="https://www.youtube.com/embed/jk_YGNzBwUo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </p>
        </div>
         
         <br>
         
        <button class="collapsible info-button">Choose local and organic foods: </button>
        <div class="content">
            <p>Locally grown food does not have to travel as far to reach the supermarket shelves. 
                Organic food is grown without chemical fertilizers and pesticides that produce 
                greenhouse gases and can leach into the soil and pollute local lakes and rivers.</p>
        </div>
        
        <br>
        
        <button class="collapsible info-button">Choose foods that are in season: </button>
        <div class="content">
            <p>Buying food in season reduces the number of steps between the 
               item being harvested etc. to it ending up on store shelves 
               which reduces the amount of carbon produced. 
               <br>
               For more information click <a href="https://www.bordbia.ie/whats-in-season/best-in-season/list/ ">here.</a>
            </p>
        </div>
        
        <br>
        
        <button class="collapsible info-button">Buy in bulk: </button>
        <div class="content">
            <p>Bulk buying has many benefits; choosing larger sizes of items with a 
               long shelf life can reduce the amount of packaging. It can also save 
               you time by reducing the number of shopping trips you need to take, 
               reducing the overall amount of carbon emissions.</p>
        </div>
        
        <br>
        
        <button class="collapsible info-button">Composting: </button>
        <div class="content">
            <p>Bulk buying has many benefits; choosing larger sizes of items with
               a long shelf life can reduce the amount of packaging. It can also 
               save you time by reducing the number of shopping trips you need to 
               take, reducing the overall amount of carbon emissions.
               <br>
               Learn how to start composting <a href="https://stopfoodwaste.ie/wp-content/uploads/2018/04/2017-Compost-Booklet-Web-Version-1.pdf ">here</a>
            </p>
        </div>
        
        <br>
        
        <button class="collapsible info-button">Avoid items with excess packaging: </button>
        <div class="content">
            <p>While the majority of food in supermarkets comes with a lot of packaging,
                there are several choices we can make to help reduce the amount of waste we have to dispose of. </p>
            <ul>
                <li>Buy loose fruits and vegetables where possible (you can also buy reusable produce bags to 
                    avoid the single-use bags provided by the supermarket)</li>
                <li>Look for items with biodegradable packaging</li>
                <li>Reuse packing at home, e.g. glass jars as storage containers</li>
            </ul>
        </div>
        
        
        <br>
        
        <button class="collapsible info-button">Buy less: </button>
        <div class="content">
            <p>With all the different marketing strategies that supermarkets use,
                it is very easy to buy more than we need or can use. By creating
                a shopping list and sticking to it, you can reduce the amount of 
                food waste produced and save some money along the way.</p>
        </div>
        
        <br>
        
        <button class="collapsible info-button">Dispose of waste properly: </button>
        <div class="content">
            <p>Unfortunately, not every piece of plastic, carbon etc. can be recycled.
                If the wrong items end up in the recycling bin it may contaminate
                the load, diverting it to landfill. 
                <br>
                Click <a href="https://www.mywaste.ie/ ">here</a> to find out how to sort your items.
            </p>
            
        </div>
        
       
      
        <!-- JS-->
        <script>
            var collapse = document.getElementsByClassName("collapsible");
            var i;

            for (i = 0; i < collapse.length; i++) {
              collapse[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var content = this.nextElementSibling;
                if (content.style.maxHeight){
                  content.style.maxHeight = null;
                } else {
                  content.style.maxHeight = content.scrollHeight + "px";
                } 
              });
            }
         </script>
         
         <div class='clear'></div> <!--To allow scrolling to bottom of the page-->
         
         
    </body>
</html>
