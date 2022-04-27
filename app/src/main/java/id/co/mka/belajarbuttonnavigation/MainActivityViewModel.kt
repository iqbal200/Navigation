package id.co.mka.belajarbuttonnavigation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.mka.belajarbuttonnavigation.data.api.ApiService
import id.co.mka.belajarbuttonnavigation.data.entity.kategoryEntity
import id.co.mka.belajarbuttonnavigation.data.response.CategoryResponse
import id.co.mka.belajarbuttonnavigation.data.response.KategoriRespone
import id.co.mka.belajarbuttonnavigation.data.response.KategoriResponeItem
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
                override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                    val responseResult = response.body()
                    if (response.isSuccessful) {
                        if (responseResult != null) {
                            result.value = responseResult.data?.map {
                                kategoryEntity(
                                    it?.id ?: 0,
                                    it?.categoryName ?: "",
                                    it?.categoryPicture?: "",

                                )
                            }
                        }else {
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

}