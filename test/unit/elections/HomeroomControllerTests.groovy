package elections



import org.junit.*
import grails.test.mixin.*

@TestFor(HomeroomController)
@Mock(Homeroom)
class HomeroomControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/homeroom/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.homeroomInstanceList.size() == 0
        assert model.homeroomInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.homeroomInstance != null
    }

    void testSave() {
        controller.save()

        assert model.homeroomInstance != null
        assert view == '/homeroom/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/homeroom/show/1'
        assert controller.flash.message != null
        assert Homeroom.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/homeroom/list'


        populateValidParams(params)
        def homeroom = new Homeroom(params)

        assert homeroom.save() != null

        params.id = homeroom.id

        def model = controller.show()

        assert model.homeroomInstance == homeroom
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/homeroom/list'


        populateValidParams(params)
        def homeroom = new Homeroom(params)

        assert homeroom.save() != null

        params.id = homeroom.id

        def model = controller.edit()

        assert model.homeroomInstance == homeroom
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/homeroom/list'

        response.reset()


        populateValidParams(params)
        def homeroom = new Homeroom(params)

        assert homeroom.save() != null

        // test invalid parameters in update
        params.id = homeroom.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/homeroom/edit"
        assert model.homeroomInstance != null

        homeroom.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/homeroom/show/$homeroom.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        homeroom.clearErrors()

        populateValidParams(params)
        params.id = homeroom.id
        params.version = -1
        controller.update()

        assert view == "/homeroom/edit"
        assert model.homeroomInstance != null
        assert model.homeroomInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/homeroom/list'

        response.reset()

        populateValidParams(params)
        def homeroom = new Homeroom(params)

        assert homeroom.save() != null
        assert Homeroom.count() == 1

        params.id = homeroom.id

        controller.delete()

        assert Homeroom.count() == 0
        assert Homeroom.get(homeroom.id) == null
        assert response.redirectedUrl == '/homeroom/list'
    }
}
