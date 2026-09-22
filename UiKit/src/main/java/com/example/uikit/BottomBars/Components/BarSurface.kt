package com.example.uikit.BottomBars.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme

@Composable
fun BarSurface(
    topRounded: Dp = Dimensions.LargeRounded,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.BottomBarHeight)
            .dropShadow(
                shape = RoundedCornerShape(topStart = topRounded, topEnd = topRounded),
                shadow = Shadow(
                    radius = Dimensions.NavBarShadowR,
                    spread = Dimensions.ZeroSize,
                    color = FNCHTheme.colors.black.copy(alpha = Dimensions.SmallWeight),
                    offset = DpOffset(Dimensions.ZeroSize, Dimensions.NavBarShadowY)
                )
            )
            .clip(RoundedCornerShape(topStart = topRounded, topEnd = topRounded))
            .background(FNCHTheme.colors.white)
            .border(
                Dimensions.SmallBorderStroke,
                FNCHTheme.colors.darkenWhite,
                RoundedCornerShape(topStart = topRounded, topEnd = topRounded)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        content = content
    )
}