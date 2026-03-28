package com.elionet.ecommerceappmvvm.di

import android.util.Log
import com.elionet.ecommerceappmvvm.core.Config
import com.elionet.ecommerceappmvvm.data.dataSource.local.datastore.AuthDataStore
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.AddressService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.AuthService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.CategoriesService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.MercadoPagoCheckoutService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.MercadoPagoService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.OrdersService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.ProductsService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention
annotation class DefaultRetrofit

@Qualifier
@Retention
annotation class NgrokRetrofit


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
    @DefaultRetrofit
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
    @NgrokRetrofit
    fun provideRetrofitNgrok(okHttpClient: OkHttpClient): Retrofit {   //POSTMAN - THUNDER CLIENT - RETROFIT
        return Retrofit
            .Builder()
            .baseUrl(Config.NGROK_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(@DefaultRetrofit retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersService(@DefaultRetrofit retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoriesService(@DefaultRetrofit retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsService(@DefaultRetrofit retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

    @Provides
    @Singleton
    fun provideAddressService(@DefaultRetrofit retrofit: Retrofit): AddressService {
        return retrofit.create(AddressService::class.java)
    }

    @Provides
    @Singleton
    fun provideMercadoPagoService(@DefaultRetrofit retrofit: Retrofit):  MercadoPagoService{
        return retrofit.create(MercadoPagoService::class.java)
    }

    @Provides
    @Singleton
    fun provideOrdersService(@DefaultRetrofit retrofit: Retrofit):  OrdersService{
        return retrofit.create(OrdersService::class.java)
    }

    @Provides
    @Singleton
    fun provideMercadoPagoCheckoutService(@NgrokRetrofit retrofit: Retrofit):  OrdersService{
        return retrofit.create(OrdersService::class.java)
    }
}
