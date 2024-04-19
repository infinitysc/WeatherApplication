package com.pallplication.FragA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.pallplication.FragA.Logic.Controller.Controller
import com.pallplication.FragA.Logic.Model.Model
import com.pallplication.FragA.Network.DataStorage.Station.sta.RequestStat.RequestStation
import com.pallplication.FragA.Network.DataStorage.Station.sta.Station

//fragment retrofit + okhttp + coroutine


open class MainActivity : AppCompatActivity() {

    private var model : Model? = null
    private var controller : Controller? = null
    private var getSpinnerStation : String? = null
    private var getSpinnerAreaclass : String? = null
    private var getInputLan : String? = null
    private var getInputLon : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val allName : MutableList<String> = mutableListOf<String>("nothing",).also { itMutList : MutableList<String> ->
            getListInActivity().forEach(){itStation : Station->
                itMutList.add(itStation.eoi!!)
            }
        }
        //Choose station spinner
        var selectedText : String? = null
        val spinnerViewClass : android.widget.Spinner = findViewById(R.id.stationSpinner)
        val arrayAdapterSpinner = ArrayAdapter<String>(this,R.layout.spinner,allName)
        spinnerViewClass.adapter= arrayAdapterSpinner
        spinnerViewClass.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedText = allName[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        //choose areaclass spinner
        var data : String? = null
        val spinnerArea : android.widget.Spinner = findViewById(R.id.areaclassSpinner)
        val arrayAdapterSpinnerArea = ArrayAdapter<String>(this,R.layout.spinner, listOf("nothing","grunnkrets","fylke","kommune","delomrade"))
        spinnerArea.adapter = arrayAdapterSpinnerArea
        spinnerArea.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            private val listings = listOf<String>("nothing","grunnkrets","fylke","kommune","delomrade")
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
              data = listings[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        //inputField
        val inputFieldLan = findViewById<TextInputEditText>(R.id.lanInputEditText)
        val inputFieldLon = findViewById<TextInputEditText>(R.id.lonInputEditText)

        val toasterNotify = Toast.makeText(this,"Use either station or lan+lon, not both",Toast.LENGTH_LONG)

        val submitButton = findViewById<Button>(R.id.tapButton)
        submitButton.setOnClickListener(){
            var flag : Int = 0
            getInputLan = inputFieldLan.text.toString()
            getInputLon = inputFieldLon.text.toString()

            getSpinnerStation = selectedText

            getSpinnerAreaclass = data


            if(getSpinnerStation != "nothing"){
                flag = 1
                controller = if(getSpinnerAreaclass !="nothing"){
                    Controller(getSpinnerAreaclass,getSpinnerStation)
                } else{
                    Controller(getSpinnerStation)
                }
            }
            else{
                if (getSpinnerAreaclass == "nothing") {
                    flag = 0
                    val toasterArea = Toast.makeText(this,"change areaclass",Toast.LENGTH_SHORT)
                    toasterArea.show()
                } else {
                    flag = 1
                    controller = Controller(getInputLan,getInputLon,getSpinnerAreaclass)
                }
            }
            if(flag == 1) {
                model = controller?.getModel()
                Log.e("MODEL IS E ","$model")
            }
        }
    }

    private fun getListInActivity() : List<Station> {
        return RequestStation.RetrofitRequest().getList()
    }


}