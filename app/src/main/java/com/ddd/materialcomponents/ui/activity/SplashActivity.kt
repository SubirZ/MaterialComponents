package com.ddd.materialcomponents.ui.activity

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ddd.materialcomponents.R
import kotlinx.android.synthetic.main.activity_splash.*
/**
 * Created by S.C. on 25/05/18.
 */
class SplashActivity : AppCompatActivity(), View.OnClickListener {
    var prog: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        animationView.playAnimation()
        animationView.setMinAndMaxProgress(0f, 0.29f)
        fabNext.setOnClickListener(this)
        fabPrevious.setOnClickListener(this)
        setTitle("Relax")
    }

    override fun onClick(view: View?) {
        if (view == fabNext) {
            animationView.speed = 1f
            when (prog) {
                0 -> {
                    animationView.setMinAndMaxFrame(80, 100)
                    prog = 1
                    setTitle("Create")
                }
                1 -> {
                    animationView.setMinAndMaxFrame(159, 175)
                    prog = 2
                    fabNext.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLoginPrimary))
                    setTitle("Work")
                }
                2 -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    return
                }
            }
        } else if (view == fabPrevious) {
            animationView.speed = -1f
            when (prog) {
                2 -> {
                    animationView.setMinAndMaxFrame(159, 175)
                    prog = 1
                    fabNext.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorDribble))
                    setTitle("Create")
                }
                1 -> {
                    animationView.setMinAndMaxFrame(80, 100)
                    prog = 0
                    setTitle("Relax")
                }
                0 -> return
            }
        }
        animationView.playAnimation()
    }

    fun setTitle(title: String): Unit {
        tvTitle.text = title
    }
}