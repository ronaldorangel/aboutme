import br.com.ronaldorangel.*
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        def result = ""
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                result = 'now running in DEV mode.'
                seedTestData()
                break;
            case Environment.TEST:
                result = 'now running in TEST mode.'
                break;
            case Environment.PRODUCTION:
                result = 'now running in PROD mode.'
                break;
        }
    }
    def destroy = {
    }


    private void seedTestData() {
        def user = User.findByUsername('Rangel')
        if (!user){
            user = new User(username: 'Rangel',
                    name: 'Ronaldo',
                    surname: 'Rangel'
            )

        }
        if (!user.book){
            def book = new Book(name: "Meu livro");
            user.book = book
        }

        if (user.book.questions && user.book.questions.size() < 2){
            def q1 = new Question(content: "Essa é a primeira pergunta teste?", author: user);
            def a1u2 = new Answer(content: "Sim, é a primeira pergunta, e essa é a resposta! Respondida pelo user 2",
                    author: User.findByUsername('user2')?: new User(username: 'user2', name: "Nome 2", surname: "Sobrenome 2").save())
            def a1u3 = new Answer(content: "Sim, é a primeira pergunta, e essa é a resposta! Respondida pelo user 3",
                    author: User.findByUsername('user2')?: new User(username: 'user3', name: "Nome 3", surname: "Sobrenome 3").save())
            def q2 = new Question(content: "E essa? É a segunda pergunta teste?", author: user);
            def a2u2 = new Answer(content: "Esta é a segunda resposta, e de fato a pergunta a qual ela se refere é a segunda! Respondida pelo user 2",
                    author: User.findByUsername('user2'))
            def a2u3 = new Answer(content: "Esta é a segunda resposta, e de fato a pergunta a qual ela se refere é a segunda! Respondida pelo user 3",
                    author: User.findByUsername('user3'))
            q1.addToAnswers(a1u2)
            q1.addToAnswers(a1u3)
            q2.addToAnswers(a2u2)
            q2.addToAnswers(a2u3)
            user.book.addToQuestions(q1)
            user.book.addToQuestions(q2)
        }


        user.save()
    }


}
