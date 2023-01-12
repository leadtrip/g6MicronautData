package g6micronautdata

import javax.inject.Inject
import java.time.LocalDate

import static org.springframework.http.HttpStatus.CREATED

class PersonController {

    @Inject
    PersonRepository personRepository

    def index() {
        List<Person> people = personRepository.findAll()
        log.info("Found ${people.size()} people")
        [people: people]
    }

    def show() {
        def person = personRepository.findById(params.id)
        person.ifPresent {
            log.info("Found ${it.forename} ${it.surname}")
        }
        [person: person.orElseGet { new Person() }]
    }

    def create() {}

    def save( PersonCommand person ) {
        personRepository.save( person.forename,  person.surname,  LocalDate.now() )

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect person
            }
            '*' { respond person, [status: CREATED] }
        }
    }
}

class PersonCommand {
    String forename
    String surname
    LocalDate dob
}
