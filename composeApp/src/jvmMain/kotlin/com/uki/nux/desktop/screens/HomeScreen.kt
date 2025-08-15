package com.uki.nux.desktop.screens

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.uki.nux.desktop.data.NuxFile
import com.uki.nux.desktop.nux.NuxColors
import com.uki.nux.desktop.nux.NuxDimens
import com.uki.nux.desktop.nux.NuxProgressCircle
import com.uki.nux.desktop.nux.NuxStyle
import nuxkmpdesktop.composeapp.generated.resources.Res
import nuxkmpdesktop.composeapp.generated.resources.cpu_upper
import nuxkmpdesktop.composeapp.generated.resources.device_identifier
import nuxkmpdesktop.composeapp.generated.resources.device_identifier_description
import nuxkmpdesktop.composeapp.generated.resources.device_name
import nuxkmpdesktop.composeapp.generated.resources.device_name_description
import nuxkmpdesktop.composeapp.generated.resources.device_state_info
import nuxkmpdesktop.composeapp.generated.resources.ic_desktop_add
import nuxkmpdesktop.composeapp.generated.resources.ic_desktop_delete
import nuxkmpdesktop.composeapp.generated.resources.ic_desktop_directory
import nuxkmpdesktop.composeapp.generated.resources.ic_desktop_edit
import nuxkmpdesktop.composeapp.generated.resources.ic_desktop_power_off
import nuxkmpdesktop.composeapp.generated.resources.lan_address
import nuxkmpdesktop.composeapp.generated.resources.memory
import nuxkmpdesktop.composeapp.generated.resources.qrcode_description
import nuxkmpdesktop.composeapp.generated.resources.refresh
import nuxkmpdesktop.composeapp.generated.resources.running_duration
import nuxkmpdesktop.composeapp.generated.resources.running_duration_fmt
import nuxkmpdesktop.composeapp.generated.resources.service_invalid
import nuxkmpdesktop.composeapp.generated.resources.store_dirs
import nuxkmpdesktop.composeapp.generated.resources.store_dirs_description
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
                .background(Color(0x80FFFFFF)).padding(horizontal = NuxDimens.D12)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(NuxDimens.D12),
        ) {
            Spacer(Modifier.height(NuxDimens.D0))
            StateVersion2Section()
            EditNameSection()
            IdentifierSection()
            InformationSection()
            QrcodeSection()
            EditDiskSection()
            Spacer(Modifier.height(NuxDimens.D0))
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
                style = NuxStyle.PrimaryBoldTextStyle
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
private fun StateVersion2Section() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = NuxDimens.D8),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1F),
            verticalArrangement = Arrangement.spacedBy(NuxDimens.D8)
        ) {
            Text(
                text = stringResource(Res.string.device_state_info),
                style = NuxStyle.PrimaryBoldTextStyle
            )
            Text(
                text = stringResource(Res.string.service_invalid),
                style = TextStyle(
                    color = Color(NuxColors.HIGHLIGHT_RED),
                    fontSize = NuxDimens.S12,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Row {
//            Image(
//                painterResource(Res.drawable.ic_desktop_refresh),
//                contentDescription = null,
//                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(12.dp)).clickable {},
//                contentScale = ContentScale.FillBounds
//            )
            Image(
                painterResource(Res.drawable.ic_desktop_power_off),
                contentDescription = null,
                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(12.dp)).clickable {},
                contentScale = ContentScale.FillBounds
            )
        }
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
                style = NuxStyle.PrimaryBoldTextStyle
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = stringResource(Res.string.device_name_description),
                style = NuxStyle.SecondarySemiTextStyle
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
            style = NuxStyle.PrimaryBoldTextStyle
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = stringResource(Res.string.device_identifier_description),
            style = NuxStyle.SecondarySemiTextStyle
        )
    }
}

@Composable
private fun InformationSection() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(NuxDimens.D16))
            .background(Color(NuxColors.BG_PRIMARY))
            .padding(NuxDimens.D16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1F), verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(Res.string.running_duration),
                style = NuxStyle.PrimaryBoldTextStyle
            )
            Spacer(Modifier.height(NuxDimens.D20))
            Text(
                text = stringResource(Res.string.running_duration_fmt, 0, 0, 5, 23),
                style = NuxStyle.SecondaryBoldTextStyle
            )
        }
        Row(
            modifier = Modifier.padding(end = NuxDimens.D8),
            horizontalArrangement = Arrangement.spacedBy(NuxDimens.D32)
        ) {
            NuxProgressCircle(
                label = stringResource(Res.string.cpu_upper),
                value = 12,
                circleModifier = Modifier.size(90.dp)
            )
            NuxProgressCircle(
                label = stringResource(Res.string.memory),
                value = 20,
                circleModifier = Modifier.size(90.dp)
            )
        }
    }
}


@Composable
private fun QrcodeSection() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(NuxDimens.D16))
            .background(Color(NuxColors.BG_PRIMARY))
            .padding(NuxDimens.D16),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(1F), verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(Res.string.lan_address),
                style = NuxStyle.PrimaryBoldTextStyle
            )
            Spacer(Modifier.height(NuxDimens.D8))
            Text(
                text = "https://192.168.1.123:5688",
                style = NuxStyle.SecondarySemiTextStyle
            )
            Spacer(Modifier.height(NuxDimens.D20))
            Text(
                text = stringResource(Res.string.qrcode_description),
                style = NuxStyle.SecondarySemiTextStyle
            )
        }
        AsyncImage(
            model = "https://bj.bcebos.com/bjh-pixel/1703371610253970636_7_ainote_new.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp).background(Color(NuxColors.BG_TERTIARY)),
        )
    }
}

@Composable
private fun EditDiskSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(NuxDimens.D16))
            .background(Color(NuxColors.BG_PRIMARY))
            .padding(NuxDimens.D16),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = stringResource(Res.string.store_dirs),
                    style = NuxStyle.PrimaryBoldTextStyle
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = stringResource(Res.string.store_dirs_description),
                    style = NuxStyle.SecondarySemiTextStyle
                )
            }
            Image(
                painter = painterResource(Res.drawable.ic_desktop_add),
                contentDescription = null,
                modifier = Modifier.size(40.dp).clip(RoundedCornerShape(8.dp)).clickable {

                }.padding(9.dp),
            )
        }
        Spacer(Modifier.height(NuxDimens.D10))
        for (nuxFile in configureDebugDisks()) {
            DiskObjectFrame(nuxFile.name, nuxFile.path)
        }
    }
}

@Composable
private fun DiskObjectFrame(name: String, path: String) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_desktop_directory),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.weight(1F).padding(horizontal = NuxDimens.D12),
            verticalArrangement = Arrangement.spacedBy(NuxDimens.D6)
        ) {
            Text(text = name, style = NuxStyle.SecondarySemiTextStyle)
            Text(
                text = path,
                style = TextStyle(color = Color(NuxColors.TEXT_TERTIARY), fontSize = NuxDimens.S10)
            )
        }
        Image(
            painter = painterResource(Res.drawable.ic_desktop_delete),
            contentDescription = null,
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(NuxDimens.D8)).clickable {}
                .padding(14.dp)
        )
    }
}

private fun configureDebugDisks(): List<NuxFile> {
    return listOf(
        NuxFile("我的资源库", "D://NuxSpace"),
        NuxFile("手机备份空间", "E://AutoBackup"),
//        NuxFile("影视资源", "F://Videos"),
    )
}