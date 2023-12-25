package kh.edu.rupp.ite.perfume_shop.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.perfume_shop.api.service.LoginApiService
import kh.edu.rupp.ite.perfume_shop.databinding.ActivityLoginBinding
import kh.edu.rupp.ite.perfume_shop.viewmodel.LoginViewModel

class LoginActivity(): AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = LoginViewModel();
        binding.loginbut.setOnClickListener { startMainActivity() }
    }

    private fun startMainActivity() {
//        val email = binding.email.text.toString();
//        Log.d("email" , email);
//        val password = binding.password.text.toString();
//        loginViewModel.login(email,password)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
