package id.co.mka.belajarbuttonnavigation.data.api

import id.co.mka.belajarbuttonnavigation.data.response.BestSellerResponse
import id.co.mka.belajarbuttonnavigation.data.response.CategoryResponse

import retrofit2.http.GET

interface ApiService {

    // API get Category
    @GET("/api/category")
    fun getCategory(): retrofit2.Call<CategoryResponse>

    // API get BestSeller
    @GET("/api/category")
    fun getBestSeller(): retrofit2.Call<BestSellerResponse>

}