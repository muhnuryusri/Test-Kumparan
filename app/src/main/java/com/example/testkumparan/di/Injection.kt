package com.example.testkumparan.di

import android.content.Context
import com.example.testkumparan.data.remote.PostRepository
import com.example.testkumparan.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): PostRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return PostRepository.getInstance(remoteDataSource)
    }
}