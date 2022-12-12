package com.example.trello.ACTIVITIES

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.trello.R
import com.example.trello.databinding.ActivitySignupactivityBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SIGNUPActivity : BaseActivity() {
    var binding:ActivitySignupactivityBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivitySignupactivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        binding?.btnSignUp?.setOnClickListener(){
            registerUser()
        }
    }
    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter name.")
                false
            }
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
    private fun registerUser() {
        // Here we get the text from editText and trim the space
        val name: String = binding?.etName?.text.toString().trim { it <= ' ' }
        val email: String = binding?.etEmail?.text.toString().trim { it <= ' ' }
        val password: String = binding?.etPassword?.text.toString().trim { it <= ' ' }

        if (validateForm(name, email, password)) {

            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this@SIGNUPActivity,
                    OnCompleteListener{ task ->

                        if (task.isSuccessful) {

                            // Firebase registered user
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            // Registered Email
                            val registeredEmail = firebaseUser.email!!
                            FirebaseAuth.getInstance().signOut()
                            finish()

                            //val user = User(firebaseUser.uid, name, registeredEmail)

                            // call the registerUser function of FirestoreClass to make an entry in the database.
                            //FirestoreClass().registerUser(this@SIGNUPActivity, user)
                        } else {
                            Toast.makeText(
                                this@SIGNUPActivity,
                                task.exception!!.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
            Toast.makeText(this@SIGNUPActivity,"Helllo paji",Toast.LENGTH_SHORT).show()
        }
    }


}