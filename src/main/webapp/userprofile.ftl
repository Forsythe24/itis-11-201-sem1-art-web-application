<html lang="en">
<#include "base.ftl">

<#macro title>User Profile</#macro>
<#macro header>YOUR PROFILE</#macro>
<#macro content>
    Username: ${user.username}
    <br>
    <br>
    Gender: ${user.gender}
    <br>
    <br>
    Contact: ${user.email}
    <br>
    <br>
    Date of birth: ${user.birthDate}
    <br>
    <br>
    <a href = "/editprofile">EDIT PROFILE</a>
    <br>
    <br>
    <a href = "/logout">LOG OUT</a>
</#macro>
</html>