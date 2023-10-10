<html lang="en">
<#include "signupbase.ftl">

<#macro content>
    We in Librarea want to get to know a little better!
    <br>
    <br>
    Please, share a little bit about yourself
    <br>
    <br>
    <form action="userinfo" method="post">
        <strong>What's the name you are writing under?</strong>
        <br>
        <br>
        </strong>Pen name</strong>:
        <input type="text" name="username">
        <br>
        <br>
        <fieldset>
            <legend><strong>What's your gender?</strong></legend>

            <div>
                <input type="radio" id="male" name="gender" value="male" checked />
                <label for="male">Male</label>
            </div>

            <div>
                <input type="radio" id="female" name="gender" value="female" />
                <label for="female">Female</label>
            </div>
        </fieldset>

        <br>

        <strong>Your contact info (optional):</strong>
        <input type="email" name="email"/>

        <br>
        <br>

        <strong>Your date of birth:</strong>
        <input type="date" name="birth_date"/>

        <br>
        <br>

        <input type="submit" value="NEXT">
    </form>
</#macro>
</html>