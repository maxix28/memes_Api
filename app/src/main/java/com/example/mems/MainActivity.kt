package com.example.mems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mems.adapter.RvAdapter
import com.example.mems.data.RetofitInstance
import com.example.mems.databinding.ActivityMainBinding
import com.example.mems.models.Meme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private  lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch (Dispatchers.IO){
            val response =try{
                RetofitInstance.api.getMemes()
            }catch (e:Exception){
                Toast.makeText(this@MainActivity,"error ${e.message}",Toast.LENGTH_SHORT).show()
return@launch
            }


            if(response.isSuccessful && response.body()!=null){
                withContext(Dispatchers.Main){
                    val memesList : List<Meme> = response.body()!!.data.memes

                     println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
                    println(memesList)
                    binding.apply {
                        rvAdapter= RvAdapter(memesList)
                        rvMemes.adapter=rvAdapter
                        rvMemes.layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
                    }
                }
            }
            else{
                println("?????????????????????????????????????????????")
            }
        }

    }
}