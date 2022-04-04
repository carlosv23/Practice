package com.example.internalproject.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.internalproject.databinding.ActivityLogInBinding
import com.example.internalproject.utils.CustomBiometricPrompt
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogIn : AppCompatActivity() {

    lateinit var binding: ActivityLogInBinding
    private lateinit var biometricPrompt: BiometricPrompt

    @Inject
    lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createBiometricPrompt()
        onClicklogIn()
    }

    private val nextActivity = {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun createBiometricPrompt() {
        val executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(
            this, executor,
            CustomBiometricPrompt(this, nextActivity)
        )
    }

    private fun showBiometricDialog() {
        biometricPrompt.authenticate(promptInfo)
    }

    private fun onClicklogIn() {
        binding.loginButton.setOnClickListener {
            showBiometricDialog()
        }
    }
}
