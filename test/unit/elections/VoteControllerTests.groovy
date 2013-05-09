package elections



import org.junit.*
import grails.test.mixin.*

@TestFor(VoteController)
@Mock(Vote)
class VoteControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/vote/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.voteInstanceList.size() == 0
        assert model.voteInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.voteInstance != null
    }

    void testSave() {
        controller.save()

        assert model.voteInstance != null
        assert view == '/vote/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/vote/show/1'
        assert controller.flash.message != null
        assert Vote.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/vote/list'


        populateValidParams(params)
        def vote = new Vote(params)

        assert vote.save() != null

        params.id = vote.id

        def model = controller.show()

        assert model.voteInstance == vote
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/vote/list'


        populateValidParams(params)
        def vote = new Vote(params)

        assert vote.save() != null

        params.id = vote.id

        def model = controller.edit()

        assert model.voteInstance == vote
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/vote/list'

        response.reset()


        populateValidParams(params)
        def vote = new Vote(params)

        assert vote.save() != null

        // test invalid parameters in update
        params.id = vote.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/vote/edit"
        assert model.voteInstance != null

        vote.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/vote/show/$vote.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        vote.clearErrors()

        populateValidParams(params)
        params.id = vote.id
        params.version = -1
        controller.update()

        assert view == "/vote/edit"
        assert model.voteInstance != null
        assert model.voteInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/vote/list'

        response.reset()

        populateValidParams(params)
        def vote = new Vote(params)

        assert vote.save() != null
        assert Vote.count() == 1

        params.id = vote.id

        controller.delete()

        assert Vote.count() == 0
        assert Vote.get(vote.id) == null
        assert response.redirectedUrl == '/vote/list'
    }
}
