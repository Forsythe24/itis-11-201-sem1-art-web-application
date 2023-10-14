<html lang="en">
<#include "base.ftl">


<#macro title>EDITING PROFILE</#macro>
<#macro header>EDITING YOUR PROFILE</#macro>
<body>
    <#macro navbar></#macro>
    <#macro content>
        <br>
        <br>
        <form action="editprofile" method="post">
            Username:
            <input type="text" name="username" value=${user.username} />

            <br>
            <br>

            Contact info:
            <input type="email" name="email" value=${user.email} />
            <br>
            <br>
            <fieldset>
                <legend><strong>What's your gender?</strong></legend>
                <div>
                    <input type="radio" id="male" name="gender" value="male"
                            <#if user.gender == "male">
                                checked
                            </#if>
                    />
                    <label for="male">Male</label>
                </div>

                <div>
                    <input type="radio" id="female" name="gender" value="female"
                            <#if user.gender == "female">
                                checked
                            </#if>
                    />
                    <label for="female">Female</label>
                </div>
            </fieldset>

            <br>
            <br>

            <strong>Your date of birth:</strong>
            <input type="date" name="birth_date" value=${dateOfBirth} />

            <br>
            <br>

            <input type="submit" value="SAVE">
        </form>
    </#macro>
</body>
</html>