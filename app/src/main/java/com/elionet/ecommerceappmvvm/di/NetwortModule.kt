package com.elionet.ecommerceappmvvm.di

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.elionet.ecommerceappmvvm.core.Config
import com.elionet.ecommerceappmvvm.data.dataSource.local.datastore.AuthDataStore
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.AuthService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.CategoriesService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.ProductsService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.UsersService
import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
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
    fun provideOkHttpClient(
        datastore: AuthDataStore,
        app: Application
    ) = OkHttpClient.Builder().addInterceptor { chain ->

        val token = runBlocking {
            datastore.getData().first().token
        }

        Log.d("NetwortModule", "Token recuperado: $token") // Añade esto para debug

        val newRequest = chain.request().newBuilder().addHeader("Authorization", token ?: "").build()

        //1.Procederemos con la peticion y guardamos la respuesta
        val response = chain.proceed(newRequest)

        // 2. Validamos si el código es 401 (Token expirado/inválido)
        if (response.code == 401) {
            // Borramos los datos del DataStore para cerrar sesión
            runBlocking {
                datastore.saveUser(AuthResponse()) // Limpiamos la sesión (ajusta según tu modelo)
            }

            // Mostramos el Toast en el hilo principal
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(app, "Sesión expirada. Inicie sesión nuevamente", Toast.LENGTH_LONG).show()
            }
        }

        response // Devolvemos la respuesta original (sea 200, 401, etc.)

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

    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }
}