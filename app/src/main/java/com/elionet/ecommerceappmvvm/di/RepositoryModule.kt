package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.data.dataSource.local.AddressLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSource
import com.elionet.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.UsersRepositoryImpl
import com.elionet.ecommerceappmvvm.data.dataSource.local.AuthLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.local.CategoriesLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.local.ProductsLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.local.ShoppingBagLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.AddressRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.CategoriesRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.OrdersRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.ProductsRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.UsersRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.MercadoPagoCheckoutService
import com.elionet.ecommerceappmvvm.data.repository.AddressRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.CategoriesRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.MercadoPagoCheckoutRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.MercadoPagoRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.OrdersRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.ProductsRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.ShoppingBagRepositoryImpl
import com.elionet.ecommerceappmvvm.domain.repository.AddressRepository
import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository
import com.elionet.ecommerceappmvvm.domain.repository.CategoriesRepository
import com.elionet.ecommerceappmvvm.domain.repository.MercadoPagoCheckoutRepository
import com.elionet.ecommerceappmvvm.domain.repository.MercadoPagoRepository
import com.elionet.ecommerceappmvvm.domain.repository.OrdersRepository
import com.elionet.ecommerceappmvvm.domain.repository.ProductsRepository
import com.elionet.ecommerceappmvvm.domain.repository.ShoppingBagRepository
import com.elionet.ecommerceappmvvm.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideCategoriesRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
        categoriesLocalDataSource: CategoriesLocalDataSource
    ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource, categoriesLocalDataSource)

    @Provides
    fun provideProductsRepository(
        productsRemoteDataSource: ProductsRemoteDataSource,
        productsLocalDataSource: ProductsLocalDataSource
    ): ProductsRepository = ProductsRepositoryImpl(productsRemoteDataSource, productsLocalDataSource)

    @Provides
    fun provideShoppingBagRepository(
        shoppingBagLocalDataSource: ShoppingBagLocalDataSource
    ): ShoppingBagRepository = ShoppingBagRepositoryImpl(shoppingBagLocalDataSource)

    @Provides
    fun provideAddressBagRepository(
        addressRemoteDataSource: AddressRemoteDataSource,
        addressLocalDataSource: AddressLocalDataSource
    ): AddressRepository = AddressRepositoryImpl(addressRemoteDataSource, addressLocalDataSource)

    @Provides
    fun provideMercadoPagoRepository(
        mercadoPagoRemoteDataSource: MercadoPagoRemoteDataSource
    ): MercadoPagoRepository = MercadoPagoRepositoryImpl(mercadoPagoRemoteDataSource)

    @Provides
    fun provideOrdersRepository(
        ordersRemoteDataSource: OrdersRemoteDataSource
    ): OrdersRepository = OrdersRepositoryImpl(ordersRemoteDataSource)

    @Provides
    fun provideMercadoPagoCheckoutRepository(
        mercadoPagoCheckoutService: MercadoPagoCheckoutService
    ): MercadoPagoCheckoutRepository = MercadoPagoCheckoutRepositoryImpl(mercadoPagoCheckoutService)
}