package ir.ea2.kotlinsqlite.data.model

data class Team(val id : Long , val name:String , val ground:String) {
constructor(name:String , ground: String):this(0,name, ground)
}