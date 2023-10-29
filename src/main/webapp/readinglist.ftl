<html lang="en">
<#include "base.ftl">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
</head>
<#macro title>quotes</#macro>

<body>
<div class="container" style="margin-top: 10.5rem">
    <div class="row justify-content-center align-content-center">
        <button type="button" id="one-quote" class="col-4 btn btn-ultra-voilet btn-lg">Get a life-changing quote!</button>
    </div>
    <br>
    <div class="row justify-content-center align-content-center">
        <button type="button" id="all-quotes" class="col-2 btn btn-ultra-voilet btn-lg">All quotes</button>
    </div>

</div>
<div class="list-group" id="list" style="margin-top: 5.5rem">
    <a class= "list-group-item list-group-item-action flex-column">
        <p class="mb-1" style="font-size: 25px; font-family: 'Times New Roman',serif">— Be mindful when it comes to your words. A string of some that don't mean much to you, may stick with someone else for a lifetime.</p>
        <p class="text-muted text-end"><i>Rachel Wolchin</i></p>
    </a>
</div>

<script src="/scripts/turn-json-into-quotes.js"></script>
<script>
    $("#all-quotes").click(function(){
        $.get("/ajax/getquotes?number=all", function (response) {
            turnJsonIntoQuotes(response)
        })
    })
</script>

<script src="/scripts/turn-json-into-quotes.js"></script>
<script>
    $("#one-quote").click(function(){
        $.get("/ajax/getquotes?number=one", function (response) {
            turnJsonIntoQuotes(response)
        })
    })
</script>

<script>

</script>

</body>


</html>