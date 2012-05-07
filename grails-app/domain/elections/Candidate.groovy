package elections

class Candidate {

	String firstName
	String lastName
	Post post
	Team team

	static constraints = {
	}
	String toString() {
		return firstName + " " + lastName
	}
}
