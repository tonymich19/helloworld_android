package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProductDao
import br.com.alura.orgs.ui.recyclerview.adapter.ProductsListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductsListActivity : AppCompatActivity(
    R.layout.activity_products_list
) {
    private val productDao = ProductDao()
    private val adapter = ProductsListAdapter(context = this, products = productDao.listAllProducts())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerViewConfig()
    }

    override fun onResume() {
        super.onResume()
        adapter.refresh(productDao.listAllProducts())
        fabConfig()
    }

    private fun fabConfig() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_products_list_fab)
        fab.setOnClickListener {
            importToForm()
        }
    }

    private fun importToForm() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }

    private fun recyclerViewConfig() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_products_list_recyclerView)
        recyclerView.adapter = adapter
    }

}