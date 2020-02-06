package ir.ea2.kotlinsqlite.data.local.db.dao

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import ir.ea2.kotlinsqlite.data.local.db.AppDatabase
import ir.ea2.kotlinsqlite.data.model.Player

class PlayerDao(appDatabase: AppDatabase) : BaseDao<Player>(appDatabase) {
    override fun save(entity: Player): Boolean {
        val db = appDatabase.writableDatabase
        updateContentValues(entity, contentValue)
        val insertResult = db.insert(AppDatabase.PLAYER_TABLE, null, contentValue)
        db.close()
        return insertResult > 0
    }

    override fun save(id: String, entity: Player): Boolean {
        val db = appDatabase.writableDatabase
        updateContentValues(entity, contentValue)
        val insertResult = db.update(
            AppDatabase.PLAYER_TABLE,
            contentValue,
            "${AppDatabase.PLAYER_ID} = ?",
            arrayOf(id)
        )
        db.close()
        return insertResult > 0
    }

    override fun findAll(): List<Player> {
        val db = appDatabase.readableDatabase
        query = "SELECT * FROM ${AppDatabase.PLAYER_TABLE}"
        val cursor = db.rawQuery(query, null)
        return cursorToList(cursor, db)
    }

    override fun find(columnName: String, columnValue: String): List<Player> {
        val db = appDatabase.readableDatabase
        // `?` in Next Line Is Standard For (SQL Injection).
        // value of `?` Set in Second Parameter Of rawQuery() .
        //For More `?` , We Need Array In Input Of Method Example: find(columnName:List<String> ,columnValue: List<String>)
        query = "SELECT * FROM ${AppDatabase.PLAYER_TABLE} WHERE $columnName = ?"
        val cursor = db.rawQuery(query, arrayOf(columnValue))
        return cursorToList(cursor, db)
    }

    override fun delete(id: String): Boolean {
        val db = appDatabase.writableDatabase
        //Delete By Id According to `id` Value .
        val result = db.delete(AppDatabase.PLAYER_TABLE, "${AppDatabase.PLAYER_ID} = ?", arrayOf(id))
        db.close()
        return result > 0
    }

    override fun updateContentValues(entity: Player, contentValue: ContentValues) {
        contentValue.clear()
        contentValue.put(AppDatabase.PLAYER_NAME, entity.name)
        contentValue.put(AppDatabase.PLAYER_TEAM_ID, entity.teamId)
    }

    override fun cursorToList(cursor: Cursor, db: SQLiteDatabase): List<Player> {
        data.clear()
        //If Has Data then Get Data , Add Data To List<Player> And Return List .
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex(AppDatabase.PLAYER_ID))
                val name = cursor.getString(cursor.getColumnIndex(AppDatabase.PLAYER_NAME))
                val teamId = cursor.getString(cursor.getColumnIndex(AppDatabase.PLAYER_TEAM_ID))
                data.add(Player(id.toLong(), name, teamId.toLong()))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return data
    }
}