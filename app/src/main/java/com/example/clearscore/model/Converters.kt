package com.example.clearscore.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    @TypeConverter
    fun toCoachingSummary(coachingSummaryString: String): CoachingSummary {
        val gson = Gson()
        val type: Type = object : TypeToken<CoachingSummary>() {}.type
        return gson.fromJson(coachingSummaryString, type)
    }

    @TypeConverter
    fun fromCoachingSummary(coachingSummary: CoachingSummary): String {
        val gson = Gson()
        val type = object : TypeToken<CoachingSummary>() {}.type
        return gson.toJson(coachingSummary, type)
    }

    @TypeConverter
    fun toCreditReportInfo(creditReportInfoString: String): CreditReportInfo {
        val gson = Gson()
        val type: Type = object : TypeToken<CreditReportInfo>() {}.type
        return gson.fromJson(creditReportInfoString, type)
    }

    @TypeConverter
    fun fromCreditReportInfo(creditReportInfo: CreditReportInfo): String {
        val gson = Gson()
        val type = object : TypeToken<CreditReportInfo>() {}.type
        return gson.toJson(creditReportInfo, type)
    }
}