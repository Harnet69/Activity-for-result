package com.harnet.activityforresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harnet.activityforresult.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.successBtn.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        binding.failBtn.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED)
        finish()
    }

}