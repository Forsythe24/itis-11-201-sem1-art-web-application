<html lang="en">
<#include "base.ftl">

<#macro title>SIGNING IN</#macro>
<#macro header>SIGNING IN</#macro>
<#macro content>
    <br>
    <br>
    <form action="signin" method="post">
        Login:
        <input type="text" name="login"/>
        <br>
        Password:
        <input type="password" name="password"/>
        <br>
        <br>
        <input type="submit" value="SIGN IN"/>
    </form>
    No Librarea account?<a href="/userinfo"> Create one!</a>

</#macro>
</html>