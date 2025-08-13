package com.ukii.nsp.desktop

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.ukii.nsp.desktop.screens.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen()
    }
}