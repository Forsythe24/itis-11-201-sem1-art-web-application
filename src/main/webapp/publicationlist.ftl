<html lang="en">
<#include "base.ftl">
<#macro title>publications</#macro>

<body>
    <div class="container">
        <h2 class="my-4">Recent posts</h2>
        <div class="row" id="row-list">
<#--            <div class="col-md-4 mb-4">-->
<#--                <div class="card">-->
<#--                    <img class="card-img-top" src="https://via.placeholder.com/300x200" alt="Card image cap">-->
<#--                    <div class="card-body">-->
<#--                        <h5 class="card-title">Blog post 1</h5>-->
<#--                        <p class="card-text">This is a brief description of blog post 1.</p>-->
<#--                        <a href="#" id="publ" class="btn btn-primary">Read More &rarr;</a>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </div>-->
        </div>
    </div>
    <script src="/scripts/parse-json-array-into-publications.js"></script>
    <script>
        $.get("/ajax/getpublications", function (response) {
                parseJsonArrayIntoPublications(response)
        })
    </script>
</body>