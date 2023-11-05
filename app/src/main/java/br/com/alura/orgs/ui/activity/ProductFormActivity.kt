package br.com.alura.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProductDao
import br.com.alura.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity :
    AppCompatActivity(R.layout.activity_product_form) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saveBtnConfig()
    }

    private fun saveBtnConfig() {
        val saveBtn = findViewById<Button>(R.id.activity_product_form_save_button)
        val productDao = ProductDao()
        saveBtn.setOnClickListener {
            val newProduct = createProduct()
            productDao.addProduct(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        val nameField = findViewById<EditText>(R.id.activity_product_form_name)
        val name = nameField.text.toString()
        val descField = findViewById<EditText>(R.id.activity_product_form_description)
        val description = descField.text.toString()
        val priceField = findViewById<EditText>(R.id.activity_product_form_price)
        val txtPrice = priceField.text.toString()
        val price = if (txtPrice.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(txtPrice)
        }


        return Product(
            name = name,
            description = description,
            price = price
        )
    }

}