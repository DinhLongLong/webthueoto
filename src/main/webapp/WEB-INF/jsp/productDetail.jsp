<%-- 
    Document   : productDetail
    Created on : Sep 25, 2023, 2:10:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="content">   
    <div class="content__container grid wide">
        <div class="row">
            <div class="col l-7 productDetail__left">
                <div class="productDetail__img">
                    <img src="${product.img}" alt="${product.name}"/>
                    <div class="productDetail__action">
                        <div class="productDetail__action-container">
                            <div class="productDetail__action-left">
                                <c:if test="${pageContext.request.userPrincipal.name == null}">
                                    <div class="productDetail__action-love" style="pointer-events: none;">
                                        <i class="fa-regular fa-heart"></i>Yêu thích
                                    </div>
                                </c:if>
                                <c:if test="${pageContext.request.userPrincipal.name != null}">
                                    <div class="productDetail__action-love" onclick="loveAction('${pageContext.request.userPrincipal.name}','${product.id}')">
                                        <c:forEach var="love" items="${loves}">
                                            <c:if test="${pageContext.request.userPrincipal.name == love.user.getUsername()}">
                                                <i class="fa-solid fa-heart"></i>Đã yêu thích
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </c:if>
                                <div id="" class="productDetail__action-comment">
                                    <i class="fa-regular fa-comment"></i>Bình luận(${fn:length(comments)})
                                </div>
                            </div>
                            <div class="productDetail__action-user">
                                Người đăng:
                                <c:if test="${product.user.getUsername() == pageContext.request.userPrincipal.name}">
                                    <a href="<c:url value="/user/${product.user.getUsername()}"/>">
                                        ${product.user.getUsername()}
                                    </a>
                                </c:if>
                                <c:if test="${product.user.getUsername() != pageContext.request.userPrincipal.name}">
                                    <a href="<c:url value="/profile/${product.user.getUsername()}"/>">
                                        ${product.user.getUsername()}
                                    </a>
                                </c:if>
                            </div>
                        </div>
                        <div class="productDetail__comment-container">
                            <div class="productDetail__comment-heaader">
                                Danh sách bình luận:
                            </div>
                            <div class="productDetail__comment-list">
                                <c:if test="${fn:length(comments) == 0}">
                                    <div class="productDetail__nocomment">
                                        <img src="<c:url value="/img/nocomment.png"/>" alt="no-product"/>
                                        <span>Hiện chưa có bình luận!</span>
                                    </div>
                                </c:if>
                                <c:forEach var="cmt" items="${comments}">
                                    <div class="productDetail__comment-item">
                                        <c:if test="${cmt.user.getUsername() == pageContext.request.userPrincipal.name}">
                                            <a href="<c:url value="/user/${cmt.user.getUsername()}"/>">
                                                <i class="fa-solid fa-circle-user"></i>${cmt.user.getUsername()}
                                            </a>
                                        </c:if>
                                        <c:if test="${cmt.user.getUsername() != pageContext.request.userPrincipal.name}">
                                            <a href="<c:url value="/profile/${cmt.user.getUsername()}"/>">
                                                <i class="fa-solid fa-circle-user"></i>${cmt.user.getUsername()}
                                            </a>
                                        </c:if>
                                        <span>${cmt.content}</span>
                                    </div>
                                </c:forEach>
                            </div>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                                <div class="productDetail__comment-warning">
                                    Vui lòng <a href="<c:url value="/login"/>">đăng nhập</a> để tham gia bình luận!
                                </div>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <div class="productDetail__comment-input">
                                    <textarea id="comment-input" name="" rows="1" cols="5" type="text" id="content" placeholder="Viết bình luận..."></textarea>
                                    <div class="comment-submit" onclick="addComment( `${pageContext.request.userPrincipal.name}`, ${product.id}, ${fn:length(comments)} )">
                                        <i class="fa-solid fa-paper-plane"></i>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="productDetail__left-container">
                    <div class="productDetail__select">
                        <div id="tech" data-index="0" data-selected="true" class="productDetail__select-item">
                            Công nghệ tiện ích
                        </div>
                        <div id="procedure" data-index="1" data-selected="false" class="productDetail__select-item">
                            Thủ tục thuê xe
                        </div>
                    </div>
                    <div class="productDetail__tech">
                        <div class="productDetail__tech-header">
                            <div class="productDetail__tech-title">
                                Công nghệ tiện ích
                            </div>
                            <span>Xe đời mới đầy đủ công nghệ tiện ích</span>
                        </div>
                        <div class="row">
                            <span class="col l-3 productDetail__tech-item"><i class="fa-solid fa-map"></i>Bản đồ</span>
                            <span class="col l-3 productDetail__tech-item"><i class="fa-brands fa-bluetooth"></i>Bluetooth</span>
                            <span class="col l-3 productDetail__tech-item"><i class="fa-brands fa-usb"></i>Khe cắm USB</span>
                            <span class="col l-3 productDetail__tech-item"><i class="fa-solid fa-camera"></i>Camera trước sau</span>
                            <span class="col l-3 productDetail__tech-item"><i class="fa-solid fa-location-dot"></i>Định vị GPS</span>
                            <span class="col l-3 productDetail__tech-item"><i class="fa-solid fa-circle-dot"></i>Lốp dự phòng</span>
                            <span class="col l-3 productDetail__tech-item"><i class="fa-solid fa-gauge-high"></i>Cảnh báo tốc độ</span>
                        </div>
                    </div>
                    <div class="productDetail__procedure">
                        <div class="productDetail__procedure-header">
                            <div class="productDetail__procedure-title">
                                Thủ tục thuê xe  
                            </div>
                            <span>Qui định rõ ràng - Xét duyệt đơn giản</span>
                        </div>
                        <div class="productDetail__procedure-container">
                            <div class="productDetail__procedure-item">
                                <img src="<c:url value="/img/product-detail-procedure-1.png"/>" alt="alt"/>
                                <div class="productDetail__procedure-text">
                                    <h3>Giấy tờ cần xuất trình</h3>
                                    <span><i class="fa-solid fa-check"></i>Căn cước công dân</span>
                                    <span><i class="fa-solid fa-check"></i>Passport</span>
                                    <span><i class="fa-solid fa-check"></i>Bằng lái xe</span>
                                </div>
                            </div>
                            <div class="productDetail__procedure-item">
                                <img src="<c:url value="/img/product-detail-procedure-2.png"/>" alt="alt"/>
                                <div class="productDetail__procedure-text">
                                    <h3>Tiền cần thế chấp khi thuê</h3>
                                    <span><i class="fa-solid fa-check"></i><p>30.000.000 VND</p> (Khách nội thành)</span>
                                    <span><i class="fa-solid fa-check"></i><p>40.000.000 VND</p> (Khách tỉnh)</span>
                                    <span><i class="fa-solid fa-check"></i><p>50.000.000 VND</p> (Khách toàn quốc)</span>
                                </div>
                            </div>
                            <div class="productDetail__procedure-warning">
                                Sau 20h tính phí phát sinh 200.000đ/giờ. Sau 22h Gia Đình Việt không nhận xe và tính phí ngày mới.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col l-5 productDetail__right">
                <div class="productDetail__right-container">                 
                    <div class="productDetail__header">
                        <span class="productDetail__title">${product.name}</span>
                        <div class="productDetail__price">${product.price}đ/ngày</div>
                    </div>
                    <div class="productDetail__warning">
                        <h3><i class="fa-solid fa-circle-info"></i>Thứ 7 & CN cộng thêm phí 100,000đ/xe</h3>
                        <span>Một ngày thuê được tính từ 21h ngày hôm trước đến 20h ngày hôm sau. Ngoài giờ tính thêm 200,000đ/giờ. Qua 22h sẽ không nhận xe và tính thành ngày mới.</span>
                    </div>
                    <div class="productDetail__info">
                        <div class="productDetail__info-title">
                            Thông tin chi tiết
                        </div>
                        <div class="row">
                            <div class="productDetail__info-item col l-6">
                                <i class="fa-solid fa-star"></i>
                                <div>
                                    <span>Thương hiệu</span>
                                    <span>${product.brand.getName()}</span>
                                </div>
                            </div>
                            <div class="productDetail__info-item col l-6">
                                <i class="fa-solid fa-gears"></i>
                                <div>
                                    <span>Hộp số</span>
                                    <span>${product.gearbox.getName()}</span>
                                </div>
                            </div>
                            <div class="productDetail__info-item col l-6">
                                <i class="fa-solid fa-palette"></i>
                                <div>
                                    <span>Màu sơn</span>
                                    <span>${product.color.getName()}</span>
                                </div>
                            </div>
                            <div class="productDetail__info-item col l-6">
                                <i class="fa-solid fa-people-group"></i>
                                <div>
                                    <span>Chỗ ngồi</span>
                                    <span>${product.category.getName()}</span>
                                </div>
                            </div>
                            <div class="productDetail__info-item col l-6">
                                <i class="fa-solid fa-gas-pump"></i>
                                <div>
                                    <span>Nhiên liệu</span>
                                    <span>${product.fuel.getName()}</span>
                                </div>
                            </div>
                            <div class="productDetail__info-item col l-6">
                                <i class="fa-solid fa-table-cells"></i>
                                <div>
                                    <span>Biển số</span>
                                    <span>${product.licensePlate}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="productDetail__warning">
                        <span>Chọn  "xác nhận thuê xe" để chọn ngày giờ thuê và kết nối với chủ xe!</span>
                    </div>
                </div>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <a class="btn primary-btn productDetail__confirm" href="<c:url value="/user/${pageContext.request.userPrincipal.name}/product-order?product-id=${product.id}"/>">ĐẶT XE NGAY</a>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <div onclick="warningLogin()" id="not-login" class="btn primary-btn productDetail__confirm">
                        ĐẶT XE NGAY
                    </div>
                </c:if>
            </div>
        </div>
    </div>   
</div>

