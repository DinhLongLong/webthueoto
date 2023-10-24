<%-- 
    Document   : admin
    Created on : Oct 19, 2023, 6:33:55 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="content">
    <div class="content__container grid wide">
        <div class="row">
            <div class="col l-12 admin__container">
                <div class="admin__selector row">
                    <div id="selector-user" class="col l-4 admin__selector-item" data-selected="true" data-index="0">
                        Danh sách người dùng
                    </div>
                    <div id="selector-product" class="col l-4 admin__selector-item" data-selected="false" data-index="1">
                        Danh sách xe
                    </div>
                    <div id="selector-product-order" class="col l-4 admin__selector-item" data-selected="false" data-index="2">
                        Danh sách yêu cầu
                    </div>
                </div>
                <div class="admin__content">
                    <div class="admin__user">
                        <div class="admin__header">
                            Số lượng người dùng hệ thống: ${fn:length(users) - 1}
                        </div>
                        <div class="admin__user-list row">
                            <c:forEach var="user" items="${users}">
                                <c:if test="${user.getUserRole() == 'ROLE_USER'}">
                                    <div class="col l-3">
                                        <div class="admin__user-item">
                                            <a href="<c:url value="/profile/${user.username}"/>">
                                                <i class="fa-solid fa-circle-user"></i>
                                                ${user.username}
                                            </a>
                                            <div onclick="deleteUser('${user.username}')" class="btn admin__user-remove-btn">
                                                <i class="fa-solid fa-xmark"></i>
                                                Xóa
                                            </div>
                                        </div>      
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="admin__product">
                        <div class="admin__header">
                            Số lượng xe hệ thống: ${fn:length(products)}
                        </div>
                        <div class="profile__info-product-list row">
                            <c:forEach var="product" items="${products}">
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
                                        <div onclick="deleteProduct('${product.id}')" class="btn product__item-btn admin__product-remove-btn">
                                            Xóa
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="admin__productOrder">
                        <div class="admin__header">
                            Số lượng yêu cầu hệ thống: ${fn:length(productOrders)}
                        </div>
                        <div class="admin__productOrder-list">
                            <c:forEach var="productOrder" items="${productOrders}">
                                <div class="row">
                                    <div class="col l-12">
                                        <div class="admin__productOrder-item">
                                            <div class="admin__productOrder-item-info">
                                                <span>Người thuê: ${productOrder.user.getUsername()}</span>
                                                <span>Xe muốn thuê: ${productOrder.product.getName()}</span>
                                                <span>Chủ xe: ${productOrder.owner.getUsername()}</span>
                                            </div>
                                            <div class="admin__productOrder-item-action">
                                                <c:if test="${productOrder.confirmStatus == 'pending'}">
                                                    <span>Trạng thái: Đang chờ</span>
                                                    <span onclick="checkProductOrder('${productOrder.id}')" id="check-btn" class="btn check-btn primary-btn">Duyệt</span>
                                                    <span onclick="cancelProductOrder('${productOrder.id}')" id="cancel-btn" class="btn cancel-btn">Hủy</span>
                                                </c:if>
                                                <c:if test="${productOrder.confirmStatus == 'checked'}">
                                                    <span>Trạng thái: Đã duyệt</span>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
