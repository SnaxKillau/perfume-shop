package kh.edu.rupp.ite.perfume_shop.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kh.edu.rupp.ite.perfume_shop.api.model.Product
import kh.edu.rupp.ite.perfume_shop.api.service.ProductApiService
import kh.edu.rupp.ite.perfume_shop.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.perfume_shop.ui.adapter.ProductAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment: Fragment() {
    private lateinit var binding:FragmentHomeBinding;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadProductsFromApi();
    }
    fun loadProductsFromApi(){
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val httpClient = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val productApiService:ProductApiService = httpClient.create(ProductApiService::class.java);
        val task:Call<List<Product>> = productApiService.loadProductList();




        task.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {

                if (response.isSuccessful) {
                    showProductsList(response.body());
                } else {
                    Toast.makeText(context, "Load products list failed!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.e(
                    "[ProductFragment]", "Load products Fail" +
                            ": " + t.message
                )
                t.printStackTrace();
            }
        })

    }
    fun showProductsList(productList: List<Product>?){



         val gridLayoutManager:GridLayoutManager = GridLayoutManager(context, productList?.size!!)
        binding.recyclerView.layoutManager = gridLayoutManager;

        val  productAdapter:ProductAdapter = ProductAdapter();
        productAdapter.submitList(productList)


        binding.recyclerView.adapter = productAdapter;


    }




}