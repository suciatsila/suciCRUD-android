package com.example.crudproduct

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crudproduct.config.ConfigFirebase
import com.google.android.material.textfield.TextInputEditText
import com.example.crudproduct.model.ProductModel
import com.example.crudproduct.util.GenerateString

class AddNewData : AppCompatActivity() {
    private lateinit var modelProduct: ProductModel
    private lateinit var configFirebase: ConfigFirebase
    private lateinit var saveBtn: Button
    private lateinit var inputName: TextInputEditText
    private lateinit var inputAddress: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_data)
        //
        initForm()
        configFirebase = ConfigFirebase()
        configFirebase.firebaseConfig()
        saveData()
    }

    private fun initForm() {
        inputName = findViewById(R.id.txt_name)
        inputAddress = findViewById(R.id.txt_address)
    }

    private fun saveData() {
        saveBtn = findViewById(R.id.btn_save)
        saveBtn.setOnClickListener {
            val randomStr = GenerateString.randomString(10)
            configFirebase.setChild(randomStr)
            modelProduct = ProductModel()
            modelProduct.setId(randomStr)
            modelProduct.setName(inputName.text.toString())
            modelProduct.setAddress(inputAddress.text.toString())

            //
            configFirebase.addNewData(modelProduct).addOnSuccessListener {
                Toast.makeText(this, "Success add new data", Toast.LENGTH_LONG).show()
                goToMainAct()
            }.addOnFailureListener {
                Toast.makeText(this, "Fail : $it", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun goToMainAct() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}