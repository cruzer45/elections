package elections

import org.springframework.dao.DataIntegrityViolationException

class ElectionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [electionInstanceList: Election.list(params), electionInstanceTotal: Election.count()]
    }

    def create() {
        [electionInstance: new Election(params)]
    }

    def save() {
        def electionInstance = new Election(params)
        if (!electionInstance.save(flush: true)) {
            render(view: "create", model: [electionInstance: electionInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'election.label', default: 'Election'), electionInstance.id])
        redirect(action: "show", id: electionInstance.id)
    }

    def show() {
        def electionInstance = Election.get(params.id)
        if (!electionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'election.label', default: 'Election'), params.id])
            redirect(action: "list")
            return
        }

        [electionInstance: electionInstance]
    }

    def edit() {
        def electionInstance = Election.get(params.id)
        if (!electionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'election.label', default: 'Election'), params.id])
            redirect(action: "list")
            return
        }

        [electionInstance: electionInstance]
    }

    def update() {
        def electionInstance = Election.get(params.id)
        if (!electionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'election.label', default: 'Election'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (electionInstance.version > version) {
                electionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'election.label', default: 'Election')] as Object[],
                          "Another user has updated this Election while you were editing")
                render(view: "edit", model: [electionInstance: electionInstance])
                return
            }
        }

        electionInstance.properties = params

        if (!electionInstance.save(flush: true)) {
            render(view: "edit", model: [electionInstance: electionInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'election.label', default: 'Election'), electionInstance.id])
        redirect(action: "show", id: electionInstance.id)
    }

    def delete() {
        def electionInstance = Election.get(params.id)
        if (!electionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'election.label', default: 'Election'), params.id])
            redirect(action: "list")
            return
        }

        try {
            electionInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'election.label', default: 'Election'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'election.label', default: 'Election'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
