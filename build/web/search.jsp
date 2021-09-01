<%-- 
    Document   : search
    Created on : May 19, 2021, 11:48:00 AM
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
                    <c:if test="${listSearch.size()==0}">                   
                        <h1 style="color: #9e1515"> CAN NOT FOUND!!</h1>
                    </c:if>
                    <c:forEach items="${listSearch}" var="c">
                        <div class="title" ><a href="DetailController?id=${c.ID}" style="color: #0f7a31;"> ${c.title}</a></div>
                        <div class="image"><img src="img/${c.image}" style="width: 200px; " alt=""/></div>
                        <div class="shortDes" ;">${c.shortDes}</div>
                    </c:forEach>

                    <div class="paging">
                        <c:forEach begin="1" end="${endPage}" var="i">
                            <a href="SearchController?index=${i}&search=${search}""
                               <c:if test="${index==i}">style="color: black ; background: red;"</c:if>
                                   >${i}</a>
                        </c:forEach>
                    </div>
                </div>
                <jsp:include page="right.jsp"/>
            </div>
            <div class="footer">

            </div>

        </div>
    </body>
</html>
