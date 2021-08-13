package com.example.clearscore.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CoachingSummary(
    @SerializedName("activeTodo") var activeTodo: Boolean,
    @SerializedName("activeChat") var activeChat: Boolean,
    @SerializedName("numberOfTodoItems") var numberOfTodoItems: Int,
    @SerializedName("numberOfCompletedTodoItems") var numberOfCompletedTodoItems: Int,
    @SerializedName("selected") var selected: Boolean
) : Parcelable