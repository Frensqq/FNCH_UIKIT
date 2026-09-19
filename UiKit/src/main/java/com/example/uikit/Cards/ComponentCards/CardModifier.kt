package com.example.uikit.Cards.ComponentCards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme

@Composable
fun Modifier.fnchCard(
    padding: Dp = Dimensions.ExtraMediumPadding,
    borderColor: Color = FNCHTheme.colors.darkenWhite,
) = this
    .fillMaxWidth()
    .dropShadow(
        shape = RoundedCornerShape(Dimensions.LargeRounded),
        shadow = Shadow(
            radius = Dimensions.CardBlur,
            spread = Dimensions.ZeroSize,
            color = FNCHTheme.colors.black.copy(alpha = Dimensions.SmallWeight),
            offset = DpOffset(Dimensions.ZeroSize, Dimensions.LargeBorderStroke)
        )
    )
    .clip(RoundedCornerShape(Dimensions.LargeRounded))
    .background(FNCHTheme.colors.white)
    .border(Dimensions.SmallBorderStroke, borderColor, RoundedCornerShape(Dimensions.LargeRounded))
    .padding(padding)