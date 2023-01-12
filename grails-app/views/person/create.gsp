<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Create person</title>
</head>

<body>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        </ul>
    </div>
    <g:form action="save">
        <fieldset class="form">
            <div class='fieldcontain required'>
                <label for='forename'>Forename<span class='required-indicator'>*</span></label>
                <input type="text" name="forename" value="" required="" maxlength="50" id="forename" />
            </div>
            <div class="fieldcontain required">
                <label for="surname">Surname<span class="required-indicator">*</span></label>
                <input type="text" name="surname" value="" required="" maxlength="50" id="surname" />
            </div>
            <div class="fieldcontain required">
                <label for="dob">Date of birth<span class="required-indicator">*</span></label>
                <g:datePicker name="dob" precision="day" />
            </div>
        </fieldset>
        <fieldset class="buttons">
            <input type="submit" name="create" class="save" value="Create" id="create" />
        </fieldset>
    </g:form>
</body>
</html>