package com.ukii.nsp.desktop.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ukii.nsp.desktop.nux.NuxColors
import com.ukii.nsp.desktop.nux.NuxDimens
import nspkmpdesktop.composeapp.generated.resources.Res
import nspkmpdesktop.composeapp.generated.resources.device_identifier
import nspkmpdesktop.composeapp.generated.resources.device_identifier_description
import nspkmpdesktop.composeapp.generated.resources.device_name
import nspkmpdesktop.composeapp.generated.resources.device_name_description
import nspkmpdesktop.composeapp.generated.resources.device_state_info
import nspkmpdesktop.composeapp.generated.resources.ic_desktop_edit
import nspkmpdesktop.composeapp.generated.resources.refresh
import nspkmpdesktop.composeapp.generated.resources.service_invalid
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

/**
 * Created by ulangch on 2025/8/13
 */
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFD0DDFF),
                    Color(0xFFFFDFC7),
                    Color(0xFFD9F3FF),
                    Color(0xFFFFDABD)
                ),
                start = Offset(0F, 0F), end = Offset(
                    NuxDimens.SCREEN_WIDTH.value, NuxDimens.SCREEN_HEIGHT.value
                )
            )
        ).padding(NuxDimens.D16)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(NuxDimens.D16))
                .background(Color(0x80FFFFFF)).padding(NuxDimens.D12),
            verticalArrangement = Arrangement.spacedBy(NuxDimens.D16)
        ) {
            StateSection()
            EditNameSection()
            IdentifierSection()
            EditDiskSection()
            InformationSection()
            QrcodeSection()
            Spacer(Modifier.height(20.dp))
            ManagementSection()
        }
    }
}

@Composable
private fun StateSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(Res.string.device_state_info),
                style = TextStyle(
                    color = Color(NuxColors.TEXT_PRIMARY),
                    fontSize = NuxDimens.S15,
                    fontWeight = FontWeight.Bold
                )
            )
            Box(
                modifier = Modifier.height(30.dp).clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFFE7E7E7)).clickable {

                    }.padding(horizontal = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(Res.string.refresh),
                    style = TextStyle(
                        color = Color(NuxColors.HIGHLIGHT_BLUE),
                        fontSize = NuxDimens.S15,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
        Spacer(Modifier.height(NuxDimens.D12))
        Text(
            text = stringResource(Res.string.service_invalid),
            style = TextStyle(
                color = Color(NuxColors.HIGHLIGHT_RED),
                fontSize = NuxDimens.S12,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
private fun EditNameSection() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(NuxDimens.D16))
            .background(Color(NuxColors.BG_PRIMARY))
            .padding(NuxDimens.D16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(Res.string.device_name),
                style = TextStyle(
                    color = Color(NuxColors.TEXT_PRIMARY),
                    fontSize = NuxDimens.S15,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = stringResource(Res.string.device_name_description),
                style = TextStyle(
                    color = Color(NuxColors.TEXT_SECONDARY),
                    fontSize = NuxDimens.S12,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        Image(
            painter = painterResource(Res.drawable.ic_desktop_edit),
            contentDescription = null,
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(8.dp)).clickable {

            }.padding(9.dp),
        )
    }
}

@Composable
private fun IdentifierSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(NuxDimens.D16))
            .background(Color(NuxColors.BG_PRIMARY))
            .padding(NuxDimens.D16),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(Res.string.device_identifier),
            style = TextStyle(
                color = Color(NuxColors.TEXT_PRIMARY),
                fontSize = NuxDimens.S15,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = stringResource(Res.string.device_identifier_description),
            style = TextStyle(
                color = Color(NuxColors.TEXT_SECONDARY),
                fontSize = NuxDimens.S12,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
private fun EditDiskSection() {

}

@Composable
private fun InformationSection() {

}

@Composable
private fun QrcodeSection() {

}

@Composable
private fun ManagementSection() {

}