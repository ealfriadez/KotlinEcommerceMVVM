package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository
import com.elionet.ecommerceappmvvm.domain.repository.CategoriesRepository
import com.elionet.ecommerceappmvvm.domain.repository.ProductsRepository
import com.elionet.ecommerceappmvvm.domain.repository.UsersRepository
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.GetSessionDataUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.LogoutUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.RegisterUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.SaveSessionUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.UpdateSessionUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.categories.CategoriesUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.categories.CreateCategoryUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.categories.DeleteCategoryUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.categories.GetCategoriesUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.categories.UpdateCategoryUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.categories.UpdateCategoryWithImageUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.products.CreateProductUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.products.DeleteProductUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.products.FindAllUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.products.FindByCategoryUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.products.ProductsUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.products.UpdateProductUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.products.UpdateProductWithImageUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.users.UpdateUserUserCase
import com.elionet.ecommerceappmvvm.domain.useCase.users.UpdateUserWithImageCase
import com.elionet.ecommerceappmvvm.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUserCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageCase(usersRepository)
    )

    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository) = CategoriesUseCase(
        createCategory = CreateCategoryUseCase(categoriesRepository),
        getCategories = GetCategoriesUseCase(categoriesRepository),
        updateCategory = UpdateCategoryUseCase(categoriesRepository),
        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoriesRepository),
        deleteCategory = DeleteCategoryUseCase(categoriesRepository)
    )

    @Provides
    fun provideProductsUseCase(productsRepository: ProductsRepository) = ProductsUseCase(
        createProduct = CreateProductUseCase(productsRepository),
        findAll = FindAllUseCase(productsRepository),
        findByCategory = FindByCategoryUseCase(productsRepository),
        updateProduct = UpdateProductUseCase(productsRepository),
        updateProductWithImageUseCase = UpdateProductWithImageUseCase(productsRepository),
        deleteProduct = DeleteProductUseCase(productsRepository)
    )
}