<%-- 
    Document   : footer
    Created on : Sep 18, 2023, 6:16:41 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer class="footer">
    <div class="footer__container grid wide">
        <div class="row">
            <div class="col l-3">
                <ul class="footer__list">
                    <li class="footer__item">
                        <a class="" href="<c:url value="/"/>">
                            <img class="logo" src="<c:url value="/img/logo-main.png"/>" alt="Logo"/>
                        </a>
                    </li>
                    <li class="footer__item">
                        <span>Trụ sở chính: 689/26 Nguyễn Kiệm, phường 3, Gò Vấp, TP.HCM</span>
                    </li>
                    <li class="footer__item">
                        <span>Hotline: 0374987790</span>
                    </li>
                    <li class="footer__item">
                        <span>Email: dinhlongdragon@gmail.com</span>
                    </li>
                </ul>
            </div>
            <div class="col l-3">
                <ul class="footer__list">
                    <li class="footer__title">
                        <span>DANH MỤC</span>
                    </li>
                    <li class="footer__item">
                        <a href="<c:url value="/"/>">Trang chủ</a>
                    </li>
                    <li class="footer__item">
                        <a href="<c:url value="#"/>">Giới thiệu</a>
                    </li>
                    <li class="footer__item">
                        <a href="<c:url value="#"/>">Hợp tác với chúng tôi</a>
                    </li>
                </ul>
            </div>
            <div class="col l-3">
                <ul class="footer__list">
                    <li class="footer__title">
                        <span>ĐIỀU KHOẢN & ĐIỀU KIỆN</span>
                    </li>
                    <li class="footer__item">
                        <a href="<c:url value="#"/>">Chính sách bảo mật</a>
                    </li>
                    <li class="footer__item">
                        <a href="<c:url value="#"/>">Chính sách bản quyền</a>
                    </li>
                    <li class="footer__item">
                        <a href="<c:url value="#"/>">Chính sách hủy xe và hoàn tiền</a>
                    </li>
                </ul>
            </div>
            <div class="col l-3">
                <ul class="footer__list">
                    <li class="footer__title">
                        <span>LIÊN HỆ VỚI CHÚNG TÔI</span>
                    </li>
                    <li class="footer__item social">
                        <a href="https://www.facebook.com/profile.php?id=100008105623590"><i class="fa-brands fa-square-facebook"></i></a>
                        <a href="https://www.youtube.com/channel/UClzHYRuSykeK0muE4AZSU_Q"><i class="fa-brands fa-youtube"></i></a>
                        <a href="#"><i class="fa-brands fa-google"></i></a>
                    </li>
                </ul>
            </div>
        </div>    
    </div>
    <div class="footer__bottom">
        <span>Copyright © 2021 LKOTO. ALL RIGHTS RESERVED.</span>
    </div>
</footer>
