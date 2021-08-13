package com.example.clearscore.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.clearscore.model.CoachingSummary
import com.example.clearscore.model.CreditReport
import com.example.clearscore.model.CreditReportInfo
import com.example.clearscore.service.CreditReportService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations.initMocks
import retrofit2.Response

class CreditReportRepositoryTest {
    @Mock
    private lateinit var mockService: CreditReportService
    private lateinit var creditReportRepository: CreditReportRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        initMocks(this)

        creditReportRepository =
            CreditReportRepository(mockService, Dispatchers.Unconfined)

    }

    @Test
    fun `test fetchCreditReport updates LiveData`() {
        runBlocking {
            `when`(mockService.getCreditReport()).thenReturn(Response.success(getMockData()))
            creditReportRepository.fetchCreditReport()
        }
        assertNotNull(creditReportRepository.creditReport.value)
    }

    @Test
    fun `test when the service call to fetch credit record is unsuccessful then LiveData is updated with null` () {
        runBlocking {
            `when`(mockService.getCreditReport()).thenReturn(Response.error(403,  ResponseBody.create(
                "type".toMediaTypeOrNull(), "")))
            creditReportRepository.fetchCreditReport()
        }

        assertNull(creditReportRepository.creditReport.value)
    }

    @Test
    fun `test when the service call to fetch credit record is return a success with an empty body then LiveData is updated with null` () {
        runBlocking {
            `when`(mockService.getCreditReport()).thenReturn(Response.success(null))
            creditReportRepository.fetchCreditReport()
        }

        assertNull(creditReportRepository.creditReport.value)
    }

    private fun getMockData(): CreditReport {
        return createCreditReport()
    }

    private fun createCreditReport(): CreditReport {
        return CreditReport(
            "PASS", CreditReportInfo(
                23, 0, "ref",
                "status", 500, 0, 0, false, 0,
                false, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, "credit",
                "utilization", 0, 0, 0, 0,
                "description", 0
            ), "PASS", "INEXPERIENCED", CoachingSummary(
                false, false, 0, 0, false
            ), "null"
        )
    }

}