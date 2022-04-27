package id.co.mka.belajarbuttonnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.mka.belajarbuttonnavigation.data.entity.kategoryEntity
import id.co.mka.belajarbuttonnavigation.data.retrofit.RetrofitBuilder
import id.co.mka.belajarbuttonnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        with(binding) {

            viewModel.getCategory(RetrofitBuilder.getRetrofit(this@MainActivity.applicationContext))
                .observe(this@MainActivity) {

                    val adapter = cardViewAdapter(it as ArrayList<kategoryEntity>)
                    KategoryRecyclerView.adapter = adapter
                    KategoryRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
        }

    }
}