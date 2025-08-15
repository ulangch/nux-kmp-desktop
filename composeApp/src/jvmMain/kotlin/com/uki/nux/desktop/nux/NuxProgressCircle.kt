package com.uki.nux.desktop.nux

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by ulangch on 2025/8/14
 */
@Composable
fun NuxProgressCircle(
    label: String,
    value: Int,
    circleModifier: Modifier = Modifier,
    circleColor: Color = Color(NuxColors.BG_TERTIARY),
    circleArcColor: Color = Color(NuxColors.HIGHLIGHT_BLUE),
    circleStrokeWidth: Dp = 10.dp,
    valueModifier: Modifier = Modifier,
    valueStyle: TextStyle = TextStyle(
        color = Color(NuxColors.HIGHLIGHT_BLUE),
        fontSize = NuxDimens.S18,
        fontWeight = FontWeight.Bold
    ),
    labelModifier: Modifier = Modifier,
    labelStyle: TextStyle = NuxStyle.SecondarySemiTextStyle
) {
    val validatedProgress = value.coerceIn(0, 100)
    val sweepAngle = 360 * (validatedProgress / 100f)
    BoxWithConstraints(contentAlignment = Alignment.Center, modifier = circleModifier) {
        Canvas(modifier = Modifier.size(maxWidth)) {
            drawArc(
                color = circleColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = circleStrokeWidth.toPx())
            )

            drawArc(
                color = circleArcColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = circleStrokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$validatedProgress%",
                style = valueStyle,
                modifier = valueModifier
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = label,
                style = labelStyle,
                modifier = labelModifier
            )
        }
    }
}