package pokedex

import grails.gorm.services.Service

@Service(Entrenadores)
interface EntrenadoresService {

    Entrenadores get(Serializable id)

    List<Entrenadores> list(Map args)

    Long count()

    void delete(Serializable id)

    Entrenadores save(Entrenadores entrenadores)

}