package id.co.mka.belajarbuttonnavigation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.co.mka.belajarbuttonnavigation.data.entity.kategoryEntity
import id.co.mka.belajarbuttonnavigation.databinding.ItemKategoriBinding

class cardViewAdapter(
    private val listCategory: ArrayList<kategoryEntity>,
    private val userClickListener: (kategoryEntity) -> Unit
) : RecyclerView.Adapter<cardViewAdapter.UserViewHolder>() {
    inner class UserViewHolder(private val binding: ItemKategoriBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(kategoriItem: kategoryEntity) {
            with(binding) {
                tvNameKategori.text = kategoriItem.category_name
                kategoriItem.category_picture
                Glide.with(imgCategori.context)
                    .load("http://${kategoriItem.category_picture}")
//                    .apply(RequestOptions().override(85, 85))
                    .into(imgCategori)
                Log.e("TAG", "bind: ${kategoriItem.category_picture}", )
                root.setOnClickListener {
                    userClickListener(kategoriItem)
                }

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            ItemKategoriBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) {
        userViewHolder.bind(listCategory[position])
    }

    override fun getItemCount(): Int = listCategory.size


}
