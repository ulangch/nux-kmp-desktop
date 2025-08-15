package com.uki.nux.desktop

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.uki.nux.desktop.screens.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen()
    }
}