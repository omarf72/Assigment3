package com.example.foodrecipe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


var recipeList = ArrayList<Result>()
var nutrientsList= ArrayList<Nutrition>()



class RecyclerAdapter(val context: Context, var navController :NavController) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerAdapter.MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.food_list,parent,false)
        return MyViewHolder(view,context)

    }


    fun setList(recipeListInput: ArrayList<Result>){

        recipeList=recipeListInput;
        notifyDataSetChanged()
    }

    /*fun setList(nutrientListInput:ArrayList<Nutrition>){
        nutrientsList=nutrientListInput
        notifyDataSetChanged()
    }*/


    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    inner class MyViewHolder(itemView: View, private val context: Context)
        : RecyclerView.ViewHolder(itemView){
        private val imagePic: ImageView =itemView.findViewById<ImageView>(R.id.image)
        private val name: TextView=itemView.findViewById <TextView>(R.id.name)

        private var pos:Int=0


        init {
            itemView.setOnClickListener{
                val action=HomeFragmentDirections.actionHomeFragmentToFoodDetailFragment(pos)
                navController.navigate(action)
            }
        }


        fun bind(position: Int){
            pos=position
            val currentFood= recipeList.get(position)
            name.text=currentFood.title
            Glide.with(context).load(recipeList[position].image)
                .apply(RequestOptions().override(300,300))
                .apply(RequestOptions().centerCrop())
                .into(imagePic)
        }
    }


}




