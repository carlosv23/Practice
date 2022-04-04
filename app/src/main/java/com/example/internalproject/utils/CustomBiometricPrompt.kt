package com.example.internalproject.utils

import android.content.Context
import android.widget.Toast
import androidx.biometric.BiometricPrompt

class CustomBiometricPrompt(private val context: Context, val nextStep: () -> Unit) : BiometricPrompt.AuthenticationCallback() {

    override fun onAuthenticationError(
        errorCode: Int,
        errString: CharSequence
    ) {
        super.onAuthenticationError(errorCode, errString)
        Toast.makeText(
            context,
            "Authentication error: $errString", Toast.LENGTH_SHORT
        )
            .show()
    }

    override fun onAuthenticationSucceeded(
        result: BiometricPrompt.AuthenticationResult
    ) {
        super.onAuthenticationSucceeded(result)
        Toast.makeText(
            context,
            "Authentication succeeded!", Toast.LENGTH_SHORT
        )
            .show()
        nextStep()
    }

    override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        Toast.makeText(
            context, "Authentication failed",
            Toast.LENGTH_SHORT
        )
            .show()
    }
}
