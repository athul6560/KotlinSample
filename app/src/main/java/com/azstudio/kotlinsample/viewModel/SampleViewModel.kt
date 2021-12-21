package com.azstudio.kotlinsample.viewModel

import androidx.lifecycle.ViewModel
import com.azstudio.kotlinsample.repo.SampleRepo

class SampleViewModel(private val repo: SampleRepo) : ViewModel() {
}