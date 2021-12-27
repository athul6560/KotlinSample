package com.azstudio.kotlinsample.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.azstudio.kotlinsample.R
import com.azstudio.kotlinsample.application.SampleApplication
import com.azstudio.kotlinsample.viewModel.SampleViewModel
import com.azstudio.kotlinsample.viewModel.SampleViewModelFactory

class ViewListActivity : AppCompatActivity() {
    private val sampleViewModel: SampleViewModel by viewModels {
        SampleViewModelFactory((application as SampleApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list)
        sampleViewModel.allSampleList.observe(this){
            sampleData->
            sampleData.let {
                for(item in it){
                    Log.e("Check List", ""+item.sampleText+item.primaryId )
                }
            }
        }
    }
}