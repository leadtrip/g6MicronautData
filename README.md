## Grails 6 with micronaut data

A grails app using a Grails controller with a micronaut `@MappedEntity` and `@JdbcRepository` defined in src.

This branch uses an H2 in memory database that is configured the same for both Grails and Micronaut.

Bootstrap will create the table, sequence and add a couple of rows using the default Grails dataSource with groovy Sql.

Currently, the save action does persist the entity but fails when returning back to the controller with:

`Caused by: java.lang.ClassCastException: class g6micronautdata.Person cannot be cast to class g6micronautdata.Person (g6micronautdata.Person is in unnamed module of loader 'app'; g6micronautdata.Person is in unnamed module of loader org.springframework.boot.devtools.restart.classloader.RestartClassLoader @1b3b96d0)`