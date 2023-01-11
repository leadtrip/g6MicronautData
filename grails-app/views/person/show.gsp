<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'person.label', default: 'person')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            <li><g:link class="create" action="create">Create</g:link></li>
        </ul>
    </div>
<div id="content" role="main">
    <g:if test="${!person.id}">
        <div class="message" role="status">No person exists with ID ${params.id}</div>
    </g:if>
    <g:else>
        <div class="container">
            <section class="row">
                <div id="show-person" class="col-12 content scaffold-show" role="main">
                    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
                    %{--<f:display bean="person" /> does not work--}%
                    <ol class="property-list">
                        <li class="fieldcontain">
                            <span class="property-label">Name</span>
                            <span class="property-value">${person.forename} ${person.surname}</span>
                        </li>

                        <li class="fieldcontain">
                            <span class="property-label">Date of birth</span>
                            <span class="property-value">${person.dob}</span>
                        </li>
                    </ol>
                </div>
            </section>
        </div>
    </g:else>
</div>
</body>
</html>