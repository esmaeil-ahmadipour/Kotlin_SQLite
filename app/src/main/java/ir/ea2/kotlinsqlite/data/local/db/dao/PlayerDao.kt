package ir.ea2.kotlinsqlite.data.local.db.dao

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import ir.ea2.kotlinsqlite.data.local.db.AppDatabase
import ir.ea2.kotlinsqlite.data.model.Player

class PlayerDao(appDatabase: AppDatabase):BaseDao<Player>(appDatabase) {
    override fun save(entity: Player): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(id: String, entity: Player): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(columnName: String, columnValue: String): List<Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateContentValues(entity: Player, contentValue: ContentValues) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cursorToList(cursor: Cursor, db: SQLiteDatabase): List<Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}