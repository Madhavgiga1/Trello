package com.example.trello.ACTIVITIES

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.trello.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

open class BaseActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false

    private lateinit var mProgressDialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
    fun showProgressDialog(text: String){
        mProgressDialog=Dialog(this@BaseActivity)
        mProgressDialog.setContentView(R.layout.dialog_progress)
        //val tvtext=findViewById<TextView>(R.id.dia)
        mProgressDialog.show()
    }
    fun hideProgressdIALOG(){
        mProgressDialog.dismiss()
    }
    fun getCurrentUserID():String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
    fun doubleBackToExit() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true//pehli bar call hone pe variable true ho jayega phir agar wapis se back button press hua to if function activate hojayega
        Toast.makeText(
            this,
            resources.getString(R.string.please_click_back_again_to_exit),
            Toast.LENGTH_SHORT
        ).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    fun showErrorSnackBar(message: String) {
        val snackBar =
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(
            ContextCompat.getColor(
                this@BaseActivity,
                R.color.AutumnFoliage
            )
        )
        snackBar.show()
    }
}