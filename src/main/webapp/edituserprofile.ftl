<html lang="en">
<#include "base.ftl">
<#include "/resources/css/styles.css">


<#macro title>EDITING PROFILE</#macro>
<div class="container-fluid" style="background-color: #954535;">
    <div class="container mt-5" style="height: 100%";>
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg"><span class="font-weight-bold">user.username</span><span class="text-black-50">${user.email}</span><span> </span></div>
            </div>
            <div class="col-md-7 border-right">
                <form action="editprofile" method="post">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <div class="row mt-6">
                            <div class="col-md-12"><label class="labels">Name you're writing under</label><input type="text" class="form-control" name="username" placeholder="pen name" style="margin-bottom: 1.5rem" value=${user.username}></div>
                            <div class="col-md-12"><label class="labels">Contact info</label><input type="email" class="form-control" name="email" placeholder="email" style="margin-bottom: 1.5rem" value=${user.email}></div>
                            <div class="col-md-12"><label class="labels">Date of birth</label><input type="date" class="form-control" name="birth_date" style="margin-bottom: 1.5rem" value=${dateOfBirth}></div>
                            <div class="col-md-12"><label class="labels">Gender</label>
                                <fieldset>
                                    <div>
                                        <input type="radio" class="labels" name="gender" value="male"
                                                <#if user.gender == "male">
                                                    checked
                                                </#if>
                                        />
                                        <label for="male">Male</label>
                                    </div>

                                    <div>
                                        <input type="radio" class="labels" name="gender" value="female"
                                                <#if user.gender == "female">
                                                    checked
                                                </#if>
                                        />
                                        <label for="female">Female</label>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                        <div class="mt-5 text-center"><button class="btn btn-outline-dark btn-lg px-5" type="submit" style="background-color: #D2B48C">Save</button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<#--<body>-->
<#--        <br>-->
<#--        <br>-->
<#--        <form action="editprofile" method="post">-->
<#--            Username:-->
<#--            <input type="text" name="username" value=${user.username} />-->

<#--            <br>-->
<#--            <br>-->

<#--            Contact info:-->
<#--            <input type="email" name="email" value=${user.email} />-->
<#--            <br>-->
<#--            <br>-->
<#--            <fieldset>-->
<#--                <legend><strong>What's your gender?</strong></legend>-->
<#--                <div>-->
<#--                    <input type="radio" id="male" name="gender" value="male"-->
<#--                            <#if user.gender == "male">-->
<#--                                checked-->
<#--                            </#if>-->
<#--                    />-->
<#--                    <label for="male">Male</label>-->
<#--                </div>-->

<#--                <div>-->
<#--                    <input type="radio" id="female" name="gender" value="female"-->
<#--                            <#if user.gender == "female">-->
<#--                                checked-->
<#--                            </#if>-->
<#--                    />-->
<#--                    <label for="female">Female</label>-->
<#--                </div>-->
<#--            </fieldset>-->

<#--            <br>-->
<#--            <br>-->

<#--            <strong>Your date of birth:</strong>-->
<#--            <input type="date" name="birth_date" value=${dateOfBirth} />-->

<#--            <br>-->
<#--            <br>-->

<#--            <input type="submit" value="SAVE">-->
<#--        </form>-->
</body>
</html>