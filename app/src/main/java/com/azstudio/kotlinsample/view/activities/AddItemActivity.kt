package com.azstudio.kotlinsample.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.azstudio.kotlinsample.R
import com.azstudio.kotlinsample.application.SampleApplication
import com.azstudio.kotlinsample.entities.SampleData
import com.azstudio.kotlinsample.viewModel.SampleViewModel
import com.azstudio.kotlinsample.viewModel.SampleViewModelFactory

class AddItemActivity : AppCompatActivity() {
    private val sampleViewModel: SampleViewModel by viewModels {
        SampleViewModelFactory((application as SampleApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        val sample = SampleData(
            "sadff"

        )
        sampleViewModel.insertSampleData(sample)
    }
}
