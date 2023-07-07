package com.example.growighapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import java.util.*

private var images: MutableList<ImageData> = mutableListOf()

class MainActivity3 : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var recyclerviewAdapter: RecyclerviewAdapter
    private lateinit var refreshLayout: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        recyclerview=findViewById(R.id.recyclerview)
        refreshLayout=findViewById(R.id.refreshLayout)
        refreshLayout.setOnRefreshListener {
            getImages()
        }
        recyclerview.layoutManager= LinearLayoutManager(this)
        recyclerviewAdapter= RecyclerviewAdapter()
        recyclerview.adapter= recyclerviewAdapter
        getImages()
    }
    private fun getImages(){
        val url = "https://picsum.photos/v2/list?limit=500"
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                // Parse the JSON response and populate the list of ImageData objects
                for (i in 0 until response.length()) {
                    val jsonObject = response.getJSONObject(i)
                    val author = jsonObject.getString("author")
                    val url = jsonObject.getString("download_url")
                    val imageData = ImageData(url, author)
                    images.add(imageData)
                }
                val randomImages = mutableListOf<ImageData>()

                val random = Random()
                while (randomImages.size < 10) {
                    val randomIndex = random.nextInt(images.size)
                    val randomImage = images[randomIndex]
                    randomImages.add(randomImage)
                    images.removeAt(randomIndex)
                }
                // Notify the adapter that the data set has changed
                recyclerviewAdapter.setImages(randomImages)
                refreshLayout.isRefreshing = false
            },
            { error ->
                Toast.makeText(this, "Error fetching data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        // Add the request to the Volley request queue
        Volley.newRequestQueue(this).add(jsonArrayRequest)

    }


}