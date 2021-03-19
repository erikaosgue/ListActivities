package com.erikaosgue.listviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.erikaosgue.listviews.databinding.ActivityMainBinding
import io.github.serpro69.kfaker.Faker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var  activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val faker = Faker()


        val arrayRandomNames = arrayListOf<String>()

        for(i in 0..30) {
            arrayRandomNames.add(faker.name.firstName())
            println(arrayRandomNames[i])
        }
//
        val namesArray: Array<String> = arrayRandomNames.toTypedArray()
//        val namesArray: Array<String> = arrayOf("Dani", "Carlos", "Oswaldo", "Alvaro", "Matias", "Scott", "Santiago", "Luis", "Samy", "Samuel", "Andrew", "Jenny", "Julian", "Oscar", "Nicolas", "Ricardo")

        val namesAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesArray)

        listViewId.adapter = namesAdapter

        listViewId.setOnItemClickListener { parent, view, position, id ->
            var itemName: String = listViewId.getItemAtPosition(position).toString()
            Toast.makeText(this, "Name: $itemName", Toast.LENGTH_LONG).show()

        }


    }
}