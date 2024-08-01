package com.itdepartment.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.itdepartment.R
import com.itdepartment.adapters.CourseAdapter
import com.itdepartment.databinding.FragmentAdmissionsBinding
import com.itdepartment.databinding.FragmentCoursesBinding
import com.itdepartment.models.Course


class AdmissionsFragment : Fragment() {
    lateinit var mBinding: FragmentAdmissionsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    mBinding = FragmentAdmissionsBinding.inflate(inflater, container, false)
    return mBinding.root
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.txtAdmission1.text = "1. To be unconditionally admitted to complete UCC undergraduate programmes, individuals should possess a minimum of five (5) subjects at the GCE or CSEC level (including the mandatory English Language and Mathematics) at grades A, B, C or 1, 2, 3 respectively. A CSEC pass at level 3 must have been obtained since 1998."
        mBinding.txtAdmission2.text = "2. Candidates who have a minimum of 4 CXCs can also apply pending the outstanding CXC subjects or can opt to do UCC replacement courses Core Mathematics, English for Academic Purpose and Fundamentals of Accounting."
        mBinding.txtAdmission3.text = "3. Candidates can opt to apply under the Mature Entry option. To be accepted, applicants must be working for 5 years or more and be at a minimum age of 25 years. Academic qualifications, a detailed resume, a job letter and 3 professional references will be required."
        mBinding.btnApply.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ucc.edu.jm/apply/undergraduate/preform"))
            startActivity(intent)
        }

    }
}