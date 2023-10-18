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
                                <form action="authinfo" method="post">
                                    <div class="form-outline form-white mb-4">
                                        <input type="login" id="typeLoginX" class="form-control form-control-lg" name="login"/>
                                        <label class="form-label" for="typeLoginX">Login</label>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <input type="password" id="typePasswordX" class="form-control form-control-lg" name="password"/>
                                        <label class="form-label" for="typePasswordX">Password</label>
                                    </div>
                                    <br>

                                    <button class="btn btn-outline-light btn-lg px-5" type="submit">Finish</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#macro>
</html>