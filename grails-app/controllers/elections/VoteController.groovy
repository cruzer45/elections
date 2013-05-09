package elections

import org.springframework.dao.DataIntegrityViolationException

class VoteController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [voteInstanceList: Vote.list(params), voteInstanceTotal: Vote.count()]
    }

    def create() {
        [voteInstance: new Vote(params)]
    }

    def save() {
        def voteInstance = new Vote(params)
        if (!voteInstance.save(flush: true)) {
            render(view: "create", model: [voteInstance: voteInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'vote.label', default: 'Vote'), voteInstance.id])
        //redirect(action: "show", id: voteInstance.id)
		redirect(action: "voteSaved")
    }

    def show() {
        def voteInstance = Vote.get(params.id)
        if (!voteInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'vote.label', default: 'Vote'), params.id])
            redirect(action: "list")
            return
        }

        [voteInstance: voteInstance]
    }

    def edit() {
        def voteInstance = Vote.get(params.id)
        if (!voteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vote.label', default: 'Vote'), params.id])
            redirect(action: "list")
            return
        }

        [voteInstance: voteInstance]
    }

    def update() {
        def voteInstance = Vote.get(params.id)
        if (!voteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vote.label', default: 'Vote'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (voteInstance.version > version) {
                voteInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'vote.label', default: 'Vote')] as Object[],
                          "Another user has updated this Vote while you were editing")
                render(view: "edit", model: [voteInstance: voteInstance])
                return
            }
        }

        voteInstance.properties = params

        if (!voteInstance.save(flush: true)) {
            render(view: "edit", model: [voteInstance: voteInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'vote.label', default: 'Vote'), voteInstance.id])
        redirect(action: "show", id: voteInstance.id)
    }

    def delete() {
        def voteInstance = Vote.get(params.id)
        if (!voteInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'vote.label', default: 'Vote'), params.id])
            redirect(action: "list")
            return
        }

        try {
            voteInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'vote.label', default: 'Vote'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'vote.label', default: 'Vote'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def results(){
		
	}
	
	def voteSaved()
	{
		
	}
}
