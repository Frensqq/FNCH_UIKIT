package com.example.uikit.Avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme

@Composable
fun AvatarText(
    title: String? = null,
    text: String? = null
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimensions.SmallSpacer)
    ) {
        Box(
            modifier = Modifier
                .size(Dimensions.LargeObjectSize)
                .clip(CircleShape)
                .background(FNCHTheme.colors.darkenWhite)
                .border(
                    Dimensions.MediumBorderStroke,
                    color = FNCHTheme.colors.grey,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {

            if (title != null){
                Text(
                    text = title,
                    style = FNCHTheme.typography.displayLarge,
                )
            }
        }

        if (!text.isNullOrEmpty()){
            Text(
                text,
                style = FNCHTheme.typography.displaySmall,
                color = FNCHTheme.colors.black
            )
        }
    }
}