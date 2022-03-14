package com.example.crudproduct.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.crudproduct.R
import com.example.crudproduct.model.ProductModel
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter (private val context: Context, private val productList: ArrayList<ProductModel>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rc, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name_data)
        var address = itemView.findViewById<TextView>(R.id.address_data)

        fun bind(product: ProductModel) {
            name.text = product.getName()
            address.text = product.getAddress()
        }
    }
}