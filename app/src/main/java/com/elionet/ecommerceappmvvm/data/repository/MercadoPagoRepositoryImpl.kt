package com.elionet.ecommerceappmvvm.data.repository

import com.elionet.ecommerceappmvvm.domain.model.CardTokenBody
import com.elionet.ecommerceappmvvm.domain.model.CardTokenResponse
import com.elionet.ecommerceappmvvm.domain.model.IdentificationType
import com.elionet.ecommerceappmvvm.domain.model.Installment
import com.elionet.ecommerceappmvvm.domain.model.PaymentBody
import com.elionet.ecommerceappmvvm.domain.model.PaymentResponse
import com.elionet.ecommerceappmvvm.domain.repository.MercadoPagoRepository
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.domain.util.ResponseToRequest
import com.elionet.ecommerceappmvvm.data.dataSource.remote.MercadoPagoRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MercadoPagoRepositoryImpl(private val remoteDataSource: MercadoPagoRemoteDataSource): MercadoPagoRepository {
    override fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.getIdentificationTypes()))
    }

    override fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.getInstallments(firstSixDigits, amount)))
    }

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse> = ResponseToRequest.send(
        remoteDataSource.createCardToken(cardTokenBody)
    )

    override suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse> = ResponseToRequest.send(
        remoteDataSource.createPayment(paymentBody)
    )
}