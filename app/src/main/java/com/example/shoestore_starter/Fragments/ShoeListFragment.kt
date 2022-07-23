package com.example.shoestore_starter.Fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FragmentShoeListBinding
import com.example.shoestore_starter.databinding.ItemShoeBinding
import com.example.shoestore_starter.modeks.Shoe


class ShoeListFragment : Fragment() {

    lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addShoeBtn.setOnClickListener {
            findNavController().navigate(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            )
        }

        val args=ShoeListFragmentArgs.fromBundle(requireArguments())
        if (args.shoe!=null){
//            addShoe(args.shoe)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)

    }

    fun addShoe(shoe: Shoe) {
        val viewGroup = view as ViewGroup
        var shoeBinding: ItemShoeBinding =
            ItemShoeBinding.inflate(LayoutInflater.from(requireContext()), viewGroup, false)

        shoeBinding.shoeNameTv.text = shoe.name
        shoeBinding.shoeCompanyTv.text = shoe.company
        shoeBinding.shoeSizeTv.text = shoe.size.toString()
        shoeBinding.shoeDescriptionTv.text = shoe.description
        binding.shoeListLinear.addView(shoeBinding.root)
    }
}