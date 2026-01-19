package com.elionet.ecommerceappmvvm.di

import android.util.Log
import com.elionet.ecommerceappmvvm.core.Config
import com.elionet.ecommerceappmvvm.data.datastore.AuthDataStore
import com.elionet.ecommerceappmvvm.data.service.AuthService
import com.elionet.ecommerceappmvvm.data.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetwortModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(datastore: AuthDataStore) = OkHttpClient.Builder().addInterceptor {

        val token = runBlocking {
            datastore.getData().first().token
        }

        Log.d("NetwortModule", "Token recuperado: $token") // Añade esto para debug

        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {   //POSTMAN - THUNDER CLIENT - RETROFIT
        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }
}