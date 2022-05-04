package pokedex

import grails.gorm.services.Service

@Service(Entrenador)
interface EntrenadorService {

    Entrenador get(Serializable id)

    List<Entrenador> list(Map args)

    Long count()

    void delete(Serializable id)

    Entrenador save(Entrenador entrenador)

}