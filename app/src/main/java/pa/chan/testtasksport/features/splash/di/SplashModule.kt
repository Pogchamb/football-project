package pa.chan.testtasksport.features.splash.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pa.chan.testtasksport.features.core.AppDataBase
import pa.chan.testtasksport.features.splash.data.StatisticApi
import pa.chan.testtasksport.features.splash.data.StatisticRepositoryImpl
import pa.chan.testtasksport.features.splash.domain.StatisticRepository
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class SplashModule {

    companion object {

        @Provides
        @Singleton
        fun provideDetailApi(retrofit: Retrofit): StatisticApi =
            retrofit.create(StatisticApi::class.java)

        @Provides
        @Singleton
        fun provideDetailDao(appDataBase: AppDataBase) = appDataBase.statisticDao()

    }

    @Binds
    abstract fun bindsDetailRepository(statisticRepositoryImpl: StatisticRepositoryImpl): StatisticRepository

}