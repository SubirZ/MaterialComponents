package com.ddd.materialcomponents.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ddd.materialcomponents.R
import kotlinx.android.synthetic.main.fragment_credits.*


/**
 * Created by S.C. on 31/05/18.
 */
class CreditsFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_credits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivLinkedIn.setOnClickListener(this)
        ivMedium.setOnClickListener(this)
        ivGithub.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            ivLinkedIn -> openURLinBrowser("https://www.linkedin.com/in/subir-chakraborty-517107b9")
            ivMedium -> openURLinBrowser("https://medium.com/@subir.chakraborty")
            ivGithub -> openURLinBrowser("https://github.com/SubirZ")
        }
    }

    fun openURLinBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}