<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <p>Found ${people.size()} people</p>
    <table class="table table-bordered">
        <tr>
            <th>Name</th>
            <th>DOB</th>
        </tr>
        <g:each in="${people}" var="person">
            <tr>
                <td>${person.forename} ${person.surname}</td>
                <td>${person.dob}</td>
            </tr>
        </g:each>
    </table>
</body>
</html>