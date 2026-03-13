package com.elionet.ecommerceappmvvm.data.repository

import android.util.Log
import com.elionet.ecommerceappmvvm.data.dataSource.local.ShoppingBagLocalDataSource
import com.elionet.ecommerceappmvvm.data.mapper.toEntity
import com.elionet.ecommerceappmvvm.data.mapper.toShoppingBagProduct
import com.elionet.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.elionet.ecommerceappmvvm.domain.repository.ShoppingBagRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ShoppingBagRepositoryImpl(private val localDataSource: ShoppingBagLocalDataSource): ShoppingBagRepository {

    override suspend fun add(product: ShoppingBagProduct) {
        CoroutineScope(Dispatchers.IO).launch{
            val shoppingBag = localDataSource.findById(product.id)
            if(shoppingBag == null){

                Log.d("ShoppingBagRepositoryImpl", "Creando datos")

                localDataSource.insert(product.toEntity())
            }
            else{

                Log.d("ShoppingBagRepositoryImpl", "Actualizando datos")

                localDataSource.update(product.id, product.quantity)
            }
        }
    }

    override suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    override fun findAll(): Flow<List<ShoppingBagProduct>> = flow {
        localDataSource.findAll().collect(){
            emit(it.map { product -> product.toShoppingBagProduct() })
        }
    }

    override fun findById(id: String): ShoppingBagProduct {

        Log.d("ShoppingBagRepositoryImpl", "findById: $id")

        val data = runBlocking(context = Dispatchers.IO) {
            localDataSource.findById(id).toShoppingBagProduct()
        }
        return data
    }
}