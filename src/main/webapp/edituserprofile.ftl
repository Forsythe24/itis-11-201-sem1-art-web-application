<html lang="en">
<#include "base.ftl">
<#include "/resources/css/styles.css">
    <body>
        <#macro title>editing profile</#macro>
        <div class="container-fluid" style="background-color: #954535;">
            <div class="container mt-5" style="height: 100%";>
                <div class="row">
                    <div class="col-md-3 border-right">
                        <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" height="150px" src=${image}><span class="font-weight-bold">${user.username}</span><span class="text-black-50">${user.email}</span><span> </span></div>
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
                                    <div class="col-md-12"><label class="labels">Date of birth</label><input type="date" class="form-control" name="birth_date" style="margin-bottom: 1.5rem" id="birth-date" value=${dateOfBirth}></div>
                                    <div class="col-md-12"><label class="labels">Favorite genre of literature (the genre list is based on your age)</label>
                                        <select name="genre" class="form-select" id="select-genre" onfocus='this.size=5;' onblur='this.size=1;' onchange='this.size=1; this.blur();' style="margin-bottom: 1.5rem" value=${user.genre}>

                                        </select>
                                    </div>
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

        <script src="/scripts/create-genre-option-list-based-on-age.js"></script>
        <script>
            $("#birth-date").change(function(){
                let dateOfBirth= $("#birth-date").val();
                $.get("/ajax/setbirthdate?birth_date=" + dateOfBirth,
                    createOptions())
            });
        </script>
    </body>
</html>