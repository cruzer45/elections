package elections

class Election {

	String title
	Date electionDate

	static constraints = {
		title()
		electionDate()
	}

	String toString() {
		return title
	}
}
