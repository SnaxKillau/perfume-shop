package kh.edu.rupp.ite.perfume_shop.api.service

import kh.edu.rupp.ite.perfume_shop.api.model.Product
import kh.edu.rupp.ite.perfume_shop.api.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductApiService {
    @GET("/api/product")
    fun loadProductList(): Call<ProductResponse>

}