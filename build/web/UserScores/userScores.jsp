<%-- 
    Document   : userScores
    Created on : 19-Feb-2021, 15:43:45
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
    <head>
        <title>User Scores</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">
        <link rel="stylesheet" href="./UserScores/userScores.css">

        <script src="https://kit.fontawesome.com/59e2d07626.js" crossorigin="anonymous"></script>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['line']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = new google.visualization.DataTable();
                data.addColumn('number', 'Carbon Score');
                data.addColumn('number', 'Carbon Scores');
                data.addColumn('number', 'Average');

                var data = google.visualization.arrayToDataTable([
                    ['', 'Carbon', 'Avg'],
            <c:forEach var="u" items="${uScores}">
                    ['Shop ${u.cartNumber}', ${u.carbonScore}, ${avg}],
            </c:forEach>
                ]);  //--- until here

                var options = {
                    chart: {
//                        title: 'Carbon Scores',
                    },
//                    width: 950,
                    height: 550,
                    colors: ['#2d6d2d', 'Orange'],
                    vAxis: {
                        viewWindow: {
                            min: 0,
                            max: ${highScore} + 100
                        }
                    },
                    legend: {textStyle: {fontName: 'TimesNewRoman', fontSize: 30, bold: false}},
                    hAxis: {
                        textStyle: {
                            fontSize: 10 // or the number you want
                        }

                    },
//                    lineWidth: 20,
                    series: {
                        0: {lineWidth: 12},
                        1: {lineWidth: 22},
                        2: {lineWidth: 24},
                        3: {lineWidth: 28},
                        4: {lineWidth: 16},
                        5: {lineWidth: 24}
                    },
                    axes: {
                        x: {
                            0: {side: 'top'}
                        }
                    }
                };

                var chart = new google.charts.Line(document.getElementById('line_top_x'));

                chart.draw(data, google.charts.Line.convertOptions(options));
            }
        </script>


    <header class="food-miles-header">

        <div class="container">
            <div class="row">

                <div class="col-1" onclick="window.location = './index.jsp'">
                    <i class="icon-arrow-left"></i>
                </div>
                <div class="col-11">
                    User Scores 
                    <c:if test="${userScoresDummy == 'Dummy'}"> Dummy Data</c:if>
                    <c:if test="${userScoresDummy == 'Dummy2'}"> Dummy Data <span style="font-size: 16px;">2 Carts needed</span></c:if>
                </div>
            </div>
    </header>
</head>
<body  class="default-background">
<c:if test="${empty uScores}">
        <div class="empty-cart-text">
            Sorry you need to add items to the cart first
        </div>
    </c:if>
<c:if test="${fn:length(uScores) > 0}">
    
    <div style="margin-top: 1%;" id="line_top_x"></div>


    <div class="scoreboard">
        <div class="scoreboard-header">
            Top Foodmilers
        </div>

        <c:forEach var="s" items="${scores}">

            <div class="container">
                <div class="row">
                    <div class="col-3">
                        ${s.userName} 
                    </div>
                    <div class="col-6">
                        ${s.average}
                    </div>
                    <div class="col-3">
                        <c:if test="${s.position == '1'}">
                            <i class="fas fa-leaf firstPlace" style="color: gold"></i>
                        </c:if>
                        <c:if test="${s.position == '2'}">
                            <i class="fas fa-leaf secondPlace" style="color: silver"></i>
                        </c:if>
                    </div>
                </div>

            </div>
        </c:forEach>

    </div>
</c:if>
    
</body>
</html>
