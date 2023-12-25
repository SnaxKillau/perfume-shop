package kh.edu.rupp.ite.perfume_shop.api.model

data class Product(
    val id:Number,
    val name:String,
    val image:List<Image>,
    val availableUnit:Number,
    val brandName:String

)
data class ProductResponse(
    val data: List<Product>
)

