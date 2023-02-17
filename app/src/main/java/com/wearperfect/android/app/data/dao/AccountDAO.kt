package com.wearperfect.android.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wearperfect.android.app.data.model.Account
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDAO {

    @Query("SELECT * FROM accounts LIMIT 1")
    fun getAllAccounts(): Flow<List<Account>>

    @Query("SELECT * FROM accounts WHERE username=:username")
    suspend fun getAccount(username: String): Account

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: Account)

    @Delete
    suspend fun deleteAccount(account: Account)
}