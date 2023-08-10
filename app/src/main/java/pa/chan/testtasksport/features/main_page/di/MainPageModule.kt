package pa.chan.testtasksport.features.main_page.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pa.chan.testtasksport.features.main_page.data.MainRepositoryImpl
import pa.chan.testtasksport.features.main_page.domain.MainRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class MainPageModule {

    @Binds
    abstract fun bindsDetailRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository

}