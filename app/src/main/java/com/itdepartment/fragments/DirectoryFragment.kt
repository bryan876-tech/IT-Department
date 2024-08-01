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
import com.itdepartment.adapters.DirectoryAdapter
import com.itdepartment.databinding.FragmentDirectoryBinding
import com.itdepartment.models.Faculty

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DirectoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DirectoryFragment : Fragment() {
    lateinit var mBinding: FragmentDirectoryBinding
    private var db: FirebaseFirestore? = null
    private var adapter: DirectoryAdapter? = null
    private var list: MutableList<Faculty>? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentDirectoryBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvDirectory.adapter

        db = FirebaseFirestore.getInstance()
        list = ArrayList()
        adapter = DirectoryAdapter(list as MutableList<Faculty>)
        mBinding.rvDirectory.layoutManager = GridLayoutManager(activity, 1, GridLayoutManager.VERTICAL, false)

        mBinding.rvDirectory.adapter = adapter
        showData()

    }


    fun showData() {
        db?.collection("faculty")?.get()
            ?.addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                list?.clear()
                for (snapshot in task.result) {
                    val faculty = Faculty(
                        snapshot.getString("name"),
                        snapshot.getString("email"),
                        snapshot.getString("phone"),
                        snapshot.getString("photo"),
                        snapshot.getString("id")
                    )
                    list?.add(faculty)
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