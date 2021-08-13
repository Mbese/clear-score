package com.example.clearscore.service

import com.example.clearscore.model.CreditReport
import retrofit2.Response
import retrofit2.http.GET

interface CreditReportService {
    @GET("endpoint.json")
    suspend fun getCreditReport(): Response<CreditReport>
}