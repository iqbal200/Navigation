package id.co.mka.belajarbuttonnavigation.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class kategoryEntity (

    val id : Int,
    val category_name : String,
    val category_picture : String
    ): Parcelable