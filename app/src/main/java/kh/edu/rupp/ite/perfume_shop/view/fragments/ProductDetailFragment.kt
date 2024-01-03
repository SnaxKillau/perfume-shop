package kh.edu.rupp.ite.perfume_shop.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.perfume_shop.api.model.Product
import kh.edu.rupp.ite.perfume_shop.api.model.Status
import kh.edu.rupp.ite.perfume_shop.databinding.FragementProductDetailBinding
import kh.edu.rupp.ite.perfume_shop.databinding.FragmentCategoriesBinding
import kh.edu.rupp.ite.perfume_shop.viewmodel.ProductDetailViewModel

class ProductDetailFragment: Fragment {

    private lateinit var binding: FragementProductDetailBinding
    private val productDetailViewModel = ProductDetailViewModel();
    private var id: Int = 0;

    // Default (empty) constructor
    constructor() : super()

    // Constructor with id parameter
    constructor(id: Int) : this() {
        this.id = id
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragementProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productDetailViewModel.loadProductDetail(id);
        productDetailViewModel.productData.observe(viewLifecycleOwner) {
            when(it.status) {
                Status.PROCESSING-> Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                Status.SUCCESS -> {
                    val data = it.data
                    if (data != null) {

                        // Additional handling of the data if needed
                        showProduct(it.data.data)
                    } else {
                        Log.d("Data12222", "Data is null")
                    }
                }
                Status.ERROR -> Toast.makeText(requireContext(), "Error while loading data from server", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun showProduct(product: List<Product>){
        binding.productBrand.text = product[0].brand
        binding.productName.text = product[0].name
        binding.productPrice.text = product[0].price.toString()
        binding.type.text = product[0].type;
        binding.productDescription.text = product[0].decription
        val imageUrl: String? = product[0].image.firstOrNull()?.url
        Log.d("img" , imageUrl.toString())
        Picasso.get().load("http://10.0.2.2:8888/images/$imageUrl")
            .into(binding.imgProduct);
    }
}