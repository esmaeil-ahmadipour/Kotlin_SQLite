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
      if(insertResult>0) return true
        return false

    }

    override fun save(id: String, entity: Team): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<Team> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(columnName: String, columnValue: String): List<Team> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}