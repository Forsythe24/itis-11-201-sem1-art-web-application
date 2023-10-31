<html lang="en">
<#include "/resources/css/publication-styles.css">
<#include "base.ftl">
<#macro title>${publication.title}</#macro>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Librarea</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

</head>

<body>
    <div id="main-content" class="blog-page" style="margin-top: 5.0rem;">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-lg-9 col-md-12 left-box">
                    <div class="card single_post">
                        <div class="body">
                            <div class="img-post">
                                <img class="d-block img-fluid" src="${publication.image}" alt="First slide">
                            </div>
                            <h3><a href="blog-details.html">${publication.title}</a></h3>
                            <p>${publication.text}</p>
                        </div>
                    </div>
                    <div class="card">
                        <div class="header">
                            <h3>Critique</h3>
                        </div>
                        <div class="body">
                            <ul class="comment-reply list-unstyled" id="comment-container">
                            </ul>
                        </div>
                    </div>
                    <#if user??>
                        <div class="card">
                            <div class="header">
                                <h3>You can write your critique here</h3>
                            </div>
                            <div class="body">
                                <div class="comment-form">
                                    <div class="col-sm-12">
                                        <form action="publication" method="post">
                                            <div class="form-group">
                                                <textarea rows="4" class="form-control no-resize" placeholder="Please type what you want..." name="text"></textarea>
                                            </div>
                                            <input type="text" id="text" class="form-control" name="publ_id" value="${publication.id}" style="visibility: hidden;">
                                            <button type="submit" id="comment-button" class="btn btn-block btn-primary">PRINT</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <#else>
                    </#if>
                </div>
                <div class="col-lg-3 col-md-12 right-box">
                    <div class="card">
                        <div class="body widget popular-post">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                        <h3>Author</h3>
                                        <img class="rounded-circle mt-5" width="200px" height="200px" src="${author_image}">
                                        <span class="font-weight-bold">${author_name}</span>
                                        <span class="text-black-50">${author_email}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="body widget popular-post">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                        <h3>Story info</h3>
                                        <span class="font-weight-bold">Published on: <span class="text-black-50"><i>${publication.date}</i></span></span>
                                        <span class="font-weight-bold">Genre: <span class="text-black-50"><i></id>${publication.genre}</i></span></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <#if user??>
                        <button class="btn btn-outline-dark btn-lg px-5 text-uppercase" style="margin-bottom: 1.5rem; margin-left: 1.5rem" type="button" id="btn-add-to-reading-list">add to reading list</button>

                        <#if user.id == author_id>
                            <a href="/publications"><button class="btn btn-outline-dark btn-lg px-5 text-uppercase" style="margin-bottom: 1.5rem; margin-left: 1.5rem; color: red; border-color: red" type="button" id="btn-delete">delete publication</button></a>
                            <a href="/editpublication"><button class="btn btn-outline-dark btn-lg px-5 text-uppercase" style="margin-bottom: 1.5rem; margin-left: 6.0rem; color: blue; border-color: blue" type="button" id="btn-edit">edit</button></a>
                        </#if>
                        <#else>
                    </#if>
                </div>
            </div>

        </div>
    </div>
    <script src="/scripts/parse-json-string-into-comments.js"></script>
    <script>
        $.get("/ajax/comments?publ_id=" + ${publication.id}, function (response) {
            parseJsonStringIntoComments(response)
        })
    </script>
    <#if user??>
        <script>
            $.get("/ajax/check?publ_id=" + ${publication.id}, function(response) {
                if (response === "yes") {
                    $("#btn-add-to-reading-list").prop('disabled', true)
                }
            })
        </script>

        <script>
            $("#btn-add-to-reading-list").click(function() {
                $.get("/ajax/addtoreadinglist?publ_id=" + ${publication.id})
                $("#btn-add-to-reading-list").prop('disabled', true)
            })

        </script>

        <script>
            $("#btn-delete").click(function() {
                $.ajax({
                    url: "/ajax/deletepublication?publ_id=" + ${publication.id},
                    type: 'DELETE',
                });
            })
        </script>

        <#else>
    </#if>
<#--    <script>-->
<#--        $('#comment-button').click(function() {-->
<#--            $.ajax({-->
<#--                type: 'POST',-->
<#--                data: {-->
<#--                    'publ_id' : ${publication.id}-->
<#--                    'text' : $("#text").val()-->
<#--                },-->
<#--                success: function(response) {-->
<#--                    alert(response)-->
<#--                },-->
<#--                error: function(){-->
<#--                    alert('hi')-->
<#--                },-->
<#--                url: '/ajax/comments',-->
<#--                cache:false-->
<#--            });-->
<#--        });-->
<#--    </script>-->


</body>
</html>