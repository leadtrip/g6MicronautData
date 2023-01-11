<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>People</title>
</head>

<body>
    <div class="nav" role="navigation">
        <ul>
            <li><g:link class="create" action="create">Create</g:link></li>
        </ul>
    </div>
    <table class="table table-bordered">
        <tr>
            <th>Name</th>
            <th>DOB</th>
        </tr>
        <g:each in="${people}" var="person">
            <tr>
                <td><g:link action="show" id="${person.id}">${person.forename} ${person.surname}</g:link></td>
                <td>${person.dob}</td>
            </tr>
        </g:each>
    </table>
</body>
</html>