package pokedex

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PokemonesServiceSpec extends Specification {

    PokemonesService pokemonesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pokemones(...).save(flush: true, failOnError: true)
        //new Pokemones(...).save(flush: true, failOnError: true)
        //Pokemones pokemones = new Pokemones(...).save(flush: true, failOnError: true)
        //new Pokemones(...).save(flush: true, failOnError: true)
        //new Pokemones(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pokemones.id
    }

    void "test get"() {
        setupData()

        expect:
        pokemonesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pokemones> pokemonesList = pokemonesService.list(max: 2, offset: 2)

        then:
        pokemonesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pokemonesService.count() == 5
    }

    void "test delete"() {
        Long pokemonesId = setupData()

        expect:
        pokemonesService.count() == 5

        when:
        pokemonesService.delete(pokemonesId)
        sessionFactory.currentSession.flush()

        then:
        pokemonesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pokemones pokemones = new Pokemones()
        pokemonesService.save(pokemones)

        then:
        pokemones.id != null
    }
}
