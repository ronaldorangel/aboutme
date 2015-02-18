package br.com.ronaldorangel

class User {

	String username
	String name
	String surname
	String password
    Boolean active = true

	int credits = 10
    Book book

    static constraints = {
        username (blank: false, nullable: false, unique: true)
        name (blank: false, nullable: false)
        surname (blank: false, nullable: false)
        password (password: true, blank: false, nullable: true, minSize: 6)
        credits (min: 0 )
    }
}
