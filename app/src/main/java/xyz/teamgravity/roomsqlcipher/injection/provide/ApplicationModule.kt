package xyz.teamgravity.roomsqlcipher.injection.provide

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.teamgravity.roomsqlcipher.data.local.constant.FootballerConst
import xyz.teamgravity.roomsqlcipher.data.local.dao.FootballerDao
import xyz.teamgravity.roomsqlcipher.data.local.database.FootballerDatabase
import xyz.teamgravity.roomsqlcipher.data.repository.FootballerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideFootballerDatabase(application: Application): FootballerDatabase =
        Room.databaseBuilder(application, FootballerDatabase::class.java, FootballerConst.NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideFootballerDao(footballerDatabase: FootballerDatabase): FootballerDao = footballerDatabase.footballerDao()

    @Provides
    @Singleton
    fun provideFootballerRepository(footballerDao: FootballerDao): FootballerRepository = FootballerRepository(footballerDao)
}