package com.example.clearscore.viewmodel

import androidx.lifecycle.ViewModel
import com.example.clearscore.repo.CreditReportRepository

class CreditReportViewModel(creditReportRepository: CreditReportRepository) : ViewModel() {
    val creditReport = creditReportRepository.creditReport
}