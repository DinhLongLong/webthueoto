<%-- 
    Document   : login
    Created on : Sep 18, 2023, 6:58:56 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="content__container grid wide">
        <div class="row">
            <c:if test="${param.accessDenied != null}">
                <div class="alert alert-danger">
                    Bạn không có quyên truy cập!
                </div>
            </c:if>
            <c:url value="/login" var="action"/>
            <form class="col l-4 auth__form" method="POST" action="${action}">
                <div class="auth__form-header">
                    Đăng nhập
                </div>
                <div class="auth__form-input">
                    <label for="username">Tên đăng nhập</label>
                    <input type="text" id="username" name="username" class="form-control">
                    <label for="password">Mật khẩu</label>
                    <input type="password" id="password" name="password" class="form-control">
                </div>
                <c:if test="${errorMessage != null}">
                    <div class="auth__form-alert">
                        ${errorMessage}
                    </div>
                </c:if>
                <div class="auth__form-submit btn">
                    <input class="primary-btn" type="submit" value="Đăng nhập"/>
                </div>
                <span class="auth__form-text">Bạn chưa có tài khoản? <a href="<c:url value="/register"/>">ĐĂNG KÝ NGAY</a></span>
            </form>
        </div>
    </div>
</div>
