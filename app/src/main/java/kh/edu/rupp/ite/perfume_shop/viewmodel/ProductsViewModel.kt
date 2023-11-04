package kh.edu.rupp.ite.perfume_shop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import kh.edu.rupp.ite.perfume_shop.api.model.ApiData
import kh.edu.rupp.ite.perfume_shop.api.model.Product
import kh.edu.rupp.ite.perfume_shop.api.model.Status
import kh.edu.rupp.ite.perfume_shop.api.service.ProductApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsViewModel : ViewModel(){

    private val _productData = MutableLiveData<ApiData<List<Product>>>()
    val productData: LiveData<ApiData<List<Product>>>
        get() = _productData
    fun loadProductsFromApi(){
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val httpClient = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val productApiService: ProductApiService = httpClient.create(ProductApiService::class.java);
        val task: Call<List<Product>> = productApiService.loadProductList();




        task.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {

                if (response.isSuccessful) {

                    val apiData = ApiData<List<Product>>(Status.SUCCESS, response.body())
                    _productData.postValue(apiData)
                } else {
                    val apiData = ApiData<List<Product>>(Status.ERROR, response.body())
                    _productData.postValue(apiData)
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                val apiData = ApiData<List<Product>>(Status.ERROR, null)
                _productData.postValue(apiData)

            }
        })

    }

}