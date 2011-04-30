package tidyslice

class CatchmeUser {

    String username
    String firstName
    String lastName
    String email

    static hasMany = [ contacts : Contact ]
    static constraints = {
        username blank: true, unique: true
        email blank: false, unique: true
    }
}
