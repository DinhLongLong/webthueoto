<%-- 
    Document   : base
    Created on : Sep 18, 2023, 6:11:41 AM
    Author     : Admin
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
<!--        <meta http-equiv="X-UA-Compatible" content="IE=edge">-->
        <meta http-equiv="Content-Type" content="text/html">
<!--        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"/>-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="icon" href="<c:url value="/img/icon-removebg.ico"/>">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;1,300&display=swap"/>
        <link rel="stylesheet" href="<c:url value="/css/base.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/header.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/footer.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/modal.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/home.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/authForm.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/product.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/productDetail.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/profile.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/user.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/addProduct.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/productOrder.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/admin.css"/>"/>
        <title>
            <tiles:insertAttribute name="title"/>
        </title>
    </head>
    <body class="container">
        <tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="content"/>
        <tiles:insertAttribute name="footer"/>
        <tiles:insertAttribute name="modal"/>
        <script src="<c:url value="/js/base.js"/>"></script>
        <script src="<c:url value="/js/header.js"/>"></script>
        <script src="<c:url value="/js/login.js"/>"></script>
        <script src="<c:url value="/js/productDetail.js"/>"></script>
        <script src="<c:url value="/js/profile.js"/>"></script>
        <script src="<c:url value="/js/script.js"/>"></script>
        <script src="<c:url value="/js/user.js"/>"></script>
        <script src="<c:url value="/js/addProduct.js"/>"></script>
        <script src="<c:url value="/js/admin.js"/>"></script>
    </body>
</html>
