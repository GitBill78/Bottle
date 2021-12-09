package example.bill.bottle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AboutGameAdapter(private val aboutGameNames: List<String>) :
    RecyclerView.Adapter<AboutGameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutGameViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.about_game_list_item, parent, false)
        return AboutGameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AboutGameViewHolder, position: Int) {
        val name = aboutGameNames[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return aboutGameNames.size
    }
}