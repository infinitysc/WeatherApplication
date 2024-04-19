package com.pallplication.FragA.ViewGroup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.pallplication.FragA.R

class FragmentList(list : List<Any>) : Fragment() {
    private var listing : List<Any>? = null
    init {
        listing = list
    }
    private var arrayAdapter : ArrayAdapter<Any>? = activity?.let {
        ArrayAdapter(it,R.layout.list_item,listing!!)
    }

    private val fragList : ListView by lazy { requireView().findViewById<ListView>(R.id.list) }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list,container,false)
        fragList.adapter = arrayAdapter


        return view
    }
}