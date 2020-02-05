package ir.ea2.kotlinsqlite.data.local.db.dao

import ir.ea2.kotlinsqlite.data.local.db.AppDatabase

abstract class BaseDao<T>(appdatabase: AppDatabase) {
    abstract fun  save (entity:T):Boolean
    abstract  fun save (id:String , entity: T):Boolean
    abstract fun findAll():List<T>
    abstract fun find(columnName:String , columnValue:String):List<T>
    abstract fun delete(id: String):Boolean
}