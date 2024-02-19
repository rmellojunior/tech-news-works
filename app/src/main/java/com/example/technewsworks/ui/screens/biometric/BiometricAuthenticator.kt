package com.example.technewsworks.ui.screens.biometric

import android.content.Context
import android.util.Log
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import com.example.technewsworks.utils.LOG_TAG

class BiometricAuthenticator(
    private val appContext: Context,
) {
    private val biometricManager = BiometricManager.from(appContext)
    private lateinit var biometricPrompt: BiometricPrompt

    private fun isBiometricAvailable() =
        biometricManager.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)

    fun promptBiometricAuth(
        title: String,
        subTitle: String,
        negativeButtonText: String,
        onSuccess: (result: BiometricPrompt.AuthenticationResult) -> Unit,
        onError: (errorCode: Int, errString: CharSequence) -> Unit,
        onFailed: () -> Unit,
    ) {
        when (isBiometricAvailable()) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                Log.d(LOG_TAG, "Biometric features are available")
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE,
                    "No biometric features available on this device",
                )
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE,
                    "Biometric features are currently unavailable.",
                )
            }

            BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED,
                    "Biometric features available but a security vulnerability has been discovered.",
                )
            }

            BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED,
                    "Biometric features are currently unavailable because the specified options are incompatible with the current Android version..",
                )
            }

            BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
                onError(
                    BiometricManager.BIOMETRIC_STATUS_UNKNOWN,
                    "Unable to determine whether the user can authenticate using biometrics."
                )
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED,
                    "The user can't authenticate because no biometric or device credential is enrolled."
                )
            }
        }

        biometricPrompt =
            BiometricPrompt(
                appContext as FragmentActivity,
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        onSuccess(result)
                    }

                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        super.onAuthenticationError(errorCode, errString)
                        onError(errorCode, errString)
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        onFailed()
                    }
                }
            )

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setSubtitle(subTitle)
            .setNegativeButtonText(negativeButtonText)
            .build()

        biometricPrompt.authenticate(promptInfo)
    }
}