package com.azstudio.kotlinsample.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.azstudio.kotlinsample.adapters.SampleDataListAdapter
import com.azstudio.kotlinsample.application.SampleApplication

import com.azstudio.kotlinsample.databinding.ActivityViewListBinding
import com.azstudio.kotlinsample.entities.SampleData
import com.azstudio.kotlinsample.viewModel.SampleViewModel
import com.azstudio.kotlinsample.viewModel.SampleViewModelFactory

class ViewListActivity : AppCompatActivity() {
    private val sampleViewModel: SampleViewModel by viewModels {
        SampleViewModelFactory((application as SampleApplication).repository)
    }

    private lateinit var binding: ActivityViewListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        sampleViewModel.allSampleList.observe(this) { sampleData ->
            sampleData.let {
                for (item in it) {

                    Log.e("Check List", "" + item.sampleText + item.primaryId)
                }
                setAdapter(it)
            }
        }


    }

    private fun setAdapter(sampleDataList: List<SampleData>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvSampleDataList.setLayoutManager(layoutManager)
        val rvAdapter = SampleDataListAdapter(sampleDataList)
        binding.rvSampleDataList.adapter = rvAdapter
    }
}