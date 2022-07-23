package com.example.shoestore_starter.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_starter.modeks.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    fun addShoe(shoe:Shoe){
       _shoesList.value= listOf(shoe)
    }

}