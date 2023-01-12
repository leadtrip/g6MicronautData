## Grails 6 with micronaut data

A grails app using a Grails controller with a micronaut `@MappedEntity` and `@JdbcRepository` defined in src.

This branch assumes an Oracle database is available as configured in application.yml block `datasources.oracle`

Bootstrap will create the table, sequence and add a couple of rows if the table doesn't exist.