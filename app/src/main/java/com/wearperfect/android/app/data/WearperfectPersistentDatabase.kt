package com.wearperfect.android.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wearperfect.android.app.data.dao.AccountDAO
import com.wearperfect.android.app.data.model.Account
import com.wearperfect.android.app.data.model.User

@Database(
    version = 1,
    exportSchema = false,
    entities = [Account::class, User::class]
)
abstract class WearperfectPersistentDatabase: RoomDatabase() {
    abstract fun getAccountDAO(): AccountDAO
}