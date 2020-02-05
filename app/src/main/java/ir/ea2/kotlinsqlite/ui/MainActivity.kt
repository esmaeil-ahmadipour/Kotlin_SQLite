package ir.ea2.kotlinsqlite.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ir.ea2.kotlinsqlite.R
import ir.ea2.kotlinsqlite.data.local.db.AppDatabase
import ir.ea2.kotlinsqlite.data.local.db.dao.PlayerDao
import ir.ea2.kotlinsqlite.data.local.db.dao.TeamDao
import ir.ea2.kotlinsqlite.data.model.Team
import ir.ea2.kotlinsqlite.data.repository.AppRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add Data For : Save New Team
       /* val barcelona = Team("Barcelona", "Camp Nou")
       val realmadrid = Team("RealMadrid", "Santiago Bernabeu")
       val juventus = Team("Juventus ", "Allianz")*/

        //Add Custom DI.
        val appDatabase: AppDatabase = AppDatabase(this)
        val teamDao: TeamDao = TeamDao(appDatabase)
        val playerDao: PlayerDao = PlayerDao(appDatabase)
        val appRepository = AppRepository(teamDao, playerDao)

        //Delete Team By Id & Show Result On Database
        val result = appRepository.deleteTeamById("6")
        Log.i("DELETE_TEAM" , result.toString())
        appRepository.findAllTeams().forEach{Log.i("FIND_ALL",it.toString())}

        //Find Methods For Team
        /*Log.i("FIND_BY_ID" , appRepository.findTeamById("3").toString())
        appRepository.findTeamsByName("Barcelona").forEach{Log.i("FIND_BY_NAME",it.toString())}
        appRepository.findTeamsByGround("Santiago Bernabeu").forEach{Log.i("FIND_BY_GROUND",it.toString())}*/

        //FindAll Teams
        /*
        appRepository.findAllTeams().forEach{Log.i("FIND_ALL",it.toString())}
        */

        //Save New Team
        /*appRepository.saveTeam(barcelona)
        appRepository.saveTeam(realmadrid)
        appRepository.saveTeam(juventus)*/
    }
}
