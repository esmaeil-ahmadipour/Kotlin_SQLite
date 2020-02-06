package ir.ea2.kotlinsqlite.data.local.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// in this class we specify the database structure.(Tables / fields & ...)
class AppDatabase(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    //for easy use of database information in the App , we define variables as Companion Object .
    companion object {
        private const val DATABASE_NAME = "test.db"
        private const val DATABASE_VERSION = 3

        //Table "Team" Database:
        const val TEAM_TABLE = "teams"
        const val TEAM_ID = "id"
        const val TEAM_NAME = "name"
        const val TEAM_GROUND = "ground"
        const val TEAM_MANAGER = "manager"


        //Table "Player" Database:
        const val PLAYER_TABLE = "players"
        const val PLAYER_ID = "id"
        const val PLAYER_NAME = "name"
        const val PLAYER_TEAM_ID = "team_id"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //If Invalid Tables Then Create Tables.For Create Tables Should Be Write Query.
        db!!.execSQL(
            "CREATE TABLE IF NOT EXISTS $TEAM_TABLE (" +
                    "$TEAM_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$TEAM_NAME TEXT," +
                    "$TEAM_GROUND TEXT," +
                    "$TEAM_MANAGER TEXT)"
        )

        db.execSQL(
            "CREATE TABLE IF NOT EXISTS $PLAYER_TABLE (" +
                    "$PLAYER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$PLAYER_NAME TEXT," +
                    "$PLAYER_TEAM_ID INTEGER, " +
                    "FOREIGN KEY ($PLAYER_TEAM_ID) REFERENCES $TEAM_TABLE($TEAM_ID))"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //When We Doing Changes , Then This Method Check DatabaseVersion If Has NewVersion , Doing Upgrades.
        // Write ChangeVersion Conditions
        if (oldVersion < 2) {
            upgradeVersion2()
        } else if (oldVersion < 3) {
            upgradeVersion3(db)
        }

    }

    fun upgradeVersion2() {
    }

    fun upgradeVersion3(db: SQLiteDatabase?) {
        //We Can set Default Value for Column "TEAM_MANAGER":
        //Set Query "SELECT *"  For Old Data And Update Column "TEAM_MANAGER" To EmptyStringValue .

        db!!.execSQL("ALTER TABLE $TEAM_TABLE ADD COLUMN $TEAM_MANAGER TEXT")
    }

}

