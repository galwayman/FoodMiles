<%-- 
    Document   : userScores
    Created on : 19-Feb-2021, 15:43:45
    Author     : coola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<!DOCTYPE html>
<html>
    <head>
        <title>User Scores</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="./homeStyles.css">


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
                    height: 750,
                    colors: ['#2d6d2d', 'Orange'],
                    vAxis: {
                        viewWindow: {
                            min: 0,
                            max: ${highScore}+100
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
        User Scores
    </header>
</head>
<body  class="default-background">

    <div style="margin-top: 1%;" id="line_top_x"></div>
</body>
</html>
