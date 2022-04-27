package id.co.mka.belajarbuttonnavigation.data.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class DataItem(

	@field:SerializedName("category_picture")
	val categoryPicture: String? = null,

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
