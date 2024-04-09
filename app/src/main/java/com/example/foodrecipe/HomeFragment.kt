package com.example.foodrecipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipe.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var recycleView: RecyclerView
    private lateinit var recycleAdapter: RecyclerAdapter

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val view = binding?.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView = (_binding!!).recyleview
        recycleAdapter = RecyclerAdapter(requireContext(), Navigation.findNavController(view))
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.adapter = recycleAdapter

        Log.d("api"," api")
        val apiInterface = API.create().getRecipe("pasta","pan",true,"main course")


        if (apiInterface != null) {
            apiInterface.enqueue(object : Callback<APIResult> {

                override fun onResponse(call: Call<APIResult>, response: Response<APIResult>) {
                    Log.d("in onResponse","onResponse")
                    if (response != null) {
                        Log.d("Main activity", response.body().toString())
                    }
                    if (response?.body() != null) {
                        recycleAdapter.setList(response.body()!!.results!! as ArrayList<Result>)
                    }
                }
                override fun onFailure(call: Call<APIResult>, t: Throwable) {
                    if (t != null) {
                        Toast.makeText(
                            requireContext(), t.message,
                            Toast.LENGTH_LONG
                        ).show()
                        t.message?.let {
                            Log.d("onFailure", it)
                        }
                    }

                }


            })
        }

    }
}
