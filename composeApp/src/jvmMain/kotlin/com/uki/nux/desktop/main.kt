package com.uki.nux.desktop

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.uki.nux.desktop.nux.NuxDimens

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Nuxkmpdesktop",
        state = WindowState(size = DpSize(NuxDimens.SCREEN_WIDTH, NuxDimens.SCREEN_HEIGHT))
    ) {
        App()
    }
}