package example.bill.bottle


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AboutGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val aboutGameTextView: TextView =
        itemView.findViewById(R.id.about_game_text_view)

    fun bind(name: String) {
        aboutGameTextView.text = name
    }
}