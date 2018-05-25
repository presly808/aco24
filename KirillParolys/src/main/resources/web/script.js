//hide contacts content but not button
document.getElementById("inner-contacts").style.visibility = "hidden";

//hide login content but not button
document.getElementById("inner-login").style.visibility = "hidden";

//hide register content but not button
document.getElementById("inner-register").style.visibility = "hidden";


function showContacts() {
    document.getElementById("inner-contacts").style.visibility = "visible";

    //hide login content but not button
    document.getElementById("inner-login").style.visibility = "hidden";

    //hide register content but not button
    document.getElementById("inner-register").style.visibility = "hidden";
}

function showLogin() {
    document.getElementById("inner-login").style.visibility = "visible";

    //hide contacts content but not button
    document.getElementById("inner-contacts").style.visibility = "hidden";

    //hide register content but not button
    document.getElementById("inner-register").style.visibility = "hidden";
}

function showRegister() {
    document.getElementById("inner-register").style.visibility = "visible";

    //hide contacts content but not button
    document.getElementById("inner-contacts").style.visibility = "hidden";

    //hide login content but not button
    document.getElementById("inner-login").style.visibility = "hidden";
}

function sendRegister() {
    var nameReg = document.getElementById("nameReg").value;
    var passReg = document.getElementById("passReg").value;

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("resp").innerHTML = this.responseText;
        }
    };

    xhttp.open("POST", "/register", true);
    xhttp.send(JSON.stringify({name: nameReg, pass: passReg}));
}

var regButton = document.getElementById("register-button");
regButton.addEventListener("click", sendRegister);

function sendLogin() {
    var loginName = document.getElementById("nameLog").value;
    var loginPass = document.getElementById("passLog").value;

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("resp").innerHTML = this.responseText;
        }
    };

    xhttp.open("POST", "/login", true);
    xhttp.send(JSON.stringify({name: loginName, pass: loginPass}));
}

var loginButton = document.getElementById("login-button");
loginButton.addEventListener("click", sendLogin);

function getAll() {
    var accessKey = document.getElementById("accessKey").value;
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("resp").innerHTML = this.responseText;
        }
    };

    xhttp.open("GET", "/contact/all", true);
    xhttp.send(JSON.stringify({accessToken: accessKey}));
}

var allcontactsButton = document.getElementById("all-contacts-button");
allcontactsButton.addEventListener("click", getAll);