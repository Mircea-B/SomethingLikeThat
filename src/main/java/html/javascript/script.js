
var add = function(number1, number2){
    return number1+number2;
}
$(document).ready(function () {
var tabel = $(".content_class");
tabel.click(function () {
    alert("You clicked a paragraph!");
});
});

$(document).ready(function(){
    var meniu_lateral=$("#sideMenu")
    function validate() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        if (username == "mircea" && password == "parola") {
            alert("Felicitari, esti logat");
            window.location = "index.html";} // cica acesta este codul de redirect
        else {
                alert("mai incearca odata :)");
                window.location = "login.html";
            }
        }
        return false;
    }





})

function validate(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if(username == "mircea" && password == "parola"){
        alert("Felicitari, esti logat");
        window.location="index.html"; // cica acesta este codul de redirect
        else {
alert("mai incearca odata :)");
window.location="login.html";
    }     
}
    return false;
}

