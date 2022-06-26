package rich.igop.dongthapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rich.igop.dongthapp.data.Data
import rich.igop.dongthapp.R
import rich.igop.dongthapp.databinding.ItemBottomMenuBinding

class BottomAdapter(
    private val listener: NavigationListener
): RecyclerView.Adapter<BottomAdapter.Holder>() {

    val data = Data.data.filterIndexed{ i, _ -> i >= 4}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_bottom_menu, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val newData = data[position]
        with(holder.binding){
            menuTitle.text = newData.title
            root.setOnClickListener { listener.onPageClick(position + 5) }
        }
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            ItemBottomMenuBinding.bind(itemView)
        }
    }


}