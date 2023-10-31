function validateLogin(strLogin) {
    const reg = /[A-Za-z0-9]+/
    let warning = document.getElementById('login-warning')
    if (reg.test(strLogin) === false) {
        warning.style.visibility = 'visible'
    } else {
        warning.style.visibility = 'hidden'
    }
}

function validatePassword(strPassword) {
    const reg = /[A-Za-z0-9#%*&]{8,}/
    let warning = document.getElementById('password-warning')
    if (reg.test(strPassword) === false) {
        warning.style.visibility = 'visible'
    } else {
        warning.style.visibility = 'hidden'
    }
}

function showTakenLoginWarning() {
    let warning = document.getElementById('taken-login-warning')
    warning.style.visibility = 'visible'
}

function hideTakenLoginWarning() {
    let warning = document.getElementById('taken-login-warning')
    warning.style.visibility = 'hidden'
}

function validateAll() {
    return document.getElementById('login-warning').style.visibility === 'hidden' &&
        document.getElementById('password-warning').style.visibility === 'hidden' &&
        document.getElementById('taken-login-warning').style.visibility === 'hidden'
}