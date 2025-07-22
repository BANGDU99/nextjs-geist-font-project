package com.solo.leveling.fitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.solo.leveling.fitness.ui.theme.SoloLevelingFitnessTheme
import com.solo.leveling.fitness.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoloLevelingFitnessTheme {
                MainScreen()
            }
        }
    }
}
