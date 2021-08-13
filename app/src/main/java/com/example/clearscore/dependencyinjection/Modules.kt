package com.example.clearscore.dependencyinjection

import com.example.clearscore.api.ApiClient
import com.example.clearscore.api.ApiClient.Companion.BASE_URL
import com.example.clearscore.repo.CreditReportRepository
import com.example.clearscore.service.CreditReportService
import com.example.clearscore.viewmodel.CreditReportViewModel
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        CreditReportViewModel(get())
    }
}

val creditReportRepoModule = module {
    single {
        CreditReportRepository(get(), get())
    }
}

val apiModule = module {
    fun provideApi(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    single { provideApi(get()) }
}

val coroutineScopeModule = module {
    single {
        Dispatchers.IO
    }
}

val retrofitModule = module {
    fun retrofit(baseUrl: String) = Retrofit.Builder()
        .callFactory(OkHttpClient.Builder().build())
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun okHttp() = OkHttpClient.Builder()
        .build()

    single {
        okHttp()
    }
    single {
        retrofit(BASE_URL)
    }
    single {
        get<Retrofit>().create(CreditReportService::class.java)
    }
}