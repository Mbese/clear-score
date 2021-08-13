package com.example.clearscore.api

import com.example.clearscore.service.CreditReportService
import org.junit.Assert.assertTrue
import org.junit.Test

class ApiClientTest {
    @Test
    fun `test getCreditReportService returns correct instance` () {
        assertTrue(CreditReportService::class.java.isInstance(ApiClient.getCreditReportService()))
    }
}