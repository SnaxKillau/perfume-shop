package kh.edu.rupp.ite.perfume_shop.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import kh.edu.rupp.ite.perfume_shop.api.model.ApiData
import kh.edu.rupp.ite.perfume_shop.api.model.Categories
import kh.edu.rupp.ite.perfume_shop.api.model.Status
import kh.edu.rupp.ite.perfume_shop.api.service.CategoriesApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoriesViewModel: ViewModel() {

    private val _categoriesdata = MutableLiveData<ApiData<List<Categories>>>()

    val categoriesdata: LiveData<ApiData<List<Categories>>>
        get() = _categoriesdata

    fun loadCategories(){
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val httpClient = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()


        val categoriesApiService: CategoriesApiService = httpClient.create(CategoriesApiService::class.java);
        val task: Call<List<Categories>> = categoriesApiService.loadCategoriesList();

        task.enqueue(object : Callback<List<Categories>> {
            override fun onResponse(
                call: Call<List<Categories>>,
                response: Response<List<Categories>>
            ) {
                if (response.isSuccessful){

                    val apiData = ApiData<List<Categories>>(Status.SUCCESS, response.body())
                    _categoriesdata.postValue(apiData)
                }else {
                    val apiData = ApiData<List<Categories>>(Status.ERROR, response.body())
                    _categoriesdata.postValue(apiData)
                }
            }

            override fun onFailure(call: Call<List<Categories>>, t: Throwable) {

                val apiData = ApiData<List<Categories>>(Status.ERROR, null)
                _categoriesdata.postValue(apiData)
            }
        })
    }
}