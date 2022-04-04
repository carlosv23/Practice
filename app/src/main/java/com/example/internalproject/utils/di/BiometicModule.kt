package com.example.internalproject.utils.di

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import com.example.internalproject.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BiometicModule {

    @Provides
    @Singleton
    fun getBiometric(@ApplicationContext context: Context) = BiometricManager.from(context)

    @Provides
    @Singleton
    fun getBiometricPrompInfo(@ApplicationContext context: Context) = BiometricPrompt.PromptInfo.Builder()
        .setTitle(context.getString(R.string.biometric_title))
        .setSubtitle(context.getString(R.string.biometric_subtitle))
        .setNegativeButtonText(context.getString(R.string.biometrics_negative_text))
        .build()
}
