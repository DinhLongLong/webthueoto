/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
try {
    var infoUserShow = document.getElementById("info-user-show");
    var infoUserChange = document.getElementById("info-user-change");
    var btnChange = document.querySelector('.profile__info-btn .change-btn');
    var btnCancel = document.querySelector('.profile__info-btn .cancel-btn');

    function openInfoUserChange(name, phone, email, address) {
        infoUserShow.style.display = "none";
        infoUserChange.style.display = "flex";
        document.getElementById("name").value = name;
        document.getElementById("phone").value = phone;
        document.getElementById("email").value = email;
        document.getElementById("address").value = address;
    };
    btnCancel.onclick = function() {
        infoUserChange.style.display = "none";
        infoUserShow.style.display = "block";
    };
} catch (e) {
    console.log(e);
}

