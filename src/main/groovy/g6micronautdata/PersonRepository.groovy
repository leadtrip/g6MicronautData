package g6micronautdata


import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository( dialect = Dialect.ORACLE, dataSource = 'oracle' )
interface PersonRepository extends CrudRepository<Person, Integer> {}
