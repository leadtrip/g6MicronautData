## Grails 6 with micronaut data

A grails app using a Grails controller with a micronaut `@MappedEntity` and `@JdbcRepository` defined in src.

This branch uses an H2 in memory database that is configured the same for both Grails and Micronaut.

Bootstrap will create the table, sequence and add a couple of rows using the default Grails dataSource with groovy Sql.