package tidyslice

class CatchmeUser {

    String username
    String firstName
    String lastName
    String email

    static constraints = {
        username blank: false, unique: true
        email blank: false, unique: true
    }
}
