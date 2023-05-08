package com.japnoor.loginsignupwithotp


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.japnoor.loginsignupwithotp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()


        binding.signupTv.setOnClickListener {
            var intent=Intent(this@MainActivity,SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            if(binding.emailET.text.toString().isEmpty()){
                binding.emailLayout.error="Enter Email"
            }
            else if(binding.passET.text.toString().isEmpty()){
                binding.passLayout.error="Enter Password"
            }
            else {
                auth.signInWithEmailAndPassword(binding.emailET.text.toString(),binding.passET.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        var intent=Intent(this@MainActivity,HomeScreen::class.java)
                        startActivity(intent)
                    }
                }
            }
        }


    }
}