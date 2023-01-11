package g6micronautdata

import groovy.transform.CompileStatic
import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import java.time.LocalDate

@CompileStatic
@MappedEntity
class Person {

    @Id
    @GeneratedValue( ref = 'PERSON_ID_SEQ' )
    @NonNull
    Long id

    @NonNull
    @NotBlank
    String forename

    @NonNull
    @NotBlank
    String surname

    @DateCreated
    @NonNull
    @NotNull
    LocalDate dob
}
