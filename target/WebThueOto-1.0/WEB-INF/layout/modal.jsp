<%-- 
    Document   : modal
    Created on : Oct 15, 2023, 12:30:14 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal">
    <div class="modal__overlay"></div>
    <div class="modal__content">
        <div class="modal__content-warning">
            <div class="modal__content-warning-icon">
                <i class="fa-solid fa-triangle-exclamation"></i>
            </div>
            <span>Vui lòng <a href="<c:url value="/login"/>">đăng nhập</a> để thực hiện hành động này!</span>
            <span>Nếu chưa có tài khoản, <a href="<c:url value="/register"/>">đăng ký ngay</a></span>
        </div>
    </div>
</div>
