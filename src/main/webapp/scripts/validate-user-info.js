function validateName(strName) {
    const reg = /[\-. ]*[a-zA-Z]+[a-zA-Z\-. ]*/
    let warning = document.getElementById('name-warning')
    if (reg.test(strName) === false) {
        warning.style.visibility = 'visible'
    } else {
        warning.style.visibility = 'hidden'
    }
}


function validateAge(dateString) {
    var today = new Date();
    var birthDate = new Date(dateString);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    let warning = document.getElementById('age-warning');
    if (age < 10) {
        warning.style.visibility = 'visible'
    } else {
        warning.style.visibility = 'hidden'
    }
}

function validateAll() {
    return document.getElementById('name-warning').style.visibility === 'hidden' &&
        document.getElementById('age-warning').style.visibility === 'hidden'
}