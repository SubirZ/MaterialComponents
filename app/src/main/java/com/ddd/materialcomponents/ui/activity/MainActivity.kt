package com.ddd.materialcomponents.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.ddd.materialcomponents.R
import com.ddd.materialcomponents.ui.fragment.LoginFragment

/**
 * Created by S.C. on 20/05/18.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flContainer, LoginFragment.newInstance())
                    .commit()
        }
    }
}
