package elections


class Vote {

	Candidate president
	Candidate firstVicePresident
	Candidate secondVicePresident
	Candidate treasurer
	Candidate secretary
	Candidate directorOfSports
	Candidate directorOfEducation	

    static constraints = {
		president(nullable:true)
		firstVicePresident(nullable:true)
		secondVicePresident(nullable:true)
		treasurer(nullable:true)
		secretary(nullable:true)
		directorOfSports(nullable:true)
		directorOfEducation(nullable:true)
    }
}
