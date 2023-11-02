package kh.edu.rupp.ite.perfume_shop.api.service

import kh.edu.rupp.ite.perfume_shop.api.model.Categories
import retrofit2.Call
import retrofit2.http.GET

interface CategoriesApiService {


    @GET("/product")
    fun loadCategoriesList(): Call<List<Categories>>
}