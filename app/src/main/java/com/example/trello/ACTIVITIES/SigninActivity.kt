package com.example.trello.ACTIVITIES

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.trello.R
import com.example.trello.databinding.ActivitySigninBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class SigninActivity : BaseActivity() {
    var binding:ActivitySigninBinding?=null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivitySigninBinding.inflate(layoutInflater)
        auth= FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        val typeface: Typeface = Typeface.createFromAsset(assets,"PartyConfettiRegular-eZOn3.ttf")
        val typefacelambda: Typeface = Typeface.createFromAsset(assets,"Lambda-vme1A.ttf")
        val typefacetrouble: Typeface = Typeface.createFromAsset(assets,"Troubleside-lgjxX.ttf")
        val typefaceplayfair: Typeface = Typeface.createFromAsset(assets,"PlayfairDisplayBlack-RpvVA.ttf")
        binding?.etEmail?.typeface=typefacelambda
        binding?.etPassword?.typeface=typefacelambda
        binding?.description?.typeface=typefacelambda
        binding?.tvTitle?.typeface=typeface
        binding?.btnSignIn?.typeface=typeface
        binding?.btnSignIn?.setOnClickListener(){
            signin()
        }
    }
    private fun validateForm( email: String, password: String): Boolean {
        return when {

            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter email.")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter password.")
                false
            }
            else -> {
                true
            }
        }
    }
    private fun signin(){
        val email: String = binding?.etEmail?.text.toString().trim { it <= ' ' }
        val password: String = binding?.etPassword?.text.toString().trim { it <= ' ' }
        if(validateForm(email, password)){
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful) {
                    Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}