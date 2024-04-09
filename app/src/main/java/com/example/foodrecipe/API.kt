package com.example.foodrecipe

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface API {
    @GET("recipes/complexSearch")
    @Headers("X-RapidAPI-Key:UygwA3LnI1mshAPcqbrTdu6rvUkxp1Kd1q6jsnETjeLq2t3LzS", "X-RapidAPI-Host:spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
    fun getRecipe(@Query("query")query:String,@Query("equipment")equipment:String,@Query("addRecipeInformation")addRecipeInformation
    :Boolean,@Query("type")type:String): Call<APIResult>


    companion object{
        var BASE_URL="https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/"



        fun create():API {
            val retrofit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(API::class.java)

        }

    }



}