<html lang="en">
<#include "base.ftl">
<#include "/resources/css/styles.css">
<body>
<#macro title>user profile</#macro>
<div class="container-fluid" style="background-color: #F5DEB3;">
        <div class="container mt-5" style="height: 100%";>
                <div class="row">
                        <div class="col-md-3 border-right">
                                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" height="150px" src="${image}"><span class="font-weight-bold">${user.username}</span><span class="text-black-50">${user.email}</span><span> </span></div>
                        </div>
                        <div class="col-md-8 border-right">
                                        <div class="p-3 py-5">
                                                <div class="d-flex justify-content-center align-items-center mb-3">
                                                        <h4 class="text-right text-uppercase">Your profile</h4>
                                                </div>
                                                <div class="card border-2" style="border-radius: 1rem; background-color: #e6be8a; border-color: black" >
                                                        <div class="card-body p-5 text-start">
                                                                <div class="mb-md-5 mt-md-4 pb-5">
                                                                        <div class="col-md-12"><label class="labels"><span class="text-black-50">Pen name:</span> ${user.username}</label></div>
                                                                        <div class="col-md-12"><label class="labels"><span class="text-black-50">Email:</span> ${user.email}</label></div>
                                                                        <div class="col-md-12"><label class="labels"><span class="text-black-50">Date of birth:</span> ${user.birthDate}</label></div>
                                                                        <div class="col-md-12"><label class="labels"><span class="text-black-50">Favorite genre of Literature:</span> ${user.genre}</label></div>
                                                                        <div class="col-md-12"><label class="labels"><span class="text-black-50">Gender:</span> ${user.gender}</label></div>
                                                                </div>
                                                        </div>
                                                </div>
                                        </div>
                                        <br>
                                        <a href="/editprofile" class="mt-5 text-center"><button class="btn btn-outline-dark btn-lg px-5 text-uppercase" type="button" style="background-color: #D2B48C; color: black; margin-left: 4.5rem">Edit</button></a>
                                        <a href="/logout" class="mt-5 text-center"><button class="btn btn-outline-dark btn-lg px-5 text-uppercase" type="button" style="background-color: #D2B48C; color: black; margin-left: 1.5rem">Log Out</button></a>
                        </div>
                </div>
        </div>
</div>
</body>
</html>