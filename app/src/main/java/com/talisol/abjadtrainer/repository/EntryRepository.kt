package com.talisol.abjadtrainer.repository

import androidx.lifecycle.LiveData
import com.talisol.abjadtrainer.data.EntryDao
import com.talisol.abjadtrainer.model.Entry

class EntryRepository (private val userDao: EntryDao) {

    val readAllData: LiveData<List<Entry>> = userDao.readAllData()

    suspend fun addUser(user: Entry){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: Entry){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: Entry){

        userDao.deleteUser(user)

    }


}