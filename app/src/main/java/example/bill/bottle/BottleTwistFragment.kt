package example.bill.bottle

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt


class BottleTwistFragment : Fragment() {

    private lateinit var bottleImageView: ImageView

    private val buttonImageList: List<Int> = listOf(
        R.drawable.bottle_1,
        R.drawable.bottle_2,
        R.drawable.bottle_3,
        R.drawable.bottle_4,
        R.drawable.bottle_5,
        R.drawable.bottle_6
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bottle_twist, container, false)

        bottleImageView = view.findViewById(R.id.bottle_image_view)
        bottleImageView.setOnClickListener {
            bottleImageView.setImageResource(buttonImageList.random())

            val randomFlick = Random.nextInt(1..3)
            val textFlick =
                if (randomFlick == 1) randomFlick.toString() + getString(R.string.flick_one)
                else randomFlick.toString() + getString(R.string.flick_text)

            val toastFlick = Toast.makeText(activity, textFlick, Toast.LENGTH_SHORT)
            toastFlick.setGravity(Gravity.AXIS_PULL_AFTER, 0, 450)
            toastFlick.show()
        }
        return view
    }

}