package kh.edu.rupp.ite.perfume_shop.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.perfume_shop.api.model.Product
import kh.edu.rupp.ite.perfume_shop.databinding.ViewHolderHomeProductsBinding

class ProductAdapter:ListAdapter<Product , ProductAdapter.ProductViewHolder>(
    object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }
    }
) {



    class ProductViewHolder(val itemBinding: ViewHolderHomeProductsBinding):RecyclerView.ViewHolder(itemBinding.root){

        fun bind(product: Product){

            val img = product.imagePath;
            Picasso.get().load("http://10.0.2.2:8080/image/$img").into(itemBinding.imgProduct);
            itemBinding.productBrand.text = product.brandName


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context);
        val binding:ViewHolderHomeProductsBinding = ViewHolderHomeProductsBinding.inflate(layoutInflater,parent,false);
        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item:Product = getItem(position)
        holder.bind(item)

    }
}