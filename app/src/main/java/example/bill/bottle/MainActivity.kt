package example.bill.bottle

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigationrail.NavigationRailView

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

   private lateinit var bottomNavigationView: NavigationRailView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->

            var fragment: Fragment? = null
            val intentView:Intent

            when (item.itemId) {
                R.id.twist_bottle -> {
                    fragment = BottleTwistFragment()
                }

                R.id.share -> {
                    intentView = Intent(Intent.ACTION_SEND)
                    intentView.type = "type/plain"
                    val shareBody = "You are body "
                    val shareSub = "You subject here "
                    intentView.putExtra(Intent.EXTRA_SUBJECT, shareBody)
                    intentView.putExtra(Intent.EXTRA_TEXT, shareSub)
                    startActivity(Intent.createChooser(intentView,getString(R.string.share_app)))
                    fragment = BottleTwistFragment()

                }

                R.id.many -> {
                    intentView = Intent(Intent.ACTION_VIEW, Uri.parse("https://sberbank.ru"))
                    startActivity(intentView)
                    fragment = BottleTwistFragment()
                }

                R.id.website -> {
                    intentView = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
                    startActivity(intentView)
                    fragment = BottleTwistFragment()
                }

                R.id.about -> {
                    fragment = AboutGameFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }
        bottomNavigationView.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.twist_bottle
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}