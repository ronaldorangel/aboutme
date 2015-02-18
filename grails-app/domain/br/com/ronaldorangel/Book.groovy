package br.com.ronaldorangel

class Book {

	String name
	Date creationDate = new Date()

	static hasMany = [questions: Question, score: Score]
    static belongsTo = [user: User]

    static constraints = {
        name(blank: false)
        questions(nullable: true)
        score(nullable: true)
    }
}
