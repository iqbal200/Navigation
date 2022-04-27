package id.co.mka.belajarbuttonnavigation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.mka.belajarbuttonnavigation.data.api.ApiService
import id.co.mka.belajarbuttonnavigation.data.entity.bestSellerEntity
import id.co.mka.belajarbuttonnavigation.data.entity.kategoryEntity
import id.co.mka.belajarbuttonnavigation.data.response.BestSellerResponse
import id.co.mka.belajarbuttonnavigation.data.response.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    fun getCategory(
        apiService: ApiService,
    ): LiveData<List<kategoryEntity>> {
        val result = MutableLiveData<List<kategoryEntity>>()

        apiService.getCategory()
            .enqueue(object : Callback<CategoryResponse> {
                override fun onResponse(
                    call: Call<CategoryResponse>,
                    response: Response<CategoryResponse>
                ) {
                    val responseResult = response.body()
                    if (response.isSuccessful) {
                        if (responseResult != null) {
                            result.value = responseResult.data?.map {
                                kategoryEntity(
                                    it?.id ?: 0,
                                    it?.categoryName ?: "",
                                    it?.categoryPicture ?: "",

                                    )
                            }
                        } else {
                            result.value = listOf()
                        }

                    }

                }

                override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                    Log.e("Kategory Respone", "onFailure: ${t.message}", t)
                }
            })
        return result
    }

    fun getBestseller(
        apiService: ApiService,
    ): LiveData<List<bestSellerEntity>> {
        val result = MutableLiveData<List<bestSellerEntity>>()

        apiService.getBestSeller()
            .enqueue(object : Callback<BestSellerResponse> {
                override fun onResponse(
                    call: Call<BestSellerResponse>,
                    response: Response<BestSellerResponse>
                ) {
                    val responseResult = response.body()
                    if (response.isSuccessful) {
                        bestSellerEntity(
                            responseResult?.statusCode ?: 0,

                            )
                    }
                }

                override fun onFailure(call: Call<BestSellerResponse>, t: Throwable) {
                    Log.e("Kategory Respone", "onFailure: ${t.message}", t)

                }

            }

            )
        return result
    }

}