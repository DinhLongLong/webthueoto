/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var productDetailSelectItems = document.getElementsByClassName('productDetail__select-item');
var productDetailTech = document.querySelector('.productDetail__tech');
var productDetailProcedure = document.querySelector('.productDetail__procedure');

try {
    
//    SELECT
    let temp = 0;
    
    for (var i = 0; i < productDetailSelectItems.length; i++) {
        
        productDetailSelectItems[i].onmouseover = function() {
            if (this.getAttribute("data-selected") == "false") {
                this.style.backgroundColor = "#f7b58a";
            }
        };
        
        productDetailSelectItems[i].onmouseout = function() {
            if (this.getAttribute("data-selected") == "false") {
                this.style.backgroundColor = "#FA9554";
            }
        }
        
        productDetailSelectItems[i].onclick = function() {
            this.dataset.selected = "true";
            this.style.color = "#030303";
            this.style.backgroundColor = "#ffffff";
            for (var j = 0; j < productDetailSelectItems.length; j++) {
                if (j != this.getAttribute("data-index")) {
                    productDetailSelectItems[j].dataset.selected = "false";
                    productDetailSelectItems[j].style.color = "#ffffff";
                    productDetailSelectItems[j].style.backgroundColor = "#FA9554";
                }
            }
            if (this.id == "tech") {
                productDetailTech.style.display = "block";
                productDetailProcedure.style.display = "none";
            }
            if (this.id == "procedure") {
                productDetailProcedure.style.display = "block";
                productDetailTech.style.display = "none";
            }
        };
        
    };
    
//    OPEN COMMENT-LIST
    var openCommentBtn = document.querySelector('.productDetail__action-comment');
    var commentContainer = document.querySelector('.productDetail__comment-container');
    var commentInput = document.querySelector('.productDetail__comment-input #comment-input');
    var commentSubmit = document.querySelector('.productDetail__comment-input .comment-submit');
    
    openCommentBtn.onclick = function() {
        if (this.id != "activated") {
            commentContainer.style.display = "block";
            if ((commentInput.value).trim() == '') {
                commentSubmit.style.pointerEvents = "none";
                commentSubmit.style.color = "#d3d3d3";
            };
            this.id = "activated";
        } else {
            commentContainer.style.display = "none";
            this.id = "";
        }
    };

    commentInput.onfocus = function() {
        window.onkeyup = function() {
            if ((commentInput.value).trim() != '') {
                commentSubmit.style.pointerEvents = "all";
                commentSubmit.style.color = "#3f73db";
            } else {
                commentSubmit.style.pointerEvents = "none";
                commentSubmit.style.color = "#d3d3d3";
            };
        };
    };  
    
} catch (e) {
    console.log(e);
}



