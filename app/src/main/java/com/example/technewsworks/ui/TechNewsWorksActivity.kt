package com.example.technewsworks.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import com.example.technewsworks.ui.theme.TechNewsWorksTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechNewsWorksActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechNewsWorksTheme {
                TechNewsWorksApp()
            }
        }
    }
}