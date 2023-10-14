<#--<html lang="en">-->
<#--<#include "base.ftl">-->

<#--<#macro title>SIGNING IN</#macro>-->
<#--<#macro header>SIGNING IN</#macro>-->
<#--<#macro content>-->
<#--    <br>-->
<#--    <br>-->
<#--    <form action="signin" method="post">-->
<#--        Login:-->
<#--        <input type="text" name="login"/>-->
<#--        <br>-->
<#--        Password:-->
<#--        <input type="password" name="password"/>-->
<#--        <br>-->
<#--        <br>-->
<#--        <input type="submit" value="SIGN IN"/>-->
<#--        <br>-->
<#--        <br>-->
<#--        <div>-->
<#--            <input type="checkbox" id="remember-me" name="remember_me"/>-->
<#--            <label for="remember-me">Remember me</label>-->
<#--        </div>-->
<#--    </form>-->
<#--    No Librarea account?<a href="/userinfo"> Create one!</a>-->

<#--</#macro>-->
<#--</html>-->

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Librarea</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        input.customCheckbox {
            width: 18px;
            height: 18px;
        }
    </style>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</head>
<body>
<div class = "container-fluid" style="background-image: url('https://images.wallpaperscraft.com/image/single/pen_pages_vintage_130832_1920x1080.jpg'); background-repeat: no-repeat">
    <form action="homepage" method="get">
        <button class="btn btn-lg px-5" type="submit" style="background-color: #5C4033; margin: 20px; color: white">HOME</button>
    </form>

    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card text-white" style="border-radius: 1rem; background-color: #5C4033;" >
                    <div class="card-body p-5 text-center">

                        <div class="mb-md-5 mt-md-4 pb-5">

                            <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                            <p class="text-white-50 mb-5">Please enter your login and password!</p>
                            <form action="signin" method="post">
                                <div class="form-outline form-white mb-4">
                                    <input type="login" id="typeLoginX" class="form-control form-control-lg" name="login"/>
                                    <label class="form-label" for="typeLoginX">Login</label>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <input type="password" id="typePasswordX" class="form-control form-control-lg" name="password"/>
                                    <label class="form-label" for="typePasswordX">Password</label>
                                </div>

                                <div>
                                    <input type="checkbox" id="remember-me" name="remember_me" class="customCheckbox"/>
                                    <label for="remember-me" style="font-size: 115%">Remember me</label>
                                </div>
                                    <br>

                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
                            </form>

                        </div>

                        <div>
                            <p class="mb-0">No LibrArea account? <a href="userinfo" class="text-white-50 fw-bold">Create one!</a>
                            </p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>