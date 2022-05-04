package pokedex

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EntrenadoresController {

    EntrenadoresService entrenadoresService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond entrenadoresService.list(params), model:[entrenadoresCount: entrenadoresService.count()]
    }

    def show(Long id) {
        respond entrenadoresService.get(id)
    }

    def create() {
        respond new Entrenadores(params)
    }

    def save(Entrenadores entrenadores) {
        if (entrenadores == null) {
            notFound()
            return
        }

        try {
            entrenadoresService.save(entrenadores)
        } catch (ValidationException e) {
            respond entrenadores.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entrenadores.label', default: 'Entrenadores'), entrenadores.id])
                redirect entrenadores
            }
            '*' { respond entrenadores, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond entrenadoresService.get(id)
    }

    def update(Entrenadores entrenadores) {
        if (entrenadores == null) {
            notFound()
            return
        }

        try {
            entrenadoresService.save(entrenadores)
        } catch (ValidationException e) {
            respond entrenadores.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'entrenadores.label', default: 'Entrenadores'), entrenadores.id])
                redirect entrenadores
            }
            '*'{ respond entrenadores, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        entrenadoresService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'entrenadores.label', default: 'Entrenadores'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrenadores.label', default: 'Entrenadores'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
