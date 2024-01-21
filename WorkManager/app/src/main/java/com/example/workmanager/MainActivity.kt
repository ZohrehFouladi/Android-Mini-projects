package com.example.workmanager

import android.net.Uri.Builder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import com.example.workmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonBackUp.setOnClickListener() {
            //createOneTimeWorkRequest()
            createPeriodicWorkRequest()
        }
    }

    private fun createOneTimeWorkRequest() {
        val constraints = Constraints
            .Builder()
            //.setRequiresCharging(true)
            //.setRequiredNetworkType(NetworkType.METERED)
            .build()


        val shrinkRequest = OneTimeWorkRequest
            .Builder(ShrinkDB::class.java)
            //.setConstraints(constraints)
            .build()
        val backUpRequest = OneTimeWorkRequest
            .Builder(DBBackUp::class.java)
            //.setConstraints(constraints)
            .build()
        val compressRequest = OneTimeWorkRequest
            .Builder(ZipDB::class.java)
            //.setConstraints(constraints)
            .build()


        // WorkManager.getInstance(applicationContext).enqueue(oneTimeWorkRequest)
        val workManager = WorkManager.getInstance(applicationContext)
        workManager.beginWith(shrinkRequest).then(backUpRequest).then(compressRequest).enqueue()
        workManager.getWorkInfoByIdLiveData(backUpRequest.id)
            .observe(this, {
                binding.textViewReport.text =
                    binding.textViewReport.text.toString() + it.state.name + "\n"
            })


    }

    private fun createPeriodicWorkRequest() {
        val backUpRequest = PeriodicWorkRequest
            .Builder(DBBackUp::class.java, 15, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(backUpRequest)
    }
}