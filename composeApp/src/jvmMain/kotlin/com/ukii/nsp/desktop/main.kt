package com.ukii.nsp.desktop

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.ukii.nsp.desktop.nux.NuxDimens

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Nspkmpdesktop",
        state = WindowState(size = DpSize(NuxDimens.SCREEN_WIDTH, NuxDimens.SCREEN_HEIGHT))
    ) {
        App()
    }
}