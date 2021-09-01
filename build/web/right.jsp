<%-- 
    Document   : right
    Created on : May 19, 2021, 11:18:32 AM
    Author     : hoandk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="right">
            <div class="newRight">
                Digital news
            </div>
            <div class="shortDes">
                ${d.shortDes}

            </div>
            <div class="newRight"> Search</div>

            
            <form action="SearchController" method="get">
                <div class="search">
                    <input class="input" name="search" type="text">
                    <input class="submit" type="submit" value="Go">
                </div>
            </form>
            <div class="newRight"> Last Articles</div>
            <c:forEach items="${list}" var="c">
                <div class="list">
                    <a href="../Digital_New/DetailController?id=${c.ID}"> ${c.title}</a>  
                </div>
            </c:forEach>
        </div>
    </body>
</html>
