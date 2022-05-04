package pokedex

import grails.gorm.services.Service

@Service(Pokemones)
interface PokemonesService {

    Pokemones get(Serializable id)

    List<Pokemones> list(Map args)

    Long count()

    void delete(Serializable id)

    Pokemones save(Pokemones pokemones)

}