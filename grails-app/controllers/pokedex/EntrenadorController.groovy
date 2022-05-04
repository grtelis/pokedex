package pokedex

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EntrenadorController {

    EntrenadorService entrenadorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond entrenadorService.list(params), model:[entrenadorCount: entrenadorService.count()]
    }

    def show(Long id) {
        respond entrenadorService.get(id)
    }

    def create() {
        respond new Entrenador(params)
    }

    def save(Entrenador entrenador) {
        if (entrenador == null) {
            notFound()
            return
        }

        try {
            entrenadorService.save(entrenador)
        } catch (ValidationException e) {
            respond entrenador.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entrenador.label', default: 'Entrenador'), entrenador.id])
                redirect entrenador
            }
            '*' { respond entrenador, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond entrenadorService.get(id)
    }

    def update(Entrenador entrenador) {
        if (entrenador == null) {
            notFound()
            return
        }

        try {
            entrenadorService.save(entrenador)
        } catch (ValidationException e) {
            respond entrenador.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'entrenador.label', default: 'Entrenador'), entrenador.id])
                redirect entrenador
            }
            '*'{ respond entrenador, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        entrenadorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'entrenador.label', default: 'Entrenador'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrenador.label', default: 'Entrenador'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
