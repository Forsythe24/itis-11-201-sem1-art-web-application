<html lang="en">
<#include "base.ftl">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
</head>
<#macro title>Reading List</#macro>

<body>
<div class="container" style="margin-top: 10.5rem">
</div>
<div class="list-group" id="list" style="margin-top: 5.5rem">
    <a class= "list-group-item list-group-item-action flex-column" href="/homepage">
        <img src="https://images1.resources.foxtel.com.au/store2/mount1/16/3/85td8.jpg" height="180px" width = "280px">
        <span class="mb-1" style="font-size: 25px;">— Be mindful when it comes to your words. A string of some that <span class="text-muted text-end" style="margin-left: 1.0rem"><i>Rachel Wolchin</i></span></span>
    </a>
</div>

<script src="scripts/parse-json-into-reading-list.js"></script>
<script>
    $.get("/ajax/getreadinglist", function(response) {
        parseJsonIntoReadingList(response)
    })
</script>


</body>


</html>