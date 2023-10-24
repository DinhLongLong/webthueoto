<%-- 
    Document   : header
    Created on : Sep 18, 2023, 6:12:41 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<header class="header">
    <nav class="navbar grid wide">
        <ul class="nav-list">
            <a class="logo-link" href="<c:url value="/"/>">
                <img class="logo" src="<c:url value="/img/logo-main.png"/>" alt="Logo"/>
            </a>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="<c:url value="/"/>">Trang chủ</a>
            </li>
            <c:forEach var="cat" items="${categories}">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="<c:url value="/products?category=${cat.name}"/>">Xe ${cat.name}</a>
                </li>
            </c:forEach>
        </ul>
        <ul class="nav-list">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="btn header-btn" aria-current="page" href="<c:url value="/register"/>">Đăng ký</a>
                </li>
                <li class="nav-item">
                    <a class="btn header-btn primary-btn" aria-current="page" href="<c:url value="/login"/>">Đăng nhập</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <sec:authorize access="hasRole('ROLE_USER')">
                    <li class="nav-item">
                        <a class="btn header-btn primary-btn" href="<c:url value="/user/${pageContext.request.userPrincipal.name}/add-product"/>">Đăng bài cho thuê xe</a>
                    </li>
                    <li class="nav-item">
                        <div class="username">
                            <i class="fa-solid fa-circle-user"></i>
                            <span>${pageContext.request.userPrincipal.name}</span>
                            <div class="active">
                                <a class="" href="<c:url value="/user/${pageContext.request.userPrincipal.name}"/>">Trang cá nhân</a>
                                <a class="" href="<c:url value="/logout"/>">
                                    <i class="fa-solid fa-arrow-right-from-bracket"></i>
                                    Đăng xuất
                                </a>
                            </div>
                        </div>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item">
                        <a class="btn header-btn primary-btn" href="<c:url value="/admin/manage"/>">Quản lý hệ thống</a>
                    </li>
                </sec:authorize>
            </c:if>
        </ul>

    </nav>
</header>
