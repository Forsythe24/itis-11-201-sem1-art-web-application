<html lang="en">
<#include "signupbase.ftl">

<#include "/resources/css/styles.css">
    <head>
        <meta charset="UTF-8" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <#macro content>
        <form action="homepage" method="get">
            <button class="btn btn-outline-dark btn-lg px-5" type="submit" style="background-color: #A95C68; margin: 20px;">HOME</button>
        </form>
        <div class="container" style="height: 100%";>
            <div class="row">
                    <div class="col-md-3 border-right">
                        <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                            <img class="rounded-circle mt-5" width="150px" height="150px" id="image-preview" src="https://writersandfreeexpression.files.wordpress.com/2021/06/erich.jpg?w=1024">
                            <span class="font-weight-bold">
                                Image Preview
                            </span>
                        </div>
                    </div>

                    <div class="col-md-7 border-right">
                        <form action="userinfo" method="post" enctype="multipart/form-data">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h4 class="text-right">Filling your profile</h4>
                                </div>
                                <div class="row mt-6">

                                    <div class="col-md-12"><label class="labels">Name you're writing under</label><input type="text" class="form-control" name="username" placeholder="pen name"></div>
                                    <div class="col-md-12"><label class="labels">Contact info</label><input type="email" class="form-control" name="email" placeholder="email"></div>
                                    <div class="col-md-12"><label class="labels">Date of birth</label><input type="date" class="form-control" name="birth_date" id="birth-date" value="1970-01-01" ></div>

                                    <div class="col-md-12"><label class="labels">Favorite genre of literature (the genre list is based on your age)</label>
                                        <select name="genre" class="form-select" id="select-genre" onfocus='this.size=5;' onblur='this.size=1;' onchange='this.size=1; this.blur();' value="History">

                                        </select>
                                    </div>
                                    <div class="col-md-12"><label class="labels">Gender</label>
                                        <fieldset>
                                            <div>
                                                <input type="radio" class="labels" name="gender" value="male"/>
                                                <label for="male">Male</label>
                                            </div>

                                            <div>
                                                <input type="radio" class="labels" name="gender" value="female"/>
                                                <label for="female">Female</label>
                                            </div>
                                        </fieldset>
                                    </div>
                                    <div class="col-md-12"><label class="labels">Pick your profile image</label><input type="file" class="form-control" name="file" id="uploader" onchange="updatePreview(this, 'image-preview')"></div>
                                </div>
                                <div class="mt-5 text-center"><button class="btn btn-outline-dark btn-lg text-uppercase px-5" type="submit" style="background-color: #A95C68">next</button></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </#macro>
    <script src="/scripts/create-genre-option-list-based-on-age.js"></script>
    <script>
        $("#birth-date").change(function(){
            $.get("/ajax/setbirthdate?birth_date=" + $("#birth-date").val(),
                createOptions())
        });
    </script>

    <script type="text/javascript">
        function updatePreview(input, target) {
            let file = input.files[0];
            let reader = new FileReader();

            reader.readAsDataURL(file);
            reader.onload = function () {
                let img = document.getElementById(target);
                img.src = reader.result;
            }
        }
    </script>
</html>