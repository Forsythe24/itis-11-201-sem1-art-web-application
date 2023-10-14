<html lang="en">
<#include "base.ftl">

<#macro title>Home page</#macro>
<#macro header>HOME PAGE</#macro>
<body>
    <#macro navbar>
        <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarRightAlign"
                aria-controls="navbarRightAlign"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarRightAlign">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/userinfo">Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/signin">Sign In</a>
                </li>
            </ul>
        </div>
        </div>
    </#macro>
        <#macro content>
<#--            <div class="row custom-row justify-content-center align-items-center">-->
                <div class="d-flex justify-content-center">
                    Welcome to Librarea!
                </div>
                    <br>
                    <br>
                <div class="d-flex justify-content-center">
                    Create an account
                </div>
                <br>
                <br>
                <div class="d-flex justify-content-center">
                    <a href="/userinfo">SIGN UP</a>
                </div>
                    <br>
                    <br>
                <div class="d-flex justify-content-center">
                    Already got an account on Librarea?
                </div>
                    <br>
                    <br>
                <div class="d-flex justify-content-center">
                    <a href="/signin">SIGN IN</a>
                </div>
        </#macro>
</body>
</html>