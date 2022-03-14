package com.example.crudproduct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudproduct.adapter.ProductAdapter
import com.example.crudproduct.config.ConfigFirebase
import com.example.crudproduct.model.ProductModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var rcView : RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var configFirebase : ConfigFirebase
    private lateinit var dbProduct : DatabaseReference
    private var productList  = ArrayList<ProductModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fabClick()
        rcView = findViewById(R.id.laundry_rc)
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.setHasFixedSize(true)
        getData()
    }

    private fun getData(){
        //progress bar
        val progressBar = findViewById<ProgressBar>(R.id.progressBar_product)
        configFirebase = ConfigFirebase()
        dbProduct = configFirebase.firebaseConfig()

        dbProduct.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                productList.clear()
                configFirebase.showData(productList,snapshot)
                if(productList.isNotEmpty()){
                    progressBar.visibility = View.GONE
                    rcView.adapter = ProductAdapter(this@MainActivity,productList)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"$error",Toast.LENGTH_LONG).show()
            }

        });

    }
    private fun fabClick(){
        fab = findViewById(R.id.fab_new_data)
        fab.setOnClickListener {
            val intent = Intent(this, AddNewData::class.java)
            startActivity(intent)
        }
    }
}