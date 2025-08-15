package com.uki.nux.desktop.nux

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

/**
 * Created by ulangch on 2025/8/15
 */
object NuxStyle {

    val PrimaryBoldTextStyle
        get() = TextStyle(
            color = Color(NuxColors.TEXT_PRIMARY),
            fontSize = NuxDimens.S15,
            fontWeight = FontWeight.Bold
        )

    val SecondaryBoldTextStyle
        get() = TextStyle(
            color = Color(NuxColors.TEXT_SECONDARY),
            fontSize = NuxDimens.S15,
            fontWeight = FontWeight.Bold
        )

    val SecondarySemiTextStyle
        get() = TextStyle(
            color = Color(NuxColors.TEXT_SECONDARY),
            fontSize = NuxDimens.S12,
            fontWeight = FontWeight.SemiBold
        )
}