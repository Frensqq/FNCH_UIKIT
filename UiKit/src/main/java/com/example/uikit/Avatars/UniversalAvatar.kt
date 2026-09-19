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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme


@Composable
fun UniversalAvatar(
    painter: Painter? = null,
    title: String? = null,
    state: Boolean,
    colorText: Color = FNCHTheme.colors.black,
    colorBack: Color = FNCHTheme.colors.darkenWhite,
    textStyle: TextStyle = FNCHTheme.typography.screenHeader,
    text: String? = null,
    size: Dp = Dimensions.LargeObjectSize
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimensions.SmallSpacer)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .background(colorBack)
                .border(
                    Dimensions.SmallBorderStroke,
                    color = if (state) FNCHTheme.colors.primary else FNCHTheme.colors.grey,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {

            if (painter != null){
                Image(
                    painter = painter,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }else{
                if (title != null){
                    Text(
                        text = title,
                        style = textStyle,
                        color = colorText
                    )
                }
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