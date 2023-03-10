package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)


        var apiInterface = ApiClient.getApiclient().create(ApiInterface::class.java)
        apiInterface.getusers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {

                    var model: Users = response.body()!!

                    bindings.rcvUsers.layoutManager = GridLayoutManager(this@MainActivity, 1)
                    bindings.rcvUsers.adapter = UsersAdapter(model.users)
                }

            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e(TAG, "onFailure: Faill" + t.message)

            }


        })


    }
}




