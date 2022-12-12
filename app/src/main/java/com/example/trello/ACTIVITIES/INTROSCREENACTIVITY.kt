package com.example.trello.ACTIVITIES

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.trello.R

class INTROSCREENACTIVITY : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introscreenactivity)
        val typeface: Typeface = Typeface.createFromAsset(assets,"PartyConfettiRegular-eZOn3.ttf")

        var Loginbtn=findViewById<TextView?>(R.id.LOGInBUTTON)
        var Signupbtn=findViewById<TextView?>(R.id.SIGNUPBUTTON)
        Loginbtn?.typeface=typeface
        Signupbtn?.typeface=typeface
        Loginbtn?.setOnClickListener(){
            startActivity(Intent(this@INTROSCREENACTIVITY,SigninActivity::class.java))
        }
        Signupbtn?.setOnClickListener(){
            startActivity(Intent(this@INTROSCREENACTIVITY,SIGNUPActivity::class.java))
        }
    }
}