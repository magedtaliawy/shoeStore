package com.example.shoestore_starter.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clicks()
    }

    private fun clicks() {
        binding.apply {
            loginBtn.setOnClickListener { findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()) }
            signUpBtn.setOnClickListener { findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()) }
        }

    }

}