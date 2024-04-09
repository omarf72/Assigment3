package com.example.foodrecipe

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodrecipe.databinding.FragmentFoodDetailBinding


/**
 * A simple [Fragment] subclass.
 * Use the [FoodDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FoodDetailFragment : Fragment() {

    var foodId: Int=0

    private var _binding:FragmentFoodDetailBinding?=null

    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentFoodDetailBinding.inflate(inflater, container, false)
        val view=binding.root

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle=arguments
        if(bundle==null){
            Log.e("FoodDetailFragment","FoodDetailFragment did not receive id")

            return
        }

        foodId=FoodDetailFragmentArgs.fromBundle(bundle).foodId

        //id=FoodDetailFramentArgs.fromBundle(bundle).id
    }



    @SuppressLint("CheckResult")
    override  fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.title.text= recipeList.get(foodId).title
        binding.addRecipeInformation
            .text= recipeList.get(foodId).summary.toString()
        Glide.with(requireContext()).load(recipeList.get(foodId).image)
            .apply(RequestOptions().centerCrop())
            .into(binding.itemImage)


    }



}