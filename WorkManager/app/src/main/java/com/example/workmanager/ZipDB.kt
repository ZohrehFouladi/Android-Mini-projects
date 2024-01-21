package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


    class ZipDB(context: Context, workerParameters: WorkerParameters) :
        Worker(context, workerParameters) {
        override fun doWork(): Result {
            return try {
                for (i in 1.. 50000) {
                    Log.i("MyLog", "compressing#${i}")
                }
                Result.success()
            } catch (e: Exception) {
                Result.failure()
            }

        }
    }
