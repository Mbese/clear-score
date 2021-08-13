package com.example.clearscore.view

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.clearscore.R
import com.example.clearscore.databinding.ActivityMainBinding
import com.example.clearscore.viewmodel.CreditReportViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private val viewModel by inject<CreditReportViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        fetchCreditRecord()

        binding?.retryButton?.setOnClickListener {
            fetchCreditRecord()
        }
    }

    private fun fetchCreditRecord(){
        viewModel.creditReport.observe(this, Observer {
            if (it == null ){
                binding?.progressBar?.visibility = View.GONE
                binding?.text?.visibility = View.GONE
                binding?.errorView?.visibility = View.VISIBLE
            } else {
                val creditScoreInfo = it.creditReportInfo
                binding?.progressBar?.max = creditScoreInfo.maxScoreValue
                binding?.maxScoreText?.text = String.format(
                    resources.getString(
                        R.string.max_score,
                        creditScoreInfo.maxScoreValue.toString()
                    )
                )
                startAnimationCounter(creditScoreInfo.minScoreValue, creditScoreInfo.score)
            }
        })
    }

    private fun startAnimationCounter(minScore: Int, maxScore: Int) {
        val animator = ValueAnimator.ofInt(minScore, maxScore)
        animator.duration = 5000
        animator.addUpdateListener {
            binding?.minScore?.text = it.animatedValue.toString()
            binding?.progressBar?.progress = it.animatedValue.toString().toInt()
        }
        animator.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}