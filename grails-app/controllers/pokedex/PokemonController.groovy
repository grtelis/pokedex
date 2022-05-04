package pokedex

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PokemonController {

    PokemonService pokemonService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pokemonService.list(params), model:[pokemonCount: pokemonService.count()]
    }

    def show(Long id) {
        respond pokemonService.get(id)
    }

    def create() {
        respond new Pokemon(params)
    }

    def save(Pokemon pokemon) {
        if (pokemon == null) {
            notFound()
            return
        }

        try {
            pokemonService.save(pokemon)
        } catch (ValidationException e) {
            respond pokemon.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pokemon.label', default: 'Pokemon'), pokemon.id])
                redirect pokemon
            }
            '*' { respond pokemon, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pokemonService.get(id)
    }

    def update(Pokemon pokemon) {
        if (pokemon == null) {
            notFound()
            return
        }

        try {
            pokemonService.save(pokemon)
        } catch (ValidationException e) {
            respond pokemon.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pokemon.label', default: 'Pokemon'), pokemon.id])
                redirect pokemon
            }
            '*'{ respond pokemon, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pokemonService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pokemon.label', default: 'Pokemon'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pokemon.label', default: 'Pokemon'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
