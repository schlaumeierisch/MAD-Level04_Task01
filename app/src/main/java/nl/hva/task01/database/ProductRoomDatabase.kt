package nl.hva.task01.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nl.hva.task01.dao.ProductDao
import nl.hva.task01.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductRoomDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "PRODUCT_DATABASE"

        @Volatile
        private var productRoomDatabaseInstance: ProductRoomDatabase? = null

        fun getDatabase(context: Context): ProductRoomDatabase? {
            if (productRoomDatabaseInstance == null) {
                synchronized(ProductRoomDatabase::class.java) {
                    if (productRoomDatabaseInstance == null) {
                        productRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            ProductRoomDatabase::class.java, DATABASE_NAME
                        ).build()
                    }
                }
            }
            return productRoomDatabaseInstance
        }
    }
}