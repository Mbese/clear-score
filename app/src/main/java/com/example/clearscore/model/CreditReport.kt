package com.example.clearscore.model

import com.google.gson.annotations.SerializedName

data class CreditReport(
    @SerializedName("accountIDVStatus") var accountIDVStatus: String,
    @SerializedName("creditReportInfo") var creditReportInfo: CreditReportInfo,
    @SerializedName("dashboardStatus") var dashboardStatus: String,
    @SerializedName("personaType") var personaType: String,
    @SerializedName("coachingSummary") var coachingSummary: CoachingSummary,
    @SerializedName("augmentedCreditScore") var augmentedCreditScore: String
)
