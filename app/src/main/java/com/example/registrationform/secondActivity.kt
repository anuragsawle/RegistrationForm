package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var obtname = intent.getStringExtra("refname")
        RegForm.text="Registration Form"
        SpkTut.text= "Spoken Tutorial"
        var obtGender = intent.getStringExtra("gender")
        var obtdept = intent.getStringExtra("optdep")
        WelcomeMes.text = "Welcome $obtname your gender $obtGender from $obtdept"

    }
}