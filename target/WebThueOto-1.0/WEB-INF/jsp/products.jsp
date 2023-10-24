<%-- 
    Document   : products
    Created on : Oct 13, 2023, 6:48:11 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="content">
    <div class="content__container grid wide">
        <div class="content__header">
            <span>Danh sách xe ${categoryName}</span>
        </div>
        <c:if test="${fn:length(products) == 0}">
            <div class="content__noproduct">
                <img src="<c:url value="/img/noproduct.png"/>" alt="no-product"/>
                <span>Hiện chưa có xe ${categoryName} cho thuê!</span>
            </div>
        </c:if>
        <c:if test="${fn:length(products) != 0}">
            <div class="row">
                <c:forEach var="product" items="${products}">
                    <c:if test="${pageContext.request.userPrincipal.name != product.user.getUsername()}">
                        <div class="col l-3">
                            <div id="not-my-product" class="product__item">
                                <a href="<c:url value="/profile/${product.user.getUsername()}"/>">
                                    <div class="product__item-user">
                                        <i class="fa-solid fa-circle-user"></i>
                                        ${product.user.getUsername()}
                                    </div>
                                </a>
                                <a href="<c:url value="/product-detail?product-id=${product.id}"/>">
                                    <div class="product__item-img">
                                        <img src="${product.img}" alt="${product.name}"/>
                                    </div>
                                    <div class="product__item-content">
                                        <div class="product__item-title">
                                            ${product.name}
                                        </div>
                                        <div class="product__item-info">
                                            <span><i class="fa-solid fa-table-cells"></i>${product.licensePlate}</span>
                                            <span><i class="fa-solid fa-people-group"></i>${product.category.getName()}</span>
                                            <span><i class="fa-solid fa-gears"></i>${product.gearbox.getName()}</span>
                                        </div>
                                        <div class="product__item-price">
                                            ${product.price} đ/ngày
                                        </div>
                                    </div>
                                </a>
                                <c:if test="${pageContext.request.userPrincipal.name != null}">
                                    <a href="<c:url value="/user/${pageContext.request.userPrincipal.name}/product-order?product-id=${product.id}"/>">
                                        <div class="product__item-btn">
                                            Đặt xe ngay
                                        </div>
                                    </a>
                                </c:if>
                                <c:if test="${pageContext.request.userPrincipal.name == null}">
                                    <div onclick="warningLogin()" id="not-login" class="product__item-btn">
                                        Đặt xe ngay
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name == product.user.getUsername()}">
                        <div class="col l-3">
                            <div id="my-product" class="product__item">
                                <a href="<c:url value="/user/${product.user.getUsername()}"/>">
                                    <div class="product__item-user">
                                        <i class="fa-solid fa-circle-user"></i>
                                        ${product.user.getUsername()}
                                    </div>
                                </a>
                                <a href="<c:url value="/product-detail?product-id=${product.id}"/>">
                                    <div class="product__item-img">
                                        <img src="${product.img}" alt="${product.name}"/>
                                    </div>
                                    <div class="product__item-content">
                                        <div class="product__item-title">
                                            ${product.name}
                                        </div>
                                        <div class="product__item-info">
                                            <span><i class="fa-solid fa-table-cells"></i>${product.licensePlate}</span>
                                            <span><i class="fa-solid fa-people-group"></i>${product.category.getName()}</span>
                                            <span><i class="fa-solid fa-gears"></i>${product.gearbox.getName()}</span>
                                        </div>
                                        <div class="product__item-price">
                                            ${product.price} đ/ngày
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>
