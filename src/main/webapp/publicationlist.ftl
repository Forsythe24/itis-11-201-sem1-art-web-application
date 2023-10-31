<html lang="en">
<#include "base.ftl">
<#macro title>publications</#macro>

<body>
    <div class="container" style="margin-top: 6.5rem">
        <div class="row">
            <div class="col-sm-8">
                <label class="labels">Search for a story</label>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Brave New World" aria-label="Brave New World" id="title">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="search">Search</button>
                    </div>
                </div>
            </div>

            <div class="col-sm-4">
                <label class="labels">Genre filter</label>
                <select name="genre" class="form-select" id="select-genre" onfocus='this.size=5;' onblur='this.size=1;' onchange='this.size=1; this.blur();' >

                </select>
            </div>
        </div>

        <h2 class="my-4" id="current-filter">Recent Publications</h2>
        <div class="row" id="row-list">
<#--            <div class="col-md-4 mb-4">-->
<#--                <div class="card">-->
<#--                    <img class="card-img-top" style="height: 250px; width: 415px" src="https://via.placeholder.com/300x200" alt="Card image cap">-->
<#--                    <div class="card-body">-->
<#--                        <h5 class="card-title">Blog post 1</h5>-->
<#--                        <p class="card-text" style="height: 130px">This is a brief description of blog post 1.</p>-->
<#--                        <a href="#" id="publ" class="btn btn-primary">Read More &rarr;</a>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </div>-->
        </div>
        <input type="date" class="form-control" name="birth_date" id="birth-date" value="1970-01-01" style="visibility: hidden;">
    </div>

    <script src="/scripts/create-genre-option-list-based-on-age.js"></script>
    <script>
        $("#select-genre").change(function() {
            let genre = $("#select-genre").val()
            let title = $("#title").val().replace("&", "%26")

            $("#current-filter").text(genre)

            $.get("/ajax/getpublications?genre=" + genre.replace("&", "%26") + "&title=" + title, function(response) {
                convertJsonStringIntoPublications(response)
            })
        })
    </script>

    <#if user??>
        <script type="text/javascript">
            createOptionsForAuthorizedUser($("#birth-date").val())
        </script>
        <#else>
            <script type="text/javascript">
                createOptionsWithRecentPublications($("#birth-date").val())
            </script>
    </#if>


    <script src="/scripts/convert-json-string-into-publications.js"></script>
    <script>
        $.get("/ajax/getpublications", function (response) {
                convertJsonStringIntoPublications(response)
        })

    </script>

    <script>
        $("#search").click(function() {

            let genre = $("#select-genre").val().replace("&", "%26")
            let title = $("#title").val().replace("&", "%26")

            $.get("/ajax/getpublications?title=" + title + "&genre=" + genre, function(response) {
                convertJsonStringIntoPublications(response)
            })
        })
    </script>

</body>