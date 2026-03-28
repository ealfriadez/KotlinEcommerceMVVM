package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.CardTokenBody
import com.elionet.ecommerceappmvvm.domain.model.CardTokenResponse
import com.elionet.ecommerceappmvvm.domain.model.IdentificationType
import com.elionet.ecommerceappmvvm.domain.model.Installment
import com.elionet.ecommerceappmvvm.domain.model.PaymentBody
import com.elionet.ecommerceappmvvm.domain.model.PaymentResponse
import com.elionet.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRepository {

    fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>>
    fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse>
}