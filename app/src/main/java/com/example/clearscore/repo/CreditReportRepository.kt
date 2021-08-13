package com.example.clearscore.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.clearscore.api.ApiClient
import com.example.clearscore.model.CreditReport
import com.example.clearscore.service.CreditReportService
import kotlinx.coroutines.*

class CreditReportRepository(
    private val apiService: CreditReportService = ApiClient.getCreditReportService(),
    private val dispatcher: CoroutineDispatcher
) {

    val creditReport = MutableLiveData<CreditReport?>()

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("", "$exception handled!")
    }

    init {
        CoroutineScope(dispatcher + handler).launch {
            kotlin.runCatching {
                fetchCreditReport()
            }
        }
    }

    suspend fun fetchCreditReport() = withContext(dispatcher) {
        val response = apiService.getCreditReport()
        if (response.isSuccessful && response.body() != null) {
            creditReport.postValue(response.body())
        } else {
            creditReport.postValue(null)
        }
    }
}