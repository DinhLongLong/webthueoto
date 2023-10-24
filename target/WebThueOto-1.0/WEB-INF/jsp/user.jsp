<%-- 
    Document   : user
    Created on : Oct 10, 2023, 9:07:02 PM
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
                            </div>
                        </div>
                        <div id="info-user" data-index="0" data-selected="true" class="profile__selector-item">Hồ sơ người dùng</div> 
                        <div id="info-product" data-index="1" data-selected="false" class="profile__selector-item">Danh sách xe cho thuê</div>
                        <div id="info-loveproduct" data-index="2" data-selected="false" class="profile__selector-item">Danh sách xe yêu thích</div>
                        <div id="info-follower" data-index="3" data-selected="false" class="profile__selector-item">Danh sách đã theo dõi</div>
                    </div>
                </div>
                <div class="col l-9">
                    <div class="profile__info">
                        <div class="profile__info-title">
                            Thông tin chi tiết
                        </div>
                        <div class="profile__info-user">
                            <div id="info-user-show" class="profile__info-user-list">
                                <div class="profile__info-btn">
                                    <div class="btn primary-btn change-btn" onclick="openInfoUserChange( '${user.name}', '${user.phone}', '${user.email}', '${user.address}' )">
                                        <i class="fa-solid fa-user-pen"></i>
                                        Chỉnh sửa thông tin
                                    </div> 
                                </div>
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
                            <div id="info-user-change" class="profile__info-user-list">
                                <div class="profile__info-btn">
                                    <div class="btn defaul-btn cancel-btn">
                                        Hủy
                                    </div>
                                    <div class="btn primary-btn save-btn" onclick="updateUser('${user.username}')">
                                        Lưu
                                    </div> 
                                </div>
                                
                                <label for="name">Tên cá nhân/doanh nghiệp</label>
                                <input type="text" id="name"/>

                                <label for="phone">Số điện thoại</label>
                                <input type="text" id="phone"/>

                                <label for="email">Email</label>
                                <input type="text" id="email"/>

                                <label for="address">Địa chỉ</label>
                                <input type="text" id="address"/>
                            </div>
                        </div>
                        <c:if test="${fn:length(follows) == 0}">
                            <div class="profile__info-follower">
                                <div class="profile__info-product-list">
                                    <div class="profile__noproduct">
                                        <img src="<c:url value="/img/noproduct.png"/>" alt="no-product"/>
                                        <span>Bạn hiện chưa theo dõi ai!</span>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${fn:length(follows) != 0}">
                            <div class="profile__info-follower">
                                <div class="profile__info-product-list row">
                                    <c:forEach var="follower" items="${follows}">
                                        <div class="col l-12">
                                            <a href="<c:url value="/profile/${follower.follower.getUsername()}"/>">
                                                <div class="follower__item">
                                                    <i class="fa-solid fa-circle-user"></i>
                                                    ${follower.follower.getUsername()}
                                                </div>
                                            </a>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${fn:length(products) == 0}">
                            <div class="profile__info-product">
                                <div class="profile__info-product-list">
                                    <div class="profile__noproduct">
                                        <img src="<c:url value="/img/noproduct.png"/>" alt="no-product"/>
                                        <span>Hiện chưa có xe cho thuê!</span>
                                    </div>
                                    <div class="profile__info-btn">
                                        <a href="<c:url value="/user/${pageContext.request.userPrincipal.name}/add-product"/>">
                                            <div class="btn primary-btn add-btn">
                                                <i class="fa-solid fa-circle-plus"></i>
                                                Đăng bài cho thuê xe
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${fn:length(products) != 0}">
                            <div class="profile__info-product">
                                <div class="profile__info-product-list row">
                                    <div class="profile__info-btn">
                                        <a href="<c:url value="/user/${pageContext.request.userPrincipal.name}/add-product"/>">
                                            <div class="btn primary-btn add-btn">
                                                <i class="fa-solid fa-circle-plus"></i>
                                                Đăng bài cho thuê xe
                                            </div>
                                        </a>
                                    </div>
                                    <c:forEach var="product" items="${products}">
                                        <div class="col l-4">
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
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${fn:length(loveProducts) == 0}">
                            <div class="profile__info-loveproduct">
                                <div class="profile__info-product-list">
                                    <div class="profile__noproduct">
                                        <img src="<c:url value="/img/noproduct.png"/>" alt="no-product"/>
                                        <span>Hiện chưa có xe yêu thích!</span>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${fn:length(loveProducts) != 0}">
                            <div class="profile__info-loveproduct">
                                <div class="profile__info-product-list row">
                                    <c:forEach var="loveproduct" items="${loveProducts}">
                                        <c:if test="${pageContext.request.userPrincipal.name == loveproduct.user.getUsername()}">
                                            <div class="col l-4">
                                                <div id="my-product" class="product__item">
                                                    <a href="<c:url value="/user/${loveproduct.user.getUsername()}"/>">
                                                        <div class="product__item-user">
                                                            <i class="fa-solid fa-circle-user"></i>
                                                            ${loveproduct.user.getUsername()}
                                                        </div>
                                                    </a>
                                                    <a href="<c:url value="/product-detail?product-id=${loveproduct.id}"/>">
                                                        <div class="product__item-img">
                                                            <img src="${loveproduct.img}" alt="${loveproduct.name}"/>
                                                        </div>
                                                        <div class="product__item-content">
                                                            <div class="product__item-title">
                                                                ${loveproduct.name}
                                                            </div>
                                                            <div class="product__item-info">
                                                                <span><i class="fa-solid fa-table-cells"></i>${loveproduct.licensePlate}</span>
                                                                <span><i class="fa-solid fa-people-group"></i>${loveproduct.category.getName()}</span>
                                                                <span><i class="fa-solid fa-gears"></i>${loveproduct.gearbox.getName()}</span>
                                                            </div>
                                                            <div class="product__item-price">
                                                                ${loveproduct.price} đ/ngày
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${pageContext.request.userPrincipal.name != loveproduct.user.getUsername()}">
                                            <div class="col l-4">
                                                <div id="my-product" class="product__item">
                                                    <a href="<c:url value="/profile/${loveproduct.user.getUsername()}"/>">
                                                        <div class="product__item-user">
                                                            <i class="fa-solid fa-circle-user"></i>
                                                            ${loveproduct.user.getUsername()}
                                                        </div>
                                                    </a>
                                                    <a href="<c:url value="/product-detail?product-id=${loveproduct.id}"/>">
                                                        <div class="product__item-img">
                                                            <img src="${loveproduct.img}" alt="${loveproduct.name}"/>
                                                        </div>
                                                        <div class="product__item-content">
                                                            <div class="product__item-title">
                                                                ${loveproduct.name}
                                                            </div>
                                                            <div class="product__item-info">
                                                                <span><i class="fa-solid fa-table-cells"></i>${loveproduct.licensePlate}</span>
                                                                <span><i class="fa-solid fa-people-group"></i>${loveproduct.category.getName()}</span>
                                                                <span><i class="fa-solid fa-gears"></i>${loveproduct.gearbox.getName()}</span>
                                                            </div>
                                                            <div class="product__item-price">
                                                                ${loveproduct.price} đ/ngày
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                                                        <a href="<c:url value="/user/${pageContext.request.userPrincipal.name}/product-order?product-id=${loveproduct.id}"/>">
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

