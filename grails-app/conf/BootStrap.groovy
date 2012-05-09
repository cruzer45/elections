class BootStrap {

    def init = { servletContext ->
    	if (elections.Post.count() == 0)
    	{
    		new elections.Post(title:"President").save()
    		new elections.Post(title:"First Vice President").save()
    		new elections.Post(title:"Second Vice President").save()
    		new elections.Post(title:"Treasurer").save()
    		new elections.Post(title:"Secretary").save()
    		new elections.Post(title:"Director of Sports").save()
    		new elections.Post(title:"Director of Education").save()
    	}
    }
    def destroy = {
    }
}
