package com.pallplication.FragA.ViewGroup

import android.content.Context
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.pallplication.FragA.Logic.Controller.Controller
import com.pallplication.FragA.Network.DataStorage.Station.sta.RequestStat.RequestStation
import com.pallplication.FragA.Network.DataStorage.Station.sta.Station
import com.pallplication.FragA.R
import org.w3c.dom.Text

class MainFragment : Fragment() {

    private var bundleFragment : Bundle = Bundle()
    private val activityFragmentManager : FragmentManager by lazy { activity?.supportFragmentManager!! }


    private val spinnerList : MutableList<String> = mutableListOf("nothing").also { itMutList : MutableList<String> ->
        getDataStation().forEach {
            itMutList.add(it.eoi!!)

        }
    }
    private val listAreaClass : List<String> = listOf("nothing","grunnkrets","fylke","kommune","delomrade")

    private lateinit var activityContext : Context
    private lateinit var controller : Controller


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContext = context
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("onCreateView","$this createView")

        return inflater.inflate(R.layout.main_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinnerStation = view.findViewById<Spinner>(R.id.stationSpinner)
        val spinnerAreaClass = view.findViewById<Spinner>(R.id.areaclassSpinner)
        val submitButton = view.findViewById<Button>(R.id.tapButton)
        val latInputText = view.findViewById<TextInputEditText>(R.id.lanInputEditText)
        val lonInputText = view.findViewById<TextInputEditText>(R.id.lonInputEditText)

        Log.i("onViewCreatedViewLog","View - $view")
        Log.d("onViewCreated","$this viewCreated")
        //spinner station
        var selectedTextSpinnerStation = ""
        spinnerStation.adapter = ArrayAdapter(activityContext,R.layout.spinner,spinnerList)
        spinnerStation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedTextSpinnerStation = spinnerList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        //spinner areaclass
        var selectedTextAreaClass = ""
        spinnerAreaClass.adapter = ArrayAdapter(activityContext,R.layout.spinner,listAreaClass)
        spinnerAreaClass.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedTextAreaClass = listAreaClass[position]
            }
        }

        val toastEr = Toast.makeText(activityContext,"Use either station or lan+lon, not both",Toast.LENGTH_SHORT)
        val TAG_INFO_FLAGS = "TAG_INFO_FLAGS"
        var getInputLat : String
        var getInputLon : String
        var getSpinnerStation : String
        var getSpinnerAreaClass : String
        submitButton.setOnClickListener {
            var flag = false
            var flagSpinnerStation = false
            var flagSpinnerAreaClass = false
            var flagLatEditText = false
            var flagLonEditText = false
            getInputLat = latInputText.text.toString().also {
                if (it != "") {
                    flagLatEditText = true
                }
            }
            getInputLon = lonInputText.text.toString().also {
                if (it != "") {
                    flagLonEditText = true
                }
            }
            Log.d(TAG_INFO_FLAGS, "$flagLatEditText , $flagLonEditText")
            getSpinnerStation = selectedTextSpinnerStation.also {
                if (it != "nothing") {
                    flagSpinnerStation = true
                }
            }
            getSpinnerAreaClass = selectedTextAreaClass.also {
                if (it != "nothiing") {
                    flagSpinnerAreaClass = true
                }
            }
            Log.d(TAG_INFO_FLAGS, "${flagSpinnerStation},${flagSpinnerAreaClass}")
            if (flagSpinnerStation && (flagLatEditText || flagLonEditText)) {
                toastEr.show()
            } else {
                flag = buttonLogic(getSpinnerStation, getSpinnerAreaClass, getInputLat, getInputLon)
                if (flag) {
                    val listOfTime = controller.getData().getFromAndTime()[0]
                    val listOfVariables = controller.getData().getVariables()[0]
                    val str = Gson().toJson(listOfTime)
                    val strVar = Gson().toJson(listOfVariables)
                    bundleFragment.putString("string",str)
                    bundleFragment.putString("stringVariables",strVar)
                    activityFragmentManager.beginTransaction()
                        .replace(R.id.mainFrameLayout,FragmentList.newInstance(bundleFragment))
                        .addToBackStack("MainFragment")
                        .commit()
                }
            }
        }

    }

    private fun buttonLogic(
        getSpinnerStation_ : String,
        getSpinnerAreaClass_ : String,
        getLatString_ : String,
        getLonString_ : String,
        ) : Boolean{
        var flag = false
        val toast = Toast.makeText(activityContext,"areaclass is not choose",Toast.LENGTH_SHORT)
        when(getSpinnerStation_ != "nothing") {
            true -> when (getSpinnerAreaClass_ != "nothing") {
                true -> controller = Controller(getSpinnerAreaClass_, getSpinnerStation_).also {
                    flag = true
                }
                false -> controller = Controller(getSpinnerStation_).also {
                    flag = true
                }
            }
            false -> when (getSpinnerAreaClass_ != "nothing") {
                true -> controller = Controller(getLatString_,getLonString_,getSpinnerAreaClass_).also {
                    flag = true
                }
                false -> toast.show().also {
                    flag = false
                }
            }
        }
        return flag
    }
    override fun onStart() {
        super.onStart()
    }


    override fun onStop() {
        super.onStop()
        Log.d("onStop","$this fragment is stopped" )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }


    private fun getDataStation() : List<Station>{
        return RequestStation.RetrofitRequest().getList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("OnViewDestroy","$this fragmentIsDestroy")

    }


    companion object {
        fun newInstance(bundle_ : Bundle) : MainFragment {
            val args = Bundle()
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }

    }
}
