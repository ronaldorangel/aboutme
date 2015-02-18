package br.com.ronaldorangel

class Question {

	String content
	Date creationDate = new Date()
    User author

	static hasMany = [answers: Answer]

    static constraints = {
        content(blank: false, nullable: false)
        author(nullable: false)
    }

    static mapping = {
        answers(cascade: 'all-delete-orphan')
    }
}
