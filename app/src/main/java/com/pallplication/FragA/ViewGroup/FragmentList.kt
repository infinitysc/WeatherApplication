package com.pallplication.FragA.ViewGroup

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.pallplication.FragA.Network.DataStorage.Station.AirQuiality.Variables
import com.pallplication.FragA.R


class FragmentList(): Fragment() {


    private lateinit var mList : List<String>
    private lateinit var mListVariables : List<Variables>

    private val mRecyclerView : RecyclerView by lazy { requireView().findViewById(R.id.recyclerWidget)}
    private lateinit var activityContext : Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContext = context
        Log.d("AttachToScreen","Fragment is attached")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val newBundle = this.arguments?.getBundle("bundleFromActivity")
        Log.d("BundleFragment","$newBundle")
        var flagTest : Boolean = false
        if(newBundle != null){
            mList = Gson().fromJson(newBundle.getString("string"),Array<String>::class.java).toList()
            mListVariables = Gson().fromJson(newBundle.getString("stringVariables"),Array<Variables>::class.java).toList().also {
                Log.d("BundleInFragment","True,${it[0]}")
            }
            mRecyclerView.adapter = RecyclerList(mListVariables,mList)
            mRecyclerView.layoutManager = LinearLayoutManager(this.context)
            mRecyclerView.setHasFixedSize(true)

        }
        else{
            Log.e("NullPointerExceptionInFragmentList","Bundle is null")
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list,container,false)


        return view
    }

    companion object {
        fun newInstance(bundle_ : Bundle) : FragmentList {

            val args = Bundle()
            args.putBundle("bundleFromActivity",bundle_)
            val fragment = FragmentList()
            fragment.arguments = args
            return fragment
        }
    }

}