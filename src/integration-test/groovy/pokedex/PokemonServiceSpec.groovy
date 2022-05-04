package pokedex

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PokemonServiceSpec extends Specification {

    PokemonService pokemonService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pokemon(...).save(flush: true, failOnError: true)
        //new Pokemon(...).save(flush: true, failOnError: true)
        //Pokemon pokemon = new Pokemon(...).save(flush: true, failOnError: true)
        //new Pokemon(...).save(flush: true, failOnError: true)
        //new Pokemon(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pokemon.id
    }

    void "test get"() {
        setupData()

        expect:
        pokemonService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pokemon> pokemonList = pokemonService.list(max: 2, offset: 2)

        then:
        pokemonList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pokemonService.count() == 5
    }

    void "test delete"() {
        Long pokemonId = setupData()

        expect:
        pokemonService.count() == 5

        when:
        pokemonService.delete(pokemonId)
        sessionFactory.currentSession.flush()

        then:
        pokemonService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pokemon pokemon = new Pokemon()
        pokemonService.save(pokemon)

        then:
        pokemon.id != null
    }
}
