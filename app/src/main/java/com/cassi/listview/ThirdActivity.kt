package com.cassi.listview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity



class ThirdActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        ///////////////////// Spinner

        spinner = findViewById(R.id.spinner)

        val listItems = listOf("Item 1", "Item 2", "Item 3", "Item 4")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listItems)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@ThirdActivity,
                    "You  have selected $selectedItem flavour",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        ///////////////// Alert Dialog

        val exitButton: Button = findViewById(R.id.exitButton)

        exitButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", null)
                .setNegativeButton("No", null)
                .show()

            val positiveButton = builder.getButton(AlertDialog.BUTTON_POSITIVE)
            positiveButton.setOnClickListener {
                finishAffinity()
            }
        }


    }
}