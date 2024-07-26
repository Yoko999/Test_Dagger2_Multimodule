package com.yoequilibrium.multimoduledagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yoequilibrium.multimoduledagger.data.Database
import javax.inject.Inject

class TasksActivity : AppCompatActivity() {
    @Inject
    lateinit var database:Database// = Database()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.injectTasksActivity(this)
    }
}