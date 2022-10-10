package nl.hva.task01.repository

import android.content.Context
import nl.hva.task01.dao.ProductDao
import nl.hva.task01.database.ProductRoomDatabase
import nl.hva.task01.model.Product

class ProductRepository(context: Context) {
    private var productDao: ProductDao

    init {
        val productRoomDatabase = ProductRoomDatabase.getDatabase(context)
        productDao = productRoomDatabase!!.productDao()
    }

    suspend fun getAllProducts(): List<Product> = productDao.getAllProducts()

    suspend fun addProduct(product: Product) = productDao.addProduct(product)

    suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)

    suspend fun deleteAllProducts() = productDao.deleteAllProducts()
}