package com.japnoor.loginsignupwithotp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.firebase.auth.FirebaseAuth
import com.japnoor.loginsignupwithotp.databinding.ActivityOtpBinding

class OtpActivity : AppCompatActivity() {

    lateinit var binding : ActivityOtpBinding
    lateinit var auth : FirebaseAuth
    var email : String =""
    var pass : String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)



        auth=FirebaseAuth.getInstance()
        email=intent.getStringExtra("email").toString()
        pass=intent.getStringExtra("pass").toString()

        binding.otp1.doOnTextChanged { text, start, before, count ->
            if(!(text.toString().isEmpty())){
                binding.otp2.requestFocus()
            }
        }
        binding.otp2.doOnTextChanged { text, start, before, count ->
            if(!(text.toString().isEmpty())){
                binding.otp3.requestFocus()
            }
            else{
                binding.otp1.requestFocus()
            }
        }
        binding.otp3.doOnTextChanged { text, start, before, count ->
            if(!(text.toString().isEmpty())){
                binding.otp4.requestFocus()
            }
            else {
                binding.otp2.requestFocus()
            }
        }
        binding.otp4.doOnTextChanged { text, start, before, count ->
            if(!(text.toString().isEmpty())){
                binding.otp5.requestFocus()
            }
            else {
                binding.otp3.requestFocus()
            }

        }
        binding.otp5.doOnTextChanged { text, start, before, count ->
            if(!(text.toString().isEmpty())){
                binding.otp6.requestFocus()
            }
            else {
                binding.otp4.requestFocus()
            }
        }

        binding.otp6.doOnTextChanged { text, start, before, count ->
            if((text.toString().isEmpty())){
                binding.otp6.requestFocus()
            }
        }

        binding.button.setOnClickListener {

        }


    }
}