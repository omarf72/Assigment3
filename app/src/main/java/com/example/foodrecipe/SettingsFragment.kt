package com.example.foodrecipe

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodrecipe.databinding.FragmentSettingsBinding




/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {

    private  var _binding :FragmentSettingsBinding? =null
    private val binding get()= _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.blackButton.setOnClickListener{
            applyBlackgroundColor(Color.BLACK)

        }

        binding.whiteButton.setOnClickListener{
            applyBlackgroundColor(Color.WHITE)
        }

        return view


    }


    fun applyBlackgroundColor(color :Int)
    {
        getActivity()?.getWindow()?.getDecorView()?.setBackgroundColor(color)
    }






}