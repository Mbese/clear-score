package com.example.clearscore.api

import com.example.clearscore.service.CreditReportService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        const val BASE_URL = "https://android-interview.s3.eu-west-2.amazonaws.com/"
        private fun getRetrofitInstance(): Retrofit.Builder {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
        }

        fun getCreditReportService(): CreditReportService {
            return getRetrofitInstance().build().create(CreditReportService::class.java)
        }
    }
}