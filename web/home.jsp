<%-- 
    Document   : home
    Created on : May 17, 2021, 7:23:07 PM
    Author     : hoandk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                        ${d.title}
                    </div>
                    <div class="image">
                        <img src="img/${d.image}" alt=""/>
                    </div>
                    <div class="description">
                        ${d.description}
                    </div>
                    <div class="information">
                        By ${d.author} | ${d.timePost} 
                    </div>
                </div>
                        <jsp:include page="right.jsp"/>

            </div>
            <div class="footer"></div>

        </div>
    </body>
</html>
