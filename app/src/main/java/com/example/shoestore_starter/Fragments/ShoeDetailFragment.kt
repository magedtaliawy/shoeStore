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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            )
        }
        binding.saveBtn.setOnClickListener { goToShoeList() }
    }

    private fun goToShoeList() {
        if (dataIsValid()) {
            val shoeName = binding.shoeNameEt.text.toString()
            val shoeSize: Double = (binding.shoeSizeEt.text.toString()).toDouble()
            val shoeCompany = binding.shoeCompanyEt.text.toString()
            val description = binding.descriptionEt.text.toString()
            val shoeModel = Shoe(shoeName, shoeSize, shoeCompany, description)
            viewModel.addShoe(shoeModel)
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            )
        }
    }

    private fun dataIsValid(): Boolean {
        if (binding.shoeNameEt.text.isEmpty()) {
            binding.shoeNameEt.error = getString(R.string.error)
            return false
        }
        if (binding.shoeCompanyEt.text.isEmpty()) {
            binding.shoeCompanyEt.error = getString(R.string.error)
            return false
        }
        if (binding.shoeSizeEt.text.isEmpty()) {
            binding.shoeSizeEt.error = getString(R.string.error)
            return false
        }
        if (binding.descriptionEt.text.isEmpty()) {
            binding.descriptionEt.error = getString(R.string.error)
            return false
        }
        return true
    }
}