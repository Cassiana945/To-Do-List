package com.cassi.listview

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ////////////////////////List View

        val listView: ListView = findViewById(R.id.listView)
        val listItems = arrayOf( "Read a book",
            "Learn Kotlin",
            "Go to the supermarket",
            "Watch a movie",
            "Draw")

        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = listAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "You have clicked on:  $selectedItem", Toast.LENGTH_SHORT).show()

        }

        val recyclerButton = findViewById<Button>(R.id.intentButton)
        recyclerButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}