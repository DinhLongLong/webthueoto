/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

try {
    function addProductRecreate() {
        document.getElementById("name").value = "";
        document.getElementById("img").value = "";
        document.getElementById("licensePlate").value = "";
        document.getElementById("price").value = "";
        document.getElementById("description").value = "";
    };
    
    function reAddProduct() {
        document.querySelector('.add-product__success').style.display = "none";
        document.querySelector('.add-product__container').style.display = "block";
        document.getElementById("name").value = "";
        document.getElementById("img").value = "";
        document.getElementById("licensePlate").value = "";
        document.getElementById("price").value = "";
        document.getElementById("description").value = "";
    }
    
} catch (e) {
    console.log(e);
}




