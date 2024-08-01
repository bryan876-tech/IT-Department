package com.itdepartment.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itdepartment.R
import com.itdepartment.activities.SocialMediaViewActivity
import com.itdepartment.databinding.FragmentAdmissionsBinding
import com.itdepartment.databinding.FragmentSocialMediaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SocialMediaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SocialMediaFragment : Fragment() {
    lateinit var mBinding: FragmentSocialMediaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentSocialMediaBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.btnFacebook.setOnClickListener { openSocialMedia(0) }
        mBinding.btnTwitter.setOnClickListener { openSocialMedia(1) }
        mBinding.btnInstagram.setOnClickListener { openSocialMedia(2) }

    }

    private fun openSocialMedia(type: Int) {
        val bundle = Bundle()

        val url = when (type) {
            1 -> bundle.putString("url","https://x.com/UCCjamaica")
            2 -> bundle.putString("url","https://www.instagram.com/uccjamaica")
            else -> bundle.putString("url","https://www.facebook.com/uccjamaica")
        }
        val intent = Intent(context,SocialMediaViewActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}