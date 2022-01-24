package com.example.weathermap.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.weathermap.databinding.FragmentMainBinding
import com.example.weathermap.util.Constants.Companion.API_KEY
import com.example.weathermap.util.Constants.Companion.QUERY_API_KEY
import com.example.weathermap.util.Constants.Companion.QUERY_SEARCH
import com.example.weathermap.viewModel.MainViewModel
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter




class MainFragment : Fragment() {

    //............values
    private lateinit var mainViewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    var city: String = "tokyo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        readApi()




        return view
    }

    @SuppressLint("SetTextI18n")
    private fun readApi() {

        mainViewModel.getWeather(applyQueries())
        mainViewModel.myResponse.observe(viewLifecycleOwner, Observer {

            Log.d("datatest", it.sys.sunrise.toString())
            val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
            val time: String = LocalDateTime.now().dayOfWeek.toString().uppercase()+" "+ LocalTime.now().format(formatter)

            // ? set data to views
            binding.bigNameTxt.text = city[0].uppercase()+city.substring(1)
            binding.timeTxt.text = time
            binding.bigTemTxt.text = ((it.main.temp-273.15).toInt()).toString()+"°C"
            binding.NameTxt.text = city.uppercase()
            binding.hum.text = it.main.humidity.toString()+"%"
            binding.wind.text = it.wind.speed.toString()+"m/s"

            setMapImg(it.coord.lat.toString().toFloat(),it.coord.lon.toString().toFloat())
        })
    }

    private fun setMapImg(clat: Float, clon: Float) {
        // ? use coil

        val ww = 1024
        val hh = 512

        val zoom = 5
        val mode = binding.themeNameTxt.text

        val url = "https://api.mapbox.com/styles/v1/mapbox/"+ mode +"-v9/static/" +
                clon + "," + clat + "," + zoom + "/" +
                ww + "x" + hh +
                "?access_token=pk.eyJ1IjoibWl0bzIwMDMiLCJhIjoiY2t5N2N4Y2N4MDdzajJvbGp6cTV3Z211byJ9.1Zx7fdH3vx1BCepLE8safA"

        binding.mapImg.load(url)
        Log.d("datatest", url)
    }



    private fun applyQueries(): HashMap<String, String>{

        val queries: HashMap<String, String> = HashMap()

        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_SEARCH] = city

        return queries

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}