## Grails 6 with micronaut data

A grails app using a Grails controller with a micronaut `@MappedEntity` and `@JdbcRepository` defined in src.

This branch assumes an Oracle database is available as configured in application.yml block `datasources.oracle`

Bootstrap will create the table, sequence and add a couple of rows if the table doesn't exist.

Currently, the save action does persist the entity but fails when returning back to the controller with:

`class g6micronautdata.Person cannot be cast to class g6micronautdata.Person (g6micronautdata.Person is in unnamed module of loader 'app'; g6micronautdata.Person is in unnamed module of loader org.springframework.boot.devtools.restart.classloader.RestartClassLoader @1c90f703).`