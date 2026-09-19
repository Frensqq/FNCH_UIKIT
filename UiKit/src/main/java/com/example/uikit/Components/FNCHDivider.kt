package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme

@Composable
fun FNCHDivider(color: Color = FNCHTheme.colors.darkenWhite) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(Dimensions.SmallBorderStroke)
            .background(color)
    )
}