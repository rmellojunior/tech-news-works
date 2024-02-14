package com.example.technewsworks.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.technewsworks.TechNewsWorksApp
import com.example.technewsworks.ui.theme.TechNewsWorksTheme

class TechNewsWorksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechNewsWorksTheme {
                TechNewsWorksApp()
            }
        }
    }
}