package com.example.crudproduct.config

import com.example.crudproduct.model.ProductModel
import com.example.crudproduct.adapter.ProductAdapter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ConfigFirebase : FirebaseMethod{
    private lateinit var dbReference: DatabaseReference
    private lateinit var db: FirebaseDatabase
    private lateinit var path:String
    fun firebaseConfig() : DatabaseReference{
        db = FirebaseDatabase.getInstance()
        dbReference = db.getReference("product")
        return dbReference
    }
    fun setChild(path:String){
        this.path = path
    }
    override fun addNewData(product: ProductModel?): Task<Void?> {
        return dbReference.child(this.path).setValue(product)
    }

    override fun showData(productList: ArrayList<ProductModel>,snapshot: DataSnapshot) {
        for (datasnap in snapshot.children) {
            val product = datasnap.getValue(ProductModel::class.java)
            productList.add(product!!)
        }
    }

}

