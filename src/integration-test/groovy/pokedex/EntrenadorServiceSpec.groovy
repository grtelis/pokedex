package pokedex

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EntrenadorServiceSpec extends Specification {

    EntrenadorService entrenadorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Entrenador(...).save(flush: true, failOnError: true)
        //new Entrenador(...).save(flush: true, failOnError: true)
        //Entrenador entrenador = new Entrenador(...).save(flush: true, failOnError: true)
        //new Entrenador(...).save(flush: true, failOnError: true)
        //new Entrenador(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //entrenador.id
    }

    void "test get"() {
        setupData()

        expect:
        entrenadorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Entrenador> entrenadorList = entrenadorService.list(max: 2, offset: 2)

        then:
        entrenadorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        entrenadorService.count() == 5
    }

    void "test delete"() {
        Long entrenadorId = setupData()

        expect:
        entrenadorService.count() == 5

        when:
        entrenadorService.delete(entrenadorId)
        sessionFactory.currentSession.flush()

        then:
        entrenadorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Entrenador entrenador = new Entrenador()
        entrenadorService.save(entrenador)

        then:
        entrenador.id != null
    }
}
