package com.example.clearscore.viewmodel

import androidx.lifecycle.ViewModel
import com.example.clearscore.repo.CreditReportRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class CreditReportViewModelTest {
    private lateinit var viewModel: CreditReportViewModel
    @Mock
    private lateinit var creditReportRepository: CreditReportRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        viewModel = CreditReportViewModel(creditReportRepository)
    }

    @Test
    fun `test CreditReportViewModel is instance of ViewModel` () {
        assertTrue(ViewModel::class.java.isInstance(viewModel))
    }

    @Test
    fun `test that CreditReportViewModel calls through to the repo to get credit report` () {
        viewModel.creditReport
        verify(creditReportRepository).creditReport
    }
}