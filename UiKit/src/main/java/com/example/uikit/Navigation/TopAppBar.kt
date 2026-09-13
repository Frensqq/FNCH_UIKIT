package com.example.uikit.Navigation

import android.service.carrier.MessagePdu
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.uikit.Avatars.AvatarImg
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerW

@Composable
fun TopAppBar(
    title: String,
    painter: Painter?,
    onClick: () ->Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.MediumObjectHeight)
            .padding(horizontal = Dimensions.DefaultSpacer),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(Dimensions.MediumAlpha)
        ) {

            Icon(
                painter = painterResource(R.drawable.burger),
                contentDescription = null,
                modifier = Modifier
                    .clickable{
                    onClick()
                },
                tint = FNCHTheme.colors.primary
            )

            SpacerW(Dimensions.MediumSpacer)

            Text(text = title,
                style = FNCHTheme.typography.displayMedium,
                color = FNCHTheme.colors.black,
                maxLines = Dimensions.countLine
            )
        }

        AvatarImg(
            painter,
            size = Dimensions.MediumObjectSize
        )
    }
}

@Preview
@Composable
fun testTopBar(){
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        TopAppBar(
            "HR Design System",
            painterResource(R.drawable.avatar)
        ) { }

    }
}
