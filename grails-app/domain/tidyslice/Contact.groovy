package tidyslice

class Contact {

    String username
    String firstName
    String lastName
    String fbId
    Integer type  //1 for FB, 2 for Twitter

    static belongsTo = [user:CatchmeUser]

    static constraints = {
        username blank: false, unique: false
    }
}
