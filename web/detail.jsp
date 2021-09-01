<%-- 
    Document   : Detail
    Created on : May 19, 2021, 11:46:49 AM
    Author     : hoandk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="container">
            <div class="preheader"></div>
            <jsp:include page="header.jsp"/>
            <div class="menu">
                <a href="../Digital_New/HomeController">News</a>
            </div>
            <div class="main">
                <div class="left">
                    <div class="title">
                        ${de.title}
                    </div>
                    <div class="image">
                        <img src="img/${de.image}" alt=""/>
                    </div>
                    <div class="description">
                        ${de.description}
                    </div>
                    <div class="information">
                        By ${de.author} | ${de.timePost} 
                    </div>
                </div>
                <jsp:include page="right.jsp"/>

            </div>
            <div class="footer"></div>

        </div>
    </body>
</body>
</html>
