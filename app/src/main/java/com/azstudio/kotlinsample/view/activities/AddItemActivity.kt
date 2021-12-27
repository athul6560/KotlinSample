package com.azstudio.kotlinsample.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.azstudio.kotlinsample.Utils.Constants.EXTRA_MESSAGE
import com.azstudio.kotlinsample.application.SampleApplication
import com.azstudio.kotlinsample.databinding.ActivityAddItemBinding
import com.azstudio.kotlinsample.entities.SampleData
import com.azstudio.kotlinsample.viewModel.SampleViewModel
import com.azstudio.kotlinsample.viewModel.SampleViewModelFactory

class AddItemActivity : AppCompatActivity() {

    //creating object of viewModel
    private val sampleViewModel: SampleViewModel by viewModels {
        SampleViewModelFactory((application as SampleApplication).repository)
    }


    //view binding
    private lateinit var binding: ActivityAddItemBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        onClicks()



    }



    private fun onClicks() {
        binding.btnView.setOnClickListener{
            val intent = Intent(this, ViewListActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, "Message to sent to next activity")
            }
            startActivity(intent)
        }



      binding.btnSubmit.setOnClickListener{
          val text = binding.etSampleText.text.toString()
          val sample = SampleData(
              text

          )
          sampleViewModel.insertSampleData(sample)
      }
    }
}
