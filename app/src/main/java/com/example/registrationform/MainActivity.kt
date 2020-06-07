package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name: String
        var gender= " "
        var dept = " "
        var deptlist = arrayListOf<String>("CS","IT","Other")
        name = Name.text.toString()
        deptSpinner.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,deptlist)
        class OnItemSelectedListener() : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                dept= deptlist[position]
            }

        }

        deptSpinner.onItemSelectedListener = OnItemSelectedListener()
        MyButton.setOnClickListener {
            name = Name.text.toString()
            Toast.makeText(applicationContext,name,Toast.LENGTH_SHORT).show()
            var genderId = GenderButton.checkedRadioButtonId
            if( genderId!=-1)
            {
                var selectedGender: RadioButton = findViewById(genderId)
                gender = selectedGender.text.toString()
            }
            var intent = Intent(this, secondActivity::class.java).apply {
                putExtra("refname",name)
                putExtra("gender",gender)
                putExtra("optdep",dept)
            }
            startActivity(intent)
        }
    }
}
