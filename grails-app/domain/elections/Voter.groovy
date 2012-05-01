package elections

class Voter {

	String firstName
	String lastName
	Homeroom homeroom

    static constraints = {
        firstName()
        lastName()
        homeroom()
    }

    String toString()
    {
    	return firstName + " "	+ lastName
    }
}
