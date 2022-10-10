package nl.hva.task01.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productTable")
data class Product(
    @ColumnInfo(name = "quantity")
    val productQuantity: Int,

    @ColumnInfo(name = "name")
    val productName: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long? = null
)