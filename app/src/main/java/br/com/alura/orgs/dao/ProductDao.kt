package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Product

class ProductDao {

    fun addProduct(product: Product){
        products.add(product)
    }

    fun listAllProducts() : List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }

}