<%-- 
    Document   : confirmProduct
    Created on : Oct 15, 2023, 7:33:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
    <div class="content__container grid wide">
        <div class="productOrder__success">
            Xác nhận thuê xe thành công! Theo dõi mail để kết nối với chủ xe. Trở về <a href="<c:url value="/"/>">trang chủ</a>
        </div>
        <div class="productOrder__container">
            <div class="row">
                <div class="col l-7 productOrder__left">
                    <div class="productOrder__product">
                        <div class="productOrder__product-header">
                            <span class="productOrder__product_-title">${product.name}</span>
                            <div class="productOrder__product-price">${product.price}đ/ngày</div>
                        </div>
                        <div class="productOrder__product-img">
                            <img src="${product.img}" alt="${product.name}"/>
                        </div>
                        <div class="productOrder__product-info">
                            <div class="productOrder__product-info-title">
                                Thông tin chi tiết
                            </div>
                            <div class="productOrder__product-info-content">
                                <div class="row">
                                    <div class="productOrder__product-info-item col l-4">
                                        <i class="fa-solid fa-star"></i>
                                        <div>
                                            <span>Thương hiệu</span>
                                            <span>${product.brand.getName()}</span>
                                        </div>
                                    </div>
                                    <div class="productOrder__product-info-item col l-4">
                                        <i class="fa-solid fa-gears"></i>
                                        <div>
                                            <span>Hộp số</span>
                                            <span>${product.gearbox.getName()}</span>
                                        </div>
                                    </div>
                                    <div class="productOrder__product-info-item col l-4">
                                        <i class="fa-solid fa-palette"></i>
                                        <div>
                                            <span>Màu sơn</span>
                                            <span>${product.color.getName()}</span>
                                        </div>
                                    </div>
                                    <div class="productOrder__product-info-item col l-4">
                                        <i class="fa-solid fa-people-group"></i>
                                        <div>
                                            <span>Chỗ ngồi</span>
                                            <span>${product.category.getName()}</span>
                                        </div>
                                    </div>
                                    <div class="productOrder__product-info-item col l-4">
                                        <i class="fa-solid fa-gas-pump"></i>
                                        <div>
                                            <span>Nhiên liệu</span>
                                            <span>${product.fuel.getName()}</span>
                                        </div>
                                    </div>
                                    <div class="productOrder__product-info-item col l-4">
                                        <i class="fa-solid fa-table-cells"></i>
                                        <div>
                                            <span>Biển số</span>
                                            <span>${product.licensePlate}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col l-5 productOrder__right">
                    <div class="productOrder__form">
                        <div class="productOrder__form-content">
                            <div class="productOrder__form-input">
                                <label for="timeDay">Ngày giờ muốn thuê xe</label>
                                <input type="text" id="timeDay"/>

                                <label for="note">Lưu ý cho chủ xe( nếu có)</label>
                                <input type="text" id="note"/>
                            </div>
                            <div class="productOrder__form-warning">
                                <i class="fa-solid fa-circle-info"></i>
                                Sau khi xác nhận thuê xe, theo dõi yêu cầu ở trang cá nhân và đợi email phản hồi
                            </div>
                        </div>
                        <div onclick="addProductOrder( '${pageContext.request.userPrincipal.name}', '${product.user.getUsername()}', '${product.id}' )" class="productOrder__form-submit btn primary-btn">
                            XÁC NHẬN THUÊ
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</div>
