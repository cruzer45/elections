package elections



import org.junit.*
import grails.test.mixin.*

@TestFor(ElectionController)
@Mock(Election)
class ElectionControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/election/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.electionInstanceList.size() == 0
        assert model.electionInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.electionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.electionInstance != null
        assert view == '/election/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/election/show/1'
        assert controller.flash.message != null
        assert Election.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/election/list'


        populateValidParams(params)
        def election = new Election(params)

        assert election.save() != null

        params.id = election.id

        def model = controller.show()

        assert model.electionInstance == election
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/election/list'


        populateValidParams(params)
        def election = new Election(params)

        assert election.save() != null

        params.id = election.id

        def model = controller.edit()

        assert model.electionInstance == election
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/election/list'

        response.reset()


        populateValidParams(params)
        def election = new Election(params)

        assert election.save() != null

        // test invalid parameters in update
        params.id = election.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/election/edit"
        assert model.electionInstance != null

        election.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/election/show/$election.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        election.clearErrors()

        populateValidParams(params)
        params.id = election.id
        params.version = -1
        controller.update()

        assert view == "/election/edit"
        assert model.electionInstance != null
        assert model.electionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/election/list'

        response.reset()

        populateValidParams(params)
        def election = new Election(params)

        assert election.save() != null
        assert Election.count() == 1

        params.id = election.id

        controller.delete()

        assert Election.count() == 0
        assert Election.get(election.id) == null
        assert response.redirectedUrl == '/election/list'
    }
}
