package pa.chan.testtasksport.features.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    companion object {
//        24741799d6920e3f13fce4cf8779fc092a460ea6ada78db0bb8de3e4d6dadacc
        private const val url = "https://apiv2.allsportsapi.com/basketball"

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}