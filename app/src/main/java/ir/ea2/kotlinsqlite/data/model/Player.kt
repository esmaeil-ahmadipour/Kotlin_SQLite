package ir.ea2.kotlinsqlite.data.model

data class Player(val id:Long , val name:String , val teamId:Long) {
    constructor(name: String,teamId: Long) :this(0,name, teamId)
}