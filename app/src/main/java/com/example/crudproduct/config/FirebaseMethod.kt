package com.example.crudproduct.config

import com.example.crudproduct.model.ProductModel
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface FirebaseMethod {
    fun addNewData(product: ProductModel?): Task<Void?>?
    fun showData(productList : ArrayList<ProductModel>,snapshot: DataSnapshot)
}

