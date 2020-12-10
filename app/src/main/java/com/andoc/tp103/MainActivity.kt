package com.andoc.tp103

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        val list = ArrayList<ListItemPlus>()

        list.addAll(
            fillArrays(
                resources.getStringArray(R.array.СМП),
                resources.getStringArray(R.array.СМП_content),
                resources.getStringArray(R.array.СМП_urls)
            )
        )


        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {


            R.id.id_prot ->
            {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.prot),
                    resources.getStringArray(R.array.prot_content),resources.getStringArray(R.array.prot_urls)))


            }



            R.id.id_ambul ->

            {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.СМП),
                    resources.getStringArray(R.array.СМП_content),resources.getStringArray(R.array.СМП_urls)))


            }

            R.id.id_cardio -> {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.cardio),
                    resources.getStringArray(R.array.cardio_content),resources.getStringArray(R.array.cardio_urls)))


            }

            R.id.id_therapy -> {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.ther),
                    resources.getStringArray(R.array.ther_content),resources.getStringArray(R.array.ther_urls)))


            }

            R.id.id_nefro -> {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.nefr),
                    resources.getStringArray(R.array.nefr_content),resources.getStringArray(R.array.nefr_urls)))


            }

            R.id.id_neuro -> {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.nevr),
                    resources.getStringArray(R.array.nevr_content),resources.getStringArray(R.array.nevr_urls)))


            }

            R.id.id_poly -> {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.poly),
                    resources.getStringArray(R.array.poly_content),resources.getStringArray(R.array.poly_urls)))


            }




            R.id.id_serg -> {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.serg),
                    resources.getStringArray(R.array.serg_content),resources.getStringArray(R.array.serg_urls)))


            }

            R.id.id_uro -> {Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.uro),
                    resources.getStringArray(R.array.uro_content),resources.getStringArray(R.array.uro_urls)))


            }


        }
        return true
    }


    fun fillArrays(
        titleArray: Array<String>,
        contentArray: Array<String>,
        urlArray: Array<String>):
            List<ListItemPlus> {

        var listItemArray = ArrayList<ListItemPlus>()

        for (n in 0..titleArray.size - 1) {
            var listItem = ListItemPlus(
                titleArray[n],
                contentArray[n],
                urlArray[n]
            )
            listItemArray.add(listItem)
        }

            return listItemArray
        }
    }
