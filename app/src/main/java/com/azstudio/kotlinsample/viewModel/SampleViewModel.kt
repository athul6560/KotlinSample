package com.azstudio.kotlinsample.viewModel

import androidx.lifecycle.*
import com.azstudio.kotlinsample.entities.SampleData
import com.azstudio.kotlinsample.repo.SampleRepo
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class SampleViewModel(private val repo: SampleRepo) : ViewModel() {
    fun insertSampleData(sampleData: SampleData) = viewModelScope.launch {
        repo.insertSampleData(sampleData)
    }

    val allSampleList:LiveData<List<SampleData>> = repo.allSampleData.asLiveData()
}






class SampleViewModelFactory(private val repo: SampleRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SampleViewModel::class.java)) {

            return SampleViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }



}