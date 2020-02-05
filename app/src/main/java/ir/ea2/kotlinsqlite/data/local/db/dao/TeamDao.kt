package ir.ea2.kotlinsqlite.data.local.db.dao

import ir.ea2.kotlinsqlite.data.local.db.AppDatabase
import ir.ea2.kotlinsqlite.data.model.Team

//Three Action is important. 1-open database/2-save database/3-close database
class TeamDao(appDatabase: AppDatabase) : BaseDao<Team>(appDatabase) {
    override fun save(entity: Team): Boolean {
        val db = appDatabase.writableDatabase
        contentValue.clear()
        contentValue.put(AppDatabase.TEAM_NAME, entity.name)
        contentValue.put(AppDatabase.TEAM_GROUND, entity.ground)
        val insertResult = db.insert(AppDatabase.TEAM_TABLE, null, contentValue)
        db.close()
        if (insertResult > 0) return true
        return false

    }

    override fun save(id: String, entity: Team): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<Team> {
        val db = appDatabase.readableDatabase
        query = "SELECT * FROM ${AppDatabase.TEAM_TABLE}"
        val cursor = db.rawQuery(query, null)
        data.clear()
        //If Has Data then Get Data , Add Data To List<Team> And Return List .
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex(AppDatabase.TEAM_ID))
                val name = cursor.getString(cursor.getColumnIndex(AppDatabase.TEAM_NAME))
                val ground = cursor.getString(cursor.getColumnIndex(AppDatabase.TEAM_GROUND))
                data.add(Team(id.toLong(), name, ground))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return data
    }

    override fun find(columnName: String, columnValue: String): List<Team> {
        val db = appDatabase.readableDatabase
        // `?` in Next Line Is Standard For (SQL Injection).
        // value of `?` Set in Second Parameter Of rawQuery() .
        //For More `?` , We Need Array In Input Of Method Example: find(columnName:List<String> ,columnValue: List<String>)
        query = "SELECT * FROM ${AppDatabase.TEAM_TABLE} WHERE $columnName = ?"
        val cursor = db.rawQuery(query, arrayOf(columnValue))
        data.clear()
        //If Has Data then Get Data , Add Data To List<Team> And Return List .
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex(AppDatabase.TEAM_ID))
                val name = cursor.getString(cursor.getColumnIndex(AppDatabase.TEAM_NAME))
                val ground = cursor.getString(cursor.getColumnIndex(AppDatabase.TEAM_GROUND))
                data.add(Team(id.toLong(), name, ground))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return data
    }

    override fun delete(id: String): Boolean {
        val db = appDatabase.writableDatabase
        //Delete By Id According to `id` Value .
        val result = db.delete(AppDatabase.TEAM_TABLE, "${AppDatabase.TEAM_ID} = ?", arrayOf(id))
        db.close()
        if (result > 0) {
            // DELETE SUCCESSFULLY
            return true
        } else {
            // DELETE FAILED
            return false
        }
    }
}