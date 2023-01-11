package g6micronautdata

import javax.inject.Inject

class PersonController {

    @Inject
    PersonRepository personRepository

    def index() {
        List<Person> people = personRepository.findAll()
        log.info("Found ${people.size()} people")
        [people: people]
    }

    def bob() {
        def bob = personRepository.findByForename('Bob')
        log.info("Found a Bob ${bob.surname}")
        [bob: bob]
    }
}
