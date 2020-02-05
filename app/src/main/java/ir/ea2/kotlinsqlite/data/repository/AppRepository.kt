package ir.ea2.kotlinsqlite.data.repository

import ir.ea2.kotlinsqlite.data.local.db.dao.PlayerDao
import ir.ea2.kotlinsqlite.data.local.db.dao.TeamDao
import ir.ea2.kotlinsqlite.data.model.Team

//Direct Connection To dao & remote and use their methods.
//Another Side Connect To Ui (in Mvvm connect to ViewModel) .
class AppRepository(val teamDao:TeamDao , val playerDao:PlayerDao) {

fun saveTeam(team: Team):Boolean{
return teamDao.save(team)}
}