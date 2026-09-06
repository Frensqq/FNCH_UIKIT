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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.Input.Checkboxes
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH

@Composable
fun AvatarImg(
    painter: Painter? = null,
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
                    color = FNCHTheme.colors.primary,
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

@Preview
@Composable
fun testAvatarImg(){

    Column(
        modifier = Modifier.fillMaxSize()
            .background(FNCHTheme.colors.white),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AvatarImg(
            painter = painterResource(R.drawable.avatar),
            "Photo"
        )

    }

}