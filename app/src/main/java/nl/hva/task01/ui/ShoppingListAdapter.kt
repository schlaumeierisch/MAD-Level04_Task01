package nl.hva.task01.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nl.hva.task01.R
import nl.hva.task01.databinding.ItemProductBinding
import nl.hva.task01.model.Product

class ShoppingListAdapter(private val shoppingList: List<Product>): RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemProductBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun databind(product: Product) {
            binding.tvProductQuantity.text = product.productQuantity.toString() + "X"
            binding.tvProductName.text = product.productName
        }
    }

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return shoppingList.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(shoppingList[position])
    }
}