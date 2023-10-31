<html lang="en">
<#include "base.ftl">

<body>
    <#macro title>make a publication</#macro>
    <div class="container-fluid" style="background-color: #954535; height: 120%">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="card" style="margin-top: 2.5rem; background-color: #EADDCA">
                    <div class="header">
                        <h2>The world awaits your masterpiece...</h2>
                    </div>
                    <div class="publication-form">
                        <form class="row clearfix justify-content-center" action="makepublication"
                            method="post" enctype="multipart/form-data">

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="labels">Title</label>
                                    <input type="text" minlength="1" maxlength="40" class="form-control" placeholder="The Great Gatsby" name="title" id="title">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <label class="labels">Genre</label>
                                <select name="genre" class="form-select" id="select-genre" onfocus='this.size=5;' onblur='this.size=1;' onchange='this.size=1; this.blur();' value="Adventure Fiction">
                                </select>
                            </div>
                            <div class="col-12">
                                <div class="form-group">
                                    <textarea minlength="200" rows="4" class="form-control" style="height: 400px; margin-bottom: 1.5rem" placeholder="It all starts with one sentence..." name="text" id="text"></textarea>
                                </div>
                                <div class="col-md-12"><label class="labels">Let's decide on the theme!</label><input type="file" class="form-control" name="file" id="uploader"></div>
                                <div class="col-12"><label class="labels">Write a brief description of the story!</label>
                                    <div class="form-group">
                                        <textarea minlength="10" maxlength="300" rows="4" class="form-control" name="description" style="height: 100px;" id="description" placeholder="Brevity is the soul of wit."></textarea>
                                    </div>
                                </div>
                                <input type="date" class="form-control" name="birth_date" id="birth-date" value="1970-01-01" style="visibility: hidden;">
                            </div>
                            <div class="col align-self-end">
                                <button class="btn btn-outline-dark btn-lg px-5 text-uppercase" style="margin-bottom: 1.5rem; " type="submit">
                                    print
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/scripts/create-genre-option-list-based-on-age.js"></script>
    <script type="text/javascript">
        createOptions($("#birth-date").val())
    </script>
</body>
</html>