package xyz.teamgravity.roomsqlcipher.injection.provide

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SupportFactory
import xyz.teamgravity.roomsqlcipher.core.util.FootballerRandom
import xyz.teamgravity.roomsqlcipher.data.local.constant.FootballerConst
import xyz.teamgravity.roomsqlcipher.data.local.dao.FootballerDao
import xyz.teamgravity.roomsqlcipher.data.local.database.FootballerDatabase
import xyz.teamgravity.roomsqlcipher.data.local.database.FootballerPassphrase
import xyz.teamgravity.roomsqlcipher.data.repository.FootballerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideFootballerPassphrase(application: Application): FootballerPassphrase = FootballerPassphrase(application)

    @Provides
    @Singleton
    fun provideSupportFactory(footballerPassphrase: FootballerPassphrase): SupportFactory =
        SupportFactory(footballerPassphrase.getPassphrase())

    @Provides
    @Singleton
    fun provideFootballerDatabase(application: Application, supportFactory: SupportFactory): FootballerDatabase =
        Room.databaseBuilder(application, FootballerDatabase::class.java, FootballerConst.NAME)
            .openHelperFactory(supportFactory)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideFootballerDao(footballerDatabase: FootballerDatabase): FootballerDao = footballerDatabase.footballerDao()

    @Provides
    @Singleton
    fun provideFootballerRandom(): FootballerRandom = FootballerRandom()

    @Provides
    @Singleton
    fun provideFootballerRepository(footballerDao: FootballerDao, footballerRandom: FootballerRandom): FootballerRepository =
        FootballerRepository(dao = footballerDao, random = footballerRandom)
}