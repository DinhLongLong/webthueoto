<%-- 
    Document   : register
    Created on : Sep 18, 2023, 6:59:54 AM
    Author     : Admin
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="content__container grid wide">
        <div class="row">
            <c:url value="/register" var="action"/>
            <form:form cssClass="col l-4 auth__form" method="POST" action="${action}" modelAttribute="user">
                <div class="auth__form-header">
                    Đăng ký
                </div>
                <div class="auth__form-input">
                    <label for="username">Tên đăng nhập</label>
                    <form:input type="text" id="username" path="username" class="form-control"/>
                    
                    <label for="password">Mật khẩu</label>
                    <form:input type="password" id="password" path="password" class="form-control"/>
                    
                    <label for="confirm-password">Nhập lại mật khẩu</label>
                    <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
                    
                    <label for="name">Tên cá nhân/doanh nghiệp</label>
                    <form:input type="text" id="name" path="name" class="form-control"/>
                    
                    <label for="phone">Số điện thoại</label>
                    <form:input type="text" id="phone" path="phone" class="form-control"/>
                    
                    <label for="email">Email</label>
                    <form:input type="text" id="email" path="email" class="form-control"/>

                    <label for="address">Địa chỉ</label>
                    <form:input type="text" id="address" path="address" class="form-control"/>
                </div>
                <c:if test="${errorMessage!=null}">
                    <div class="auth__form-alert">
                        ${errorMessage}
                    </div>
                </c:if>
                <div class="auth__form-submit btn">
                    <input type="submit" value="Đăng ký" class="primary-btn"/>
                </div>
                <span class="auth__form-text">Bạn đã có tài khoản? <a href="<c:url value="/login"/>">ĐĂNG NHẬP NGAY</a></span>
            </form:form>
        </div>
    </div>
</div>
