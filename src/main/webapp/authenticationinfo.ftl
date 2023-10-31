<html lang="en">
<#include "signupbase.ftl">

    <#macro content>
        <form action="userinfo" method="get">
            <button class="btn btn-lg px-5 text-uppercase" type="submit" style="background-color: #834333; margin: 20px; color: white; border-color: white">Back</button>
        </form>

        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card text-white" style="border-radius: 1rem; background-color: #834333; border-color: white;" >
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">

                                <h2 class="fw-bold mb-2 text-uppercase">Finish him!..</h2>
                                <p class="text-white-50 mb-5">Now you need to come up with some <strong>strong</strong> login and password!</p>
                                <form action="authinfo" method="post" id="form">
                                    <p id="taken-login-warning" style="visibility: hidden; color: red; font-size: 15px;">
                                            This login is already taken
                                    </p>
                                    <p id="login-warning" style="visibility: visible; color: red; font-size: 15px;">
                                            Only letters of the Latin alphabet (at least 1) and digits
                                    </p>
                                    <div class="form-outline form-white mb-4">
                                        <input type="login" id="login" class="form-control form-control-lg" name="login"/>
                                        <label class="form-label" for="typeLoginX">Login</label>
                                    </div>

                                    <span id="password-warning" style="visibility: visible; color: red; font-size: 15px;">
                                            Minimum length: 8 (no spaces). Only the Latin alphabet letters and special characters '#', '%', '*', '&'
                                    </span>
                                    <div class="form-outline form-white mb-4">
                                        <input type="password" id="password" class="form-control form-control-lg" name="password"/>
                                        <label class="form-label" for="typePasswordX">Password</label>
                                    </div>
                                    <br>

                                    <button class="btn btn-outline-light btn-lg px-5" type="submit" disabled id="button-finish">Finish</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#macro>
    <script src="/scripts/validate-auth-info.js"></script>
    <script>
        $("#login").change(function () {
            let login = $("#login").val()
            validateLogin(login)
            $.get("/ajax/checklogin?login=" + login, function (response) {
                if (response === 'taken') {
                    showTakenLoginWarning()
                } else {
                   hideTakenLoginWarning()
                }
            })
        })
    </script>
    <script>
        $("#password").change(function () {
            validatePassword($("#password").val())
        })
    </script>
    <script>
        $("#form").change(function() {
            if (validateAll()) {
                $("#button-finish").prop("disabled", false)
            } else {
                $("#button-finish").prop("disabled", true)
            }
        })
    </script>

</html>