package com.example.project_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = findViewById<RecyclerView>(R.id.recyclerview_container)

        ApiConfig.getService().getData().enqueue(object : Callback<ResponseData>{
            override fun onResponse(call : Call<ResponseData>, response: Response<ResponseData>) {
                if (response.isSuccessful){
                    val responseData = response.body()
                    val demData = responseData?.results
                    val dataAdapter = DataAdapter(demData as List<ResultsItem>)
                    data.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        dataAdapter.notifyDataSetChanged()
                        adapter = dataAdapter
                    }
                }
            }
            override fun onFailure(call: Call<ResponseData>, t: Throwable){
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()

            }
        })


    }
}