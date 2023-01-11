package g6micronautdata

import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

import javax.transaction.Transactional
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import java.time.LocalDate

@Repository
interface PersonRepository extends CrudRepository<Person, Integer> {

    @Transactional
    Person save(@NonNull @NotBlank String forename,
                @NonNull @NotBlank String surname,
                @NonNull @NotNull LocalDate dob)

    Optional<Person> findByForename(@NonNull @NotBlank String forename)

    List<Person> findAll()

}
