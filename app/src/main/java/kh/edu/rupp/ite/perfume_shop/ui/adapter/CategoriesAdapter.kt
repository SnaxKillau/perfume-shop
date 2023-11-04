package kh.edu.rupp.ite.perfume_shop.ui.adapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import kh.edu.rupp.ite.perfume_shop.api.model.Categories
import android.view.LayoutInflater
import kh.edu.rupp.ite.perfume_shop.databinding.FragmentCategoriesBinding
import kh.edu.rupp.ite.perfume_shop.databinding.ViewHolderCategoriesBinding



class CategoriesAdapter : ListAdapter<Categories, CategoriesAdapter.CategoriesViewHolder>(
    object : DiffUtil.ItemCallback<Categories>() {
        override fun areItemsTheSame(oldItem: Categories, newItem: Categories): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Categories, newItem: Categories): Boolean {
            return oldItem.id== newItem.id
        }
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderCategoriesBinding.inflate(layoutInflater, parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class CategoriesViewHolder(private val itemBinding: ViewHolderCategoriesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(categories: Categories) {
            itemBinding.txtCategories.text = categories.brandName
        }
    }
}
