package com.azstudio.kotlinsample.adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azstudio.kotlinsample.databinding.SampleDataInflatorBinding

import com.azstudio.kotlinsample.entities.SampleData

class SampleDataListAdapter(private var mList: List<SampleData>) : RecyclerView.Adapter<SampleDataListAdapter.ViewHolder>(){
    class ViewHolder(val binding:SampleDataInflatorBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(SampleDataInflatorBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.binding.tvSampleText.text= mList[position].sampleText
    }

    override fun getItemCount(): Int {
     return mList.size
    }

}