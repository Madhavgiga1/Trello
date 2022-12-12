package com.example.trello.ACTIVITIES

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.example.trello.R

class Splashscreenactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreenactivity)
        val typeface: Typeface = Typeface.createFromAsset(assets,"PartyConfettiRegular-eZOn3.ttf")

        var text=findViewById<TextView?>(R.id.spashscreentext)
        text?.typeface=typeface
        Handler().postDelayed({
            startActivity(Intent(this@Splashscreenactivity,INTROSCREENACTIVITY::class.java))
            finish()
        },2500)
    }


}