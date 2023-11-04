package kh.edu.rupp.ite.perfume_shop.api.service

import kh.edu.rupp.ite.perfume_shop.api.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApiService {
    @GET("/product")
    fun loadProductList(): Call<List<Product>>

}