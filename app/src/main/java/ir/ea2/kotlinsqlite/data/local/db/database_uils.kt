package ir.ea2.kotlinsqlite.data.local.db

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

interface ContentValuesUpdater<T>{
    fun updateContentValues(entity:T , contentValue:ContentValues)
}

interface CursorConverter<T>{
    fun cursorToList(cursor: Cursor, db:SQLiteDatabase):List<T>
}
