package com.pallplication.FragA

import com.pallplication.FragA.Logic.Controller.Controller
import com.pallplication.FragA.Network.DataStorage.Station.sta.RequestStat.RequestStation
import com.pallplication.FragA.Network.Retrofit.RetrofitClientCreator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkEnqueueRequest(){

    }

    @Test
    fun checkRetrofitAsync(){
        val reqTest = RetrofitClientCreator().getApi()
        println(reqTest)
    }


    @Test
    fun checkController(){
        val c_test = Controller("NO0035A")

        val model = c_test.getModel()
    }

}