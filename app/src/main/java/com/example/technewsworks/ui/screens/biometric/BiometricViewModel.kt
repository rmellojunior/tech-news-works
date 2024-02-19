package com.example.technewsworks.ui.screens.biometric

import android.util.Log
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.example.technewsworks.utils.LOG_TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BiometricViewModel @Inject constructor(
    val navigation: BiometricNavigation,
) : ViewModel() {

    fun promptBiometricAuth(
        context: FragmentActivity,
        authenticate: () -> Int,
        title: String,
        subTitle: String,
        onSuccess: (result: BiometricPrompt.AuthenticationResult) -> Unit,
        onError: (errorCode: Int, errString: CharSequence) -> Unit,
        onNotEnrolled: (errorCode: Int, errString: CharSequence) -> Unit,
        onFailed: () -> Unit,
    ) {
        when (authenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                Log.d(LOG_TAG, "Biometric features are available")
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE,
                    "No biometric features available on this device",
                )
                return
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE,
                    "Biometric features are currently unavailable.",
                )
                return
            }

            BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED,
                    "Biometric features available but a security vulnerability has been discovered.",
                )
                return
            }

            BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
                onError(
                    BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED,
                    "Biometric features are currently unavailable because the specified options are incompatible with the current Android version..",
                )
                return
            }

            BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
                onError(
                    BiometricManager.BIOMETRIC_STATUS_UNKNOWN,
                    "Unable to determine whether the user can authenticate using biometrics."
                )
                return
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                navigation.toHome()
                onNotEnrolled(
                    BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED,
                    "The user can't authenticate because no biometric or device credential is enrolled."
                )
                return
            }
        }

        val biometricPrompt =
            BiometricPrompt(
                context,
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
            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
            .setTitle(title)
            .setSubtitle(subTitle)
            .build()

        biometricPrompt.authenticate(promptInfo)
    }

}