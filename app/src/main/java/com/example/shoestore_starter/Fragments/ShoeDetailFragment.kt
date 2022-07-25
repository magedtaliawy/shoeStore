package com.example.shoestore_starter.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.ViewModel.ShoeViewModel
import com.example.shoestore_starter.databinding.FragmentShoeDetailBinding
import com.example.shoestore_starter.modeks.Shoe

class ShoeDetailFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailBinding
    lateinit var viewModel:ShoeViewModel
    lateinit var currentShoe:Shoe
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        currentShoe=Shoe("",0.0,"","")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.shoe=currentShoe

        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            )
        }
        binding.saveBtn.setOnClickListener { goToShoeList() }
    }

    private fun goToShoeList() {
        if (dataIsValid()) {
            viewModel.addShoe(currentShoe)
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            )
        }
    }

    private fun dataIsValid(): Boolean {
        if (currentShoe.name.isEmpty()) {
            binding.shoeNameEt.error = getString(R.string.error)
            return false
        }
        if (currentShoe.company.isEmpty()) {
            binding.shoeCompanyEt.error = getString(R.string.error)
            return false
        }
        if (currentShoe.size.toString().isEmpty()) {
            binding.shoeSizeEt.error = getString(R.string.error)
            return false
        }
        if (currentShoe.description.isEmpty()) {
            binding.descriptionEt.error = getString(R.string.error)
            return false
        }
        return true
    }
}