package g6micronautdata

import io.micronaut.core.annotation.NonNull
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository


import javax.transaction.Transactional
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import java.time.LocalDate

@JdbcRepository( dialect = Dialect.H2 )
interface PersonRepository extends CrudRepository<Person, Long> {

    @Transactional
    Person save(@NonNull @NotBlank String forename,
                @NonNull @NotBlank String surname,
                @NonNull @NotNull LocalDate dob)

    List<Person> findAll()

}
