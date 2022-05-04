package pokedex

import grails.gorm.services.Service

@Service(Pokemon)
interface PokemonService {

    Pokemon get(Serializable id)

    List<Pokemon> list(Map args)

    Long count()

    void delete(Serializable id)

    Pokemon save(Pokemon pokemon)

}