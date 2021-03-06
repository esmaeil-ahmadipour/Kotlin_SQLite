package ir.ea2.kotlinsqlite.data.repository

import ir.ea2.kotlinsqlite.data.local.db.AppDatabase
import ir.ea2.kotlinsqlite.data.local.db.dao.PlayerDao
import ir.ea2.kotlinsqlite.data.local.db.dao.TeamDao
import ir.ea2.kotlinsqlite.data.model.Player
import ir.ea2.kotlinsqlite.data.model.Team

//Direct Connection To dao & remote and use their methods.
//Another Side Connect To Ui (in Mvvm connect to ViewModel) .
class AppRepository(val teamDao: TeamDao, val playerDao: PlayerDao) {

    fun saveTeam(team: Team): Boolean {
        return teamDao.save(team)
    }

    fun findAllTeams(): List<Team> {
        return teamDao.findAll()
    }

    fun findTeamById(id: String): Team {
        return teamDao.find(AppDatabase.TEAM_ID, id)[0]
    }

    fun findTeamsByName(name: String): List<Team> {
        return teamDao.find(AppDatabase.TEAM_NAME, name)
    }

    fun findTeamsByGround(ground: String): List<Team> {
        return teamDao.find(AppDatabase.TEAM_GROUND, ground)
    }

    fun deleteTeamById(id: String): Boolean {
        return teamDao.delete(id)
    }

    fun updateTeam(id: String, team: Team): Boolean {
        return teamDao.save(id, team)
    }


    fun savePlayer(player: Player): Boolean {
        return playerDao.save(player)
    }

    fun findAllPlayers(): List<Player> {
        return playerDao.findAll()
    }

    fun findPlayerById(id: String): Player {
        return playerDao.find(AppDatabase.PLAYER_ID, id)[0]
    }


    fun findTeamByPlayer(playerId: String): Team {
        return findTeamById(findPlayerById(playerId).teamId.toString())
    }

    fun findPlayersByTeam(teamId: String): List<Player> {
        return playerDao.find(AppDatabase.TEAM_ID , teamId)
    }
}