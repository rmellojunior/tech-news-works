package com.example.technewsworks.ui.screens.biometric

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Composable function that represents the biometric screen.
 *
 * @param modifier The Modifier to be applied to this screen.
 */
@Composable
fun BiometricScreen(
    modifier: Modifier = Modifier,
    vm: BiometricViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val biometricAuthenticator = BiometricAuthenticator(context)

    biometricAuthenticator.promptBiometricAuth(
        title = "Biometric Authentication",
        subTitle = "Log in using your biometric credential",
        negativeButtonText = "Cancel",
        onSuccess = {
            Toast.makeText(context, "Authentication succeeded!", Toast.LENGTH_SHORT).show()
        },
        onError = { _, errorString ->
            Toast.makeText(context, "Authentication error: $errorString", Toast.LENGTH_SHORT).show()
            vm.navigation.toHome()
        },
        onFailed = {
            Toast.makeText(context, "Authentication failed", Toast.LENGTH_SHORT).show()
        }
    )
}