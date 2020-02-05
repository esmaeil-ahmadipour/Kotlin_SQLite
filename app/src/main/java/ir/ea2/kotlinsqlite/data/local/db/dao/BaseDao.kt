package ir.ea2.kotlinsqlite.data.local.db.dao

import android.content.ContentValues
import ir.ea2.kotlinsqlite.data.local.db.AppDatabase
import ir.ea2.kotlinsqlite.data.local.db.ContentValuesUpdater
import ir.ea2.kotlinsqlite.data.local.db.CursorConverter
import ir.ea2.kotlinsqlite.data.model.Team

abstract class BaseDao<T>(val appDatabase: AppDatabase) : ContentValuesUpdater<T> , CursorConverter<T>{
    val contentValue = ContentValues()
    //For Better Using From Resources Set query&data In BaseDaoClass.
    var query = ""
    var data: MutableList<Team> = ArrayList()

    abstract fun  save (entity:T):Boolean
    abstract  fun save (id:String , entity: T):Boolean
    abstract fun findAll():List<T>
    abstract fun find(columnName:String , columnValue:String):List<T>
    abstract fun delete(id: String):Boolean
}