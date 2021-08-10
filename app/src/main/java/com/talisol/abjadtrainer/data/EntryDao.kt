package com.talisol.abjadtrainer.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.talisol.abjadtrainer.model.Entry

interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: Entry)

    @Update
    suspend fun updateUser(user: Entry)

    @Delete
    suspend fun deleteUser(user: Entry)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Entry>>


}