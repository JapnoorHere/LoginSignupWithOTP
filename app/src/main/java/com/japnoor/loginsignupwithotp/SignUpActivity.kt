package com.japnoor.loginsignupwithotp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.japnoor.loginsignupwithotp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth=FirebaseAuth.getInstance()

        binding.btnNext.setOnClickListener {
            if(binding.emailET.text.toString().isEmpty()){
                binding.emailET.error="Enter Email"
            }
            else if(binding.passET.text.toString().isEmpty()){
                binding.passET.error="Enter Password"
            }
            else if(binding.confirmPassET.text.toString().isEmpty()){
                binding.confirmPassET.error="Enter Password again"
            }
            else if(!(binding.passET.text.toString().equals(binding.confirmPassET.text.toString()))){
                Toast.makeText(this@SignUpActivity, "Password does not match", Toast.LENGTH_SHORT).show()
            }
            else {
                var intent=Intent(this@SignUpActivity,OtpActivity::class.java)
                intent.putExtra("email",binding.emailET.text.toString())
                intent.putExtra("pass",binding.passET.text.toString())
                startActivity(intent)
            }
        }

    }
}