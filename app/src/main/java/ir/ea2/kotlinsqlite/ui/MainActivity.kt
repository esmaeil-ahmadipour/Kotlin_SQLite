package ir.ea2.kotlinsqlite.ui

import android.os.Bundle
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
        val barcelona = Team("Barcelona", "Camp Nou")
        val realmadrid = Team("RealMadrid", "Santiago Bernabeu")
        val juventus = Team("Juventus ", "Allianz")


        //Add Custom DI.
        //If Use Dagger2 is Easiest.
        val appDatabase: AppDatabase = AppDatabase(this)

        val teamDao: TeamDao = TeamDao(appDatabase)
        val playerDao: PlayerDao = PlayerDao(appDatabase)

        val appRepository = AppRepository(teamDao, playerDao)

        appRepository.saveTeam(barcelona)
        appRepository.saveTeam(realmadrid)
        appRepository.saveTeam(juventus)
    }
}
