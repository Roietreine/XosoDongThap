package rich.igop.dongthapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rich.igop.dongthapp.data.Data
import rich.igop.dongthapp.R
import rich.igop.dongthapp.databinding.ItemMainMenuBinding

class MainAdapter(
    private val listener: NavigationListener
): RecyclerView.Adapter<MainAdapter.Holder>() {

    val data = Data.data.filterIndexed { index, _ -> index < 4 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_main_menu, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val newData = data[position]
        with(holder.binding){
            menuIcon.setBackgroundResource(newData.icon)
            root.setOnClickListener { listener.onPageClick(position + 1) }
        }
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            ItemMainMenuBinding.bind(itemView)
        }
    }
}