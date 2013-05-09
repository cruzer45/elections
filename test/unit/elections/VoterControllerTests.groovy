package elections



import org.junit.*
import grails.test.mixin.*

@TestFor(VoterController)
@Mock(Voter)
class VoterControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/voter/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.voterInstanceList.size() == 0
        assert model.voterInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.voterInstance != null
    }

    void testSave() {
        controller.save()

        assert model.voterInstance != null
        assert view == '/voter/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/voter/show/1'
        assert controller.flash.message != null
        assert Voter.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/voter/list'


        populateValidParams(params)
        def voter = new Voter(params)

        assert voter.save() != null

        params.id = voter.id

        def model = controller.show()

        assert model.voterInstance == voter
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/voter/list'


        populateValidParams(params)
        def voter = new Voter(params)

        assert voter.save() != null

        params.id = voter.id

        def model = controller.edit()

        assert model.voterInstance == voter
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/voter/list'

        response.reset()


        populateValidParams(params)
        def voter = new Voter(params)

        assert voter.save() != null

        // test invalid parameters in update
        params.id = voter.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/voter/edit"
        assert model.voterInstance != null

        voter.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/voter/show/$voter.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        voter.clearErrors()

        populateValidParams(params)
        params.id = voter.id
        params.version = -1
        controller.update()

        assert view == "/voter/edit"
        assert model.voterInstance != null
        assert model.voterInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/voter/list'

        response.reset()

        populateValidParams(params)
        def voter = new Voter(params)

        assert voter.save() != null
        assert Voter.count() == 1

        params.id = voter.id

        controller.delete()

        assert Voter.count() == 0
        assert Voter.get(voter.id) == null
        assert response.redirectedUrl == '/voter/list'
    }
}
