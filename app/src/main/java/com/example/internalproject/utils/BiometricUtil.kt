package com.example.internalproject.utils

import android.content.Context
import androidx.biometric.BiometricManager

object BiometricUtil {

    fun hasBiometricCapability(context: Context): Int {
        val biometricManager = BiometricManager.from(context)
        return biometricManager.canAuthenticate()
    }

    fun isBiometricReady(context: Context) =
        hasBiometricCapability(context) == BiometricManager.BIOMETRIC_SUCCESS
}
