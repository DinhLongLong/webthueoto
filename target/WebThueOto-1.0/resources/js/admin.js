/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var adminSelectorItems = document.querySelectorAll('.admin__selector-item');
var adminUser = document.querySelector('.admin__user');
var adminProduct = document.querySelector('.admin__product');
var adminProductOrder = document.querySelector('.admin__productOrder');

try {
    for (var i = 0; i < adminSelectorItems.length; i++) {
        
        adminSelectorItems[i].onmouseover = function() {
            if (this.getAttribute("data-selected") == "false") {
                this.style.backgroundColor = "#f7b58a";
            }
        };
        
        adminSelectorItems[i].onmouseout = function() {
            if (this.getAttribute("data-selected") == "false") {
                this.style.backgroundColor = "#FA9554";
            }
        }
        
        adminSelectorItems[i].onclick = function() {
            this.dataset.selected = "true";
            this.style.color = "#030303";
            this.style.backgroundColor = "#ffffff";
            for (var j = 0; j < adminSelectorItems.length; j++) {
                if (j != this.getAttribute("data-index")) {
                    adminSelectorItems[j].dataset.selected = "false";
                    adminSelectorItems[j].style.color = "#ffffff";
                    adminSelectorItems[j].style.backgroundColor = "#FA9554";
                }
            }
            if (this.id == "selector-user") {
                adminUser.style.display = "block";
                adminProduct.style.display = "none";
                adminProductOrder.style.display = "none";
            }
            if (this.id == "selector-product") {
                adminProduct.style.display = "block";
                adminUser.style.display = "none";
                adminProductOrder.style.display = "none";
            }
            if (this.id == "selector-product-order") {
                adminProductOrder.style.display = "block";
                adminProduct.style.display = "none";
                adminUser.style.display = "none";
            }
        };
    }
} catch (e) {
    console.log(e);  
}


