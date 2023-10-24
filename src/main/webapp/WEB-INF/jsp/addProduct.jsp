<%-- 
    Document   : addProduct
    Created on : Oct 13, 2023, 3:55:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="content__container grid wide">
        <div class="row">
            <div class="col l-12">
                <div class="add-product__success">
                    Đăng bài cho thuê xe thành công! Bạn có muốn <span onclick="reAddProduct()">đăng thêm bài</span> hoặc trở về <a href="<c:url value="/"/>">trang chủ</a>.
                </div>
                <div class="add-product__container">
                    <div class="add-product__header">
                        Đăng bài cho thuê xe
                    </div>
                    <div class="add-product__content">                    
                        <div class="row add-product__form">
                            <div class="col l-6 add-product__form-child">

                                <label for="categories">Danh mục xe</label>
                                <select name="categories" id="categories">
                                    <c:forEach var="category" items="${categories}">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>

                                <label for="brands">Thương hiệu</label>
                                <select name="brands" id="brands">
                                    <c:forEach var="brand" items="${brands}">
                                        <option value="${brand.id}">${brand.name}</option>
                                    </c:forEach>
                                </select>

                                <label for="colors">Màu sắc xe</label>
                                <select name="colors" id="colors">
                                    <c:forEach var="color" items="${colors}">
                                        <option value="${color.id}">${color.name}</option>
                                    </c:forEach>
                                </select>

                                <label for="gearboxs">Loại hộp số</label>
                                <select name="gearboxs" id="gearboxs">
                                    <c:forEach var="gearbox" items="${gearboxs}">
                                        <option value="${gearbox.id}">${gearbox.name}</option>
                                    </c:forEach>
                                </select>

                                <label for="fuels">Nhiên liệu</label>
                                <select name="fuels" id="fuels">
                                    <c:forEach var="fuel" items="${fuels}">
                                        <option value="${fuel.id}">${fuel.name}</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="col l-6 add-product__form-child">

                                <label for="name">Tên xe</label>
                                <input type="text" id="name"/>

                                <label for="img">Link hình ảnh xe</label>
                                <input type="text" id="img"/>

                                <label for="licensePlate">Biển số xe</label>
                                <input type="text" id="licensePlate"/>

                                <label for="price">Giá thuê xe/ngày</label>
                                <input type="text" id="price"/>

                                <label for="description">Mô tả về xe</label>
                                <textarea id="description" rows="5" cols="50"></textarea>

                            </div>
                            <c:if test="${errorMessage!=null}">
                                <div class="auth__form-alert">
                                    ${errorMessage}
                                </div>
                            </c:if>
                            <div class="add-product__form-action">
                                <div class="add-product__form-recreate btn" onclick="addProductRecreate()">
                                    Tạo lại
                                </div>
                                <div class="add-product__form-submit btn primary-btn" onclick="addProduct( '${pageContext.request.userPrincipal.name}' )">
                                    Đăng bài
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
