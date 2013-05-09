package elections

class Team {

	String name

    static constraints = {
    	name(blank:false)
    }
    String toString()
    {
     return name	
    }
}
