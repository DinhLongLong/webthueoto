/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
try {

    window.onload = function () {
    //    SET CONTENT PADDING TOP
        let header = document.querySelector('.header');
        let contentContainer = document.querySelector('.content__container');
        let headerHeight = header.clientHeight;
        let content = document.querySelector('.content');

        content.style.paddingTop = headerHeight.toString()+"px";
        contentContainer.style.padding = "2rem 0";

    //    CHECK LOVE
        let productDetailActionLove = document.querySelector('.productDetail__action-love');
        
        if(productDetailActionLove != null) {
            if (productDetailActionLove.innerText == "") {
                productDetailActionLove.id = "";
                productDetailActionLove.innerHTML = `
                    <i class="fa-regular fa-heart"></i>Yêu thích
                `;
            } else {
                productDetailActionLove.id = "loved";
            }
        }

    //    CHECK FOLLOW
        let followBtn = document.querySelector('.follow-btn');
        let followBtnText = document.querySelector('.follow-btn span');
        let modal = document.querySelector('.modal');
        
        if ( followBtn != null) {
            if ( followBtnText == null ) {
                followBtn.innerHTML = followBtn.innerHTML + `
                    <span>Theo dõi</span>
                `;
                followBtn.dataset.followed = "false";
            } else {
                followBtn.onclick = function() {
                    if (this.id != "logged") {
                        modal.style.display = "flex";
                    };
                };
            };
        };
    };
} catch (exception) {
    console.log(exception);
};

//MODAL ACTION

//function modalLinkAction() {
//    modal.style.display = "none";
//};

var modalOverlay = document.querySelector('.modal__overlay');
var modal = document.querySelector('.modal');

modalOverlay.onclick = function() {
    modal.style.display = "none";
};


//WARNING LOGIN

function warningLogin() {
    modal.style.display = "flex";
};

