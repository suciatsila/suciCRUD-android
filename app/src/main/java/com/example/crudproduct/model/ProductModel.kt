package com.example.crudproduct.model

class ProductModel {
    private lateinit var id:String
    private lateinit var name:String
    private lateinit var address:String

    fun setId(id:String){
        this.id = id
    }
    fun getId() : String{
        return this.id
    }
    fun setName(name:String){
        this.name = name;
    }
    fun  getName(): String {
        return this.name;
    }
    fun setAddress(address:String){
        this.address = address;
    }
    fun getAddress(): String{
        return this.address;
    }
}