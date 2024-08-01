package com.itdepartment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.itdepartment.R
import com.itdepartment.adapters.CourseAdapter
import com.itdepartment.adapters.DirectoryAdapter
import com.itdepartment.databinding.FragmentCoursesBinding
import com.itdepartment.databinding.FragmentDirectoryBinding
import com.itdepartment.models.Course
import com.itdepartment.models.Faculty


class CoursesFragment : Fragment() {
    lateinit var mBinding: FragmentCoursesBinding
    private var db: FirebaseFirestore? = null
    private var adapter: CourseAdapter? = null
    private var list: MutableList<Course>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentCoursesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvCourses.adapter

        db = FirebaseFirestore.getInstance()
        list = ArrayList()
        adapter = CourseAdapter(list as MutableList<Course>)
        mBinding.rvCourses.layoutManager = GridLayoutManager(activity, 1, GridLayoutManager.VERTICAL, false)

        mBinding.rvCourses.adapter = adapter
        showData()

    }


    fun showData() {
        db?.collection("courses")?.get()
            ?.addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                list?.clear()
                for (snapshot in task.result) {
                    val course = Course(
                        snapshot.getString("code"),
                        snapshot.getString("title"),
                        snapshot.getLong("credits"),
                        snapshot.getString("pre_requisites"),
                        snapshot.getString("description"),
                        snapshot.getString("id")
                    )
                    list?.add(course)
                }
                adapter?.notifyDataSetChanged()
            })?.addOnFailureListener(OnFailureListener {
                Toast.makeText(
                    activity,
                    "Oops ... something went wrong",
                    Toast.LENGTH_SHORT
                ).show()
            })
    }
}