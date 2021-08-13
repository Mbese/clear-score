package com.example.clearscore.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CreditReportInfo(
    @SerializedName("score") var score: Int,
    @SerializedName("scoreBand") var scoreBand: Int,
    @SerializedName("clientRef") var clientRef: String,
    @SerializedName("status") var status: String,
    @SerializedName("maxScoreValue") var maxScoreValue: Int,
    @SerializedName("minScoreValue") var minScoreValue: Int,
    @SerializedName("monthsSinceLastDefaulted") var monthsSinceLastDefaulted: Int,
    @SerializedName("hasEverDefaulted") var hasEverDefaulted: Boolean,
    @SerializedName("monthsSinceLastDelinquent") var monthsSinceLastDelinquent: Int,
    @SerializedName("hasEverBeenDelinquent") var hasEverBeenDelinquent: Boolean,
    @SerializedName("percentageCreditUsed") var percentageCreditUsed: Int,
    @SerializedName("percentageCreditUsedDirectionFlag") var percentageCreditUsedDirectionFlag: Int,
    @SerializedName("changedScore") var changedScore: Int,
    @SerializedName("currentShortTermDebt") var currentShortTermDebt: Int,
    @SerializedName("currentShortTermNonPromotionalDebt") var currentShortTermNonPromotionalDebt: Int,
    @SerializedName("currentShortTermCreditLimit") var currentShortTermCreditLimit: Int,
    @SerializedName("currentShortTermCreditUtilisation") var currentShortTermCreditUtilisation: Int,
    @SerializedName("changeInShortTermDebt") var changeInShortTermDebt: Int,
    @SerializedName("currentLongTermDebt") var currentLongTermDebt: Int,
    @SerializedName("currentLongTermNonPromotionalDebt") var currentLongTermNonPromotionalDebt: Int,
    @SerializedName("currentLongTermCreditLimit") var currentLongTermCreditLimit: String,
    @SerializedName("currentLongTermCreditUtilisation") var currentLongTermCreditUtilisation: String,
    @SerializedName("changeInLongTermDebt") var changeInLongTermDebt: Int,
    @SerializedName("numPositiveScoreFactors") var numPositiveScoreFactors: Int,
    @SerializedName("numNegativeScoreFactors") var numNegativeScoreFactors: Int,
    @SerializedName("equifaxScoreBand") var equifaxScoreBand: Int,
    @SerializedName("equifaxScoreBandDescription") var equifaxScoreBandDescription: String,
    @SerializedName("daysUntilNextReport") var daysUntilNextReport: Int
) : Parcelable