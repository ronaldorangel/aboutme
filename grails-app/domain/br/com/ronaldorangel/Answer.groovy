package br.com.ronaldorangel

class Answer {

    String content
    User author

	static belongsTo = [question: Question, book: Book]

    static constraints = {
        content(blank: false, nullable: false)
        author(nullable: false)
    }
}
