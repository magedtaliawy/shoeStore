package com.example.shoestore_starter.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_starter.modeks.Shoe
import kotlin.math.log

class ShoeViewModel : ViewModel() {
    private val _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    fun addShoe(shoe:Shoe){
        _shoesList.value?.add(shoe)
    }

}