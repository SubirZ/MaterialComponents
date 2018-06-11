package com.ddd.materialcomponents.ui.activity

import android.os.Bundle
import android.os.Handler
import android.support.design.bottomappbar.BottomAppBar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ddd.materialcomponents.R
import com.ddd.materialcomponents.ui.fragment.DetailsFragment
import com.ddd.materialcomponents.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by S.C. on 09/06/18.
 */
class HomeActivity : AppCompatActivity() {
    private val handler: Handler = Handler()
    var one : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flContainerHome, HomeFragment.newInstance())
                    .commit()
        }
        initView()
    }

    private fun initView() {
        setSupportActionBar(bottomAppBar)
    }

    override fun onBackPressed() {
        if (getCurrentFragment() is DetailsFragment) {
            detachFab()
            returnToHome()
        }
        super.onBackPressed()
    }

    private fun getCurrentFragment(): Fragment {
        return supportFragmentManager.findFragmentById(R.id.flContainerHome)
    }

    fun detachFab() {
        bottomAppBar.isFabAttached = false
    }

    fun moveToDetails() {
        bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        attachFab()
    }

    private fun returnToHome() {
        bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        attachFab()
    }

        private fun attachFab() {
            val runnable = Runnable {
                bottomAppBar.isFabAttached = true
            }
            handler.postDelayed(runnable, 150)
        }
}