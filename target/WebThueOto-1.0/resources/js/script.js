/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//LOVE ACTION
function loveAction(username, productId) {
    let productDetailActionLove = document.querySelector('.productDetail__action-love');
    
    if (productDetailActionLove.id == "loved") {
        fetch("/WebThueOto/api/user/delete-love", {
            method: 'post',
            body: JSON.stringify({
                "username": username,
                "productId": productId
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            return res.json();
        }).then(function() {
            productDetailActionLove.id = "";
            productDetailActionLove.innerHTML = `
                <i class="fa-regular fa-heart"></i>Yêu thích
            `;
        });
    } else {
        fetch("/WebThueOto/api/user/add-love", {
            method: 'post',
            body: JSON.stringify({
                "username": username,
                "productId": productId
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            return res.json();
        }).then(function() {
            productDetailActionLove.id = "loved";
            productDetailActionLove.innerHTML = `
                <i class="fa-solid fa-heart"></i>Đã yêu thích
            `;
        });
    }
};

//COMMENT ACTION
var commentInput = document.querySelector('.productDetail__comment-input #comment-input');

function addComment(username, productId, commentsLength) {
    fetch("/WebThueOto/api/user/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "username": username,
            "productId": productId,
            "content": commentInput && commentInput.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        let commentList = document.querySelector('.productDetail__comment-list');
        let openCommentBtn = document.querySelector('.productDetail__action-comment');
        let nocomment = document.querySelector('.productDetail__nocomment');
        
        commentInput.value = '';
        
        if(commentsLength == 0) {
            nocomment.style.display = "none";
        };

        commentList.innerHTML = commentList.innerHTML + `
            <div class="productDetail__comment-item" style="animation: 0.8s linear 2 NewComment;">
                <a href="/WebThueOto/profile/${data && data.user && data.user.username || ''}">
                    <i class="fa-solid fa-circle-user"></i>${data && data.user && data.user.username || ''}
                </a>
                <span>${data.content}</span>
            </div>
        `;
    
        let tempCommentsLength = document.querySelectorAll('.productDetail__comment-item').length;
    
        openCommentBtn.innerHTML = `
            <div id="" class="productDetail__action-comment">
                <i class="fa-regular fa-comment"></i>Bình luận(${tempCommentsLength})
            </div>
        `;
//        focus bottom comment list when comment success
        commentList.scrollTop = commentList.scrollHeight;
    
        let commentItems = document.querySelectorAll('.productDetail__comment-item');
        let commentSubmit = document.querySelector('.productDetail__comment-input .comment-submit');
        
//        disable comment submit when comment success
        commentSubmit.style.pointerEvents = "none";
        commentSubmit.style.color = "#d3d3d3";
        
//        remove animation comment item before
        if (commentItems.length >= 2) {
            commentItems[commentItems.length - 2].style.animation = "none";
        } 

//        location.reload();
   });
}

//UPDATE USER
function updateUser(username) {
   
    let name = document.getElementById("name").value;
    let phone = document.getElementById("phone").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    
    fetch("/WebThueOto/api/user/update-user", {
        method: 'post',
        body: JSON.stringify({
            "username": username,
            "name": name,
            "phone": phone,
            "email": email,
            "address": address
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function() {
        location.reload();
    });
};
//ADD PRODUCT
function addProduct(username) {
    
    let category = document.getElementById("categories").value;
    let brand = document.getElementById("brands").value;
    let color = document.getElementById("colors").value;
    let gearbox = document.getElementById("gearboxs").value;
    let fuel = document.getElementById("fuels").value;
    let name = document.getElementById("name").value;
    let img = document.getElementById("img").value;
    let licensePlate = document.getElementById("licensePlate").value;
    let price = document.getElementById("price").value;
    let description = document.getElementById("description").value;
    
    let addProductSuccess = document.querySelector('.add-product__success');
    let addProductContainer = document.querySelector('.add-product__container');
    
    fetch("/WebThueOto/api/user/add-product", {
        method: 'post',
        body: JSON.stringify({
            "username": username,
            "category": category,
            "brand": brand,
            "color": color,
            "gearbox": gearbox,
            "fuel": fuel,
            "name": name,
            "img": img,
            "licensePlate": licensePlate,
            "price": price,
            "description": description
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function() {
        addProductContainer.style.display = "none";
        addProductSuccess.style.display = "block";
    });
};

//FOLLOW ACTION
function followAction(username, followerName) {
    let followBtn = document.querySelector('.follow-btn');
    
    if ( followBtn.getAttribute("data-followed") == "false" ) {
        fetch("/WebThueOto/api/user/add-follow", {
            method: 'post',
            body: JSON.stringify({
                "username": username,
                "followerName": followerName
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            return res.json();
        }).then(function() {
            followBtn.dataset.followed = "true";
            followBtn.innerHTML = `
                <span>Đã theo dõi</span>
            `;
        });
    } else {
        fetch("/WebThueOto/api/user/delete-follow", {
            method: 'post',
            body: JSON.stringify({
                "username": username,
                "followerName": followerName
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            return res.json();
        }).then(function() {
            followBtn.dataset.followed = "false";
            followBtn.innerHTML = `
                <span>Theo dõi</span>
            `;
        });
    }
};

//ADD ORDER
function addProductOrder(username, ownername, productId) {
    let timeDay = document.getElementById("timeDay").value;
    let note = document.getElementById("note").value;
    let orderContainer = document.querySelector('.productOrder__container');
    let orderSuccess = document.querySelector('.productOrder__success');
    
    fetch("/WebThueOto/api/user/product-order", {
        method: 'post',
        body: JSON.stringify({
            "username": username,
            "ownername": ownername,
            "productId": productId,
            "timeDay": timeDay,
            "note": note
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function() {
        orderContainer.style.display = "none";
        orderSuccess.style.display = "block";
    });
};

//DELETE USER

function deleteUser(username) {
    
    fetch("/WebThueOto/api/admin/delete-user", {
        method: 'post',
        body: JSON.stringify({
            "username": username
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function() {
        location.reload();
    });
};

//DELETE PRODUCT

function deleteProduct(productId) {
    
    fetch("/WebThueOto/api/admin/delete-product", {
        method: 'post',
        body: JSON.stringify({
            "productId": productId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function() {
        location.reload();
    });
};

//PRODUCT ORDER ACTION
 function checkProductOrder(productOrderId) {
    let adminProductOrderItemAction = document.querySelector('.admin__productOrder-item-action');
     
    fetch("/WebThueOto/api/admin/check-product-order", {
        method: 'post',
        body: JSON.stringify({
            "productOrderId": productOrderId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function() {
//        adminProductOrderItemAction.innerHTML = `
//            <span>Trạng thái: Đã duyệt</span>
//        `;
        location.reload();
    });
 };
 
 function cancelProductOrder(productOrderId) {
    let adminProductOrderItemAction = document.querySelector('.admin__productOrder-item-action');
     
    fetch("/WebThueOto/api/admin/delete-product-order", {
        method: 'post',
        body: JSON.stringify({
            "productOrderId": productOrderId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function() {
//        adminProductOrderItemAction.innerHTML = `
//            <span>Trạng thái: Đã hủy</span>
//        `;
        location.reload();
    });
 };