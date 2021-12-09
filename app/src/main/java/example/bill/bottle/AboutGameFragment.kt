package example.bill.bottle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AboutGameFragment : Fragment() {

    lateinit var aboutGameRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_about_game, container, false)

        val aboutGameNames: List<String> =
            listOf(getString(R.string.sizov_vasily), getString(R.string.cat_chels))

        aboutGameRecyclerView = view.findViewById(R.id.about_game_recycler_view)
        aboutGameRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        aboutGameRecyclerView.adapter = AboutGameAdapter(aboutGameNames)

        return view
    }


}