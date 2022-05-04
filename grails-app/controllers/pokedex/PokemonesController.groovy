package pokedex

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PokemonesController {

    PokemonesService pokemonesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pokemonesService.list(params), model:[pokemonesCount: pokemonesService.count()]
    }

    def show(Long id) {
        respond pokemonesService.get(id)
    }

    def create() {
        respond new Pokemones(params)
    }

    def save(Pokemones pokemones) {
        if (pokemones == null) {
            notFound()
            return
        }

        try {
            pokemonesService.save(pokemones)
        } catch (ValidationException e) {
            respond pokemones.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pokemones.label', default: 'Pokemones'), pokemones.id])
                redirect pokemones
            }
            '*' { respond pokemones, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pokemonesService.get(id)
    }

    def update(Pokemones pokemones) {
        if (pokemones == null) {
            notFound()
            return
        }

        try {
            pokemonesService.save(pokemones)
        } catch (ValidationException e) {
            respond pokemones.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pokemones.label', default: 'Pokemones'), pokemones.id])
                redirect pokemones
            }
            '*'{ respond pokemones, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pokemonesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pokemones.label', default: 'Pokemones'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pokemones.label', default: 'Pokemones'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
