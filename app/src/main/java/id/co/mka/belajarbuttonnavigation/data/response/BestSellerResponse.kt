package id.co.mka.belajarbuttonnavigation.data.response

import com.google.gson.annotations.SerializedName

data class BestSellerResponse(

	@field:SerializedName("data")
	val data: List<Any?>? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)
