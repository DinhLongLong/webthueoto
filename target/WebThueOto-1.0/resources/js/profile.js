/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var profileSelectorItems = document.querySelectorAll('.profile__selector-item');
var profileInfoTitle = document.querySelector('.profile__info-title');
var profileInfoUser = document.querySelector('.profile__info-user');
var profileInfoProduct = document.querySelector('.profile__info-product');
var profileInfoLoveProduct = document.querySelector('.profile__info-loveproduct');
var profileInfoFollower = document.querySelector('.profile__info-follower');

try {
    for (var i = 0; i < profileSelectorItems.length; i++) {
        profileSelectorItems[i].onclick = function() {
            if (this.getAttribute("data-selected") != "true") {
                this.style.boxShadow = "0 0.1rem 0.6rem 0.4rem rgba(250, 149, 84, 0.8)";
                this.dataset.selected = "true";
                for (var j = 0; j < profileSelectorItems.length; j++) {
                    if (j != this.getAttribute("data-index")) {
                        profileSelectorItems[j].dataset.selected = "false";
                        profileSelectorItems[j].style.boxShadow = "0 0.1rem 0.6rem 0.4rem rgba(132, 152, 208, 0.1)";
                    };
                };
                if (this.id == "info-user") {
                    profileInfoTitle.innerText = "Thông tin chi tiết";
                    profileInfoUser.style.display = "block";
                    profileInfoProduct.style.display = "none";
                    if (profileInfoLoveProduct != null) {
                        profileInfoLoveProduct.style.display = "none";
                    }
                    if (profileInfoFollower != null) {
                        profileInfoFollower.style.display = "none";
                    }
                };
                if (this.id == "info-product") {
                    profileInfoTitle.innerText = "Danh sách xe";
                    profileInfoProduct.style.display = "block";
                    profileInfoUser.style.display = "none";  
                    if (profileInfoLoveProduct != null) {
                        profileInfoLoveProduct.style.display = "none";
                    }
                    if (profileInfoFollower != null) {
                        profileInfoFollower.style.display = "none";
                    }
                };
                if (this.id == "info-loveproduct") {
                    profileInfoTitle.innerText = "Danh sách xe yêu thích";
                    profileInfoLoveProduct.style.display = "block";
                    profileInfoUser.style.display = "none";
                    profileInfoProduct.style.display = "none";
                    profileInfoFollower.style.display = "none";
                };
                if (this.id == "info-follower") {
                    profileInfoTitle.innerText = "Danh sách người dùng đã theo dõi";
                    profileInfoFollower.style.display = "block";
                    profileInfoUser.style.display = "none";
                    profileInfoProduct.style.display = "none";
                    profileInfoLoveProduct.style.display = "none";
                };
            };
        };
    };
} catch (exception) {
    console.log(exception); 
}



