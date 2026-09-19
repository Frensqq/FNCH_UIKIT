package com.example.uikit.Components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerW

@Composable
fun IconWithText(
    iconRes: Int,
    text: String,
    tint: Color = FNCHTheme.colors.secondary,
    color: Color = FNCHTheme.colors.black,
    style: TextStyle = FNCHTheme.typography.bodySmall,
){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painterResource(iconRes),
            null,
            tint = tint,
        )
        SpacerW(Dimensions.ExtraSmallPadding)
        Text(
            text,
            style = style,
            color = color
        )
    }
}