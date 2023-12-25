package kh.edu.rupp.ite.perfume_shop.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import kh.edu.rupp.ite.perfume_shop.api.model.ApiData
import kh.edu.rupp.ite.perfume_shop.api.model.Categories
import kh.edu.rupp.ite.perfume_shop.api.model.Login
import kh.edu.rupp.ite.perfume_shop.api.model.Status
import kh.edu.rupp.ite.perfume_shop.api.service.CategoriesApiService
import kh.edu.rupp.ite.perfume_shop.api.service.LoginApiService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginViewModel() : ViewModel() {

     fun login(email:String, password:String){
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val httpClient = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8888")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
         viewModelScope.launch {
             try {
                 val loginApiService: LoginApiService = httpClient.create(LoginApiService::class.java);
                 val task :Login = loginApiService.login(email ,password)
                 Log.d("token" , task.token.toString());
             }
             catch (e:Exception){

                 Log.e("Error" , e.message.toString())
             }
         }


    }
}
