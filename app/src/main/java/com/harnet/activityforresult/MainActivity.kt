package com.harnet.activityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.harnet.activityforresult.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fetchDataFromSecondActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result?.resultCode == Activity.RESULT_OK) {
                binding.secondActivityResult.text = "Success"
            } else {
                binding.secondActivityResult.text = "Fail"
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToSecondBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            fetchDataFromSecondActivity.launch(intent)
        }
    }

}