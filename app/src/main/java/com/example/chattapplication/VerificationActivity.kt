package com.example.chattapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VerificationActivity : AppCompatActivity() {
    var binding : ActivityVerificationBinding = null
    var auth: FirebaseAuth = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate (layoutInflater
                setContentView binding!!.root)
                auth = FirebaseAuth.getInstance()
            if (auth!!.currentUser != null) {
                val intent = Intent(this@VerificationActivity, MainActivity::class.java)
                startActivity (intent)
                finish()
            }
        supportActionBar!!.hide()
        binding!!.editNumber.requestFocus()
        binding!!.continueBtn.setOnClickListener {
            val intent = Intent(  this@VerificationActivity,
            OTPActivity::class.java)
            intent.putExtra(  "phoneNumber", binding!!.editNumber.text.toString())
            startActivity (intent)
        }
    }
}