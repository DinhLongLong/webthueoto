<%-- 
    Document   : profile
    Created on : Oct 9, 2023, 12:53:52 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="content">
    <div class="content__container">
        <div class="profile__container grid wide">
            <div class="row">
                <div class="col l-3">
                    <div class="profile__selector">
                        <div class="profile__header">
                            <div class="profile__header-top"></div>
                            <div class="profile__header-bot"></div>
                            <div class="profile__header-avt">
                                <i class="fa-solid fa-circle-user"></i>
                            </div>
                            <div class="profile__header-username">
                                <span>${user.username}</span>
                                <c:if test="${pageContext.request.userPrincipal.name != null}">
                                    <div onclick="followAction('${pageContext.request.userPrincipal.name}', '${user.username}')" id="logged" class="btn primary-btn follow-btn" data-followed="true">
                                        <c:forEach var="follow" items="${follows}">
                                            <c:if test="${pageContext.request.userPrincipal.name == follow.user.getUsername()}">
                                                <span>Đã theo dõi</span>
                                            </c:if>
                                        </c:forEach>
                                    </div>                                    
                                </c:if>
                                <c:if test="${pageContext.request.userPrincipal.name == null}">
                                    <div class="btn primary-btn follow-btn">
                                        <span>Theo dõi</span>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div id="info-user" data-index="0" data-selected="true" class="profile__selector-item">Hồ sơ người dùng</div>
                        <div id="info-product" data-index="1" data-selected="false" class="profile__selector-item">Danh sách xe cho thuê</div>
                    </div>
                </div>
                <div class="col l-9">
                    <div class="profile__info">
                        <div class="profile__info-title">
                            Thông tin chi tiết
                        </div>
                        <div class="profile__info-user">
                            <div class="profile__info-user-item">
                                Tên cá nhân/doanh nghiệp:<span> ${user.name}</span>
                            </div>
                            <div class="profile__info-user-item">
                                Số điện thoại:<span>${user.phone}</span>
                            </div>
                            <div class="profile__info-user-item">
                                Email:<span>${user.email}</span>
                            </div>
                            <div class="profile__info-user-item">
                                Địa chỉ:<span>${user.address}</span>
                            </div>
                        </div>
                        <c:if test="${fn:length(products) == 0}">
                            <div class="profile__info-product">
                                <div class="profile__noproduct">
                                    <img src="<c:url value="/img/noproduct.png"/>" alt="no-product"/>
                                    <span>Hiện chưa có xe cho thuê!</span>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${fn:length(products) != 0}">
                            <div class="profile__info-product">
                                <div class="profile__info-product-list row">
                                    <c:forEach var="product" items="${products}">
                                        <div class="col l-4">
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
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

