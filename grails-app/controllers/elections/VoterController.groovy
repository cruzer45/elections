package elections

import org.springframework.dao.DataIntegrityViolationException

class VoterController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [voterInstanceList: Voter.list(params), voterInstanceTotal: Voter.count()]
    }

    def create() {
        [voterInstance: new Voter(params)]
    }

    def save() {
        def voterInstance = new Voter(params)
        if (!voterInstance.save(flush: true)) {
            render(view: "create", model: [voterInstance: voterInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'voter.label', default: 'Voter'), voterInstance.id])
        redirect(action: "show", id: voterInstance.id)
    }

    def show() {
        def voterInstance = Voter.get(params.id)
        if (!voterInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'voter.label', default: 'Voter'), params.id])
            redirect(action: "list")
            return
        }

        [voterInstance: voterInstance]
    }

    def edit() {
        def voterInstance = Voter.get(params.id)
        if (!voterInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voter.label', default: 'Voter'), params.id])
            redirect(action: "list")
            return
        }

        [voterInstance: voterInstance]
    }

    def update() {
        def voterInstance = Voter.get(params.id)
        if (!voterInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voter.label', default: 'Voter'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (voterInstance.version > version) {
                voterInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'voter.label', default: 'Voter')] as Object[],
                          "Another user has updated this Voter while you were editing")
                render(view: "edit", model: [voterInstance: voterInstance])
                return
            }
        }

        voterInstance.properties = params

        if (!voterInstance.save(flush: true)) {
            render(view: "edit", model: [voterInstance: voterInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'voter.label', default: 'Voter'), voterInstance.id])
        redirect(action: "show", id: voterInstance.id)
    }

    def delete() {
        def voterInstance = Voter.get(params.id)
        if (!voterInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'voter.label', default: 'Voter'), params.id])
            redirect(action: "list")
            return
        }

        try {
            voterInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'voter.label', default: 'Voter'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'voter.label', default: 'Voter'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
