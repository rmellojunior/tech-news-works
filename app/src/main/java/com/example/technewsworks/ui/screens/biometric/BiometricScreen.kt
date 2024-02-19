package com.example.technewsworks.ui.screens.biometric

import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Composable function that represents the biometric screen.
 *
 * @param modifier The Modifier to be applied to this screen.
 * @param vm View model.
 */
@Composable
fun BiometricScreen(
    modifier: Modifier = Modifier,
    vm: BiometricViewModel = hiltViewModel(),
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        val biometricManager = BiometricManager.from(context)

        TextButton(
            onClick = {
                vm.promptBiometricAuth(
                    context = context as FragmentActivity,
                    authenticate = { biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL) },
                    title = "Biometric Authentication",
                    subTitle = "Log in using your biometric credential",
                    onSuccess = {
                        Toast.makeText(context, "Authentication succeeded!", Toast.LENGTH_SHORT).show()
                        vm.navigation.toHome()
                    },
                    onError = { _, errorString ->
                        Toast.makeText(context, "Authentication error: $errorString", Toast.LENGTH_SHORT).show()
                    },
                    onNotEnrolled = { _, errorString ->
                        Toast.makeText(context, "$errorString", Toast.LENGTH_SHORT).show()
                        vm.navigation.toHome()
                    },
                    onFailed = {
                        Toast.makeText(context, "Authentication failed", Toast.LENGTH_SHORT).show()
                    }
                )
            }) {
            Text(text = "Login")
        }

    }
}