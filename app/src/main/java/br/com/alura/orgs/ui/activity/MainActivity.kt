package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Product
import br.com.alura.orgs.ui.recyclerview.adapter.ProductsListAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(
    R.layout.activity_main
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = "Fruits Basket"
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Orange, Grape and Apple"
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = "19.99"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ProductsListAdapter(context = this, products = listOf(
            Product(
                name = "teste 1",
                description = "teste desc 1",
                price = BigDecimal("19.99")
            ),
            Product(
                name = "teste 2",
                description = "teste desc 2",
                price = BigDecimal("29.99")
            ),
            Product(
                name = "teste 3",
                description = "teste desc 3",
                price = BigDecimal("39.99")
            ),
        ))

        //recyclerView.layoutManager = LinearLayoutManager(this)

    }

}