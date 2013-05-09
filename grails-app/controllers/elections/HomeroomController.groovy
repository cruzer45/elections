package elections

import org.springframework.dao.DataIntegrityViolationException

class HomeroomController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [homeroomInstanceList: Homeroom.list(params), homeroomInstanceTotal: Homeroom.count()]
    }

    def create() {
        [homeroomInstance: new Homeroom(params)]
    }

    def save() {
        def homeroomInstance = new Homeroom(params)
        if (!homeroomInstance.save(flush: true)) {
            render(view: "create", model: [homeroomInstance: homeroomInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'homeroom.label', default: 'Homeroom'), homeroomInstance.id])
        redirect(action: "show", id: homeroomInstance.id)
    }

    def show() {
        def homeroomInstance = Homeroom.get(params.id)
        if (!homeroomInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'homeroom.label', default: 'Homeroom'), params.id])
            redirect(action: "list")
            return
        }

        [homeroomInstance: homeroomInstance]
    }

    def edit() {
        def homeroomInstance = Homeroom.get(params.id)
        if (!homeroomInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'homeroom.label', default: 'Homeroom'), params.id])
            redirect(action: "list")
            return
        }

        [homeroomInstance: homeroomInstance]
    }

    def update() {
        def homeroomInstance = Homeroom.get(params.id)
        if (!homeroomInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'homeroom.label', default: 'Homeroom'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (homeroomInstance.version > version) {
                homeroomInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'homeroom.label', default: 'Homeroom')] as Object[],
                          "Another user has updated this Homeroom while you were editing")
                render(view: "edit", model: [homeroomInstance: homeroomInstance])
                return
            }
        }

        homeroomInstance.properties = params

        if (!homeroomInstance.save(flush: true)) {
            render(view: "edit", model: [homeroomInstance: homeroomInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'homeroom.label', default: 'Homeroom'), homeroomInstance.id])
        redirect(action: "show", id: homeroomInstance.id)
    }

    def delete() {
        def homeroomInstance = Homeroom.get(params.id)
        if (!homeroomInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'homeroom.label', default: 'Homeroom'), params.id])
            redirect(action: "list")
            return
        }

        try {
            homeroomInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'homeroom.label', default: 'Homeroom'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'homeroom.label', default: 'Homeroom'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
