<html lang="en">
<#include "signupbase.ftl">

<#macro content>
    Now you need to come up with your login and password
    <br>
    <br>
    <form action="authinfo" method="post">
        Login:
        <input type="text" name="login"/>
        <br>
        Password:
        <input type="password" name="password"/>
        <br>
        <br>
        <input type="submit" value="FINISH">
    </form>
</#macro>
</html>