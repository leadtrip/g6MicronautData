package g6micronautdata

import javax.inject.Inject

class PersonController {

    @Inject
    PersonRepository personRepository

    def index() {
        Iterable<Person> people = personRepository.findAll()
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

    def save( Person person ) {
        person = personRepository.save( person )

        redirect (action: 'show', params: [id: person.id])
    }
}
