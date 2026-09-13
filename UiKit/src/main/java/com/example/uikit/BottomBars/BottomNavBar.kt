package com.example.uikit.BottomBars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerW


@Composable
fun BottomNavBar(
    onClickSave: () -> Unit,
    onClickNext: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.BottomBarHeight)
            .dropShadow(
                shape = RoundedCornerShape(
                    topStart = Dimensions.LargeRounded,
                    topEnd = Dimensions.LargeRounded),
                shadow = Shadow(
                    radius = Dimensions.NavBarShadowR,
                    spread = Dimensions.ZeroSize,
                    color = FNCHTheme.colors.black.copy(alpha = Dimensions.SmallWeight),
                    offset = DpOffset(x = Dimensions.ZeroSize, y = Dimensions.NavBarShadowY)
                )
            ).clip(RoundedCornerShape(
                topStart = Dimensions.LargeRounded,
                topEnd = Dimensions.LargeRounded)
            )
            .background(FNCHTheme.colors.white)
            .border(
                width = Dimensions.SmallBorderStroke,
                FNCHTheme.colors.darkenWhite,
                shape = RoundedCornerShape(
                    topStart = Dimensions.LargeRounded,
                    topEnd = Dimensions.LargeRounded)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {


        SaveNavBarItem {
            onClickSave()
        }
        SpacerW(Dimensions.SmallSpacer)
        NextNavBarItem {
            onClickNext()
        }

    }

}


@Composable
fun SaveNavBarItem(
    onClick: ()->Unit
){

    Box() {
        Column(
            Modifier.clickable {
                onClick()
            }
                .padding(
                    horizontal = Dimensions.LargePadding,
                    vertical = Dimensions.ExtraSmallPadding
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.save),
                contentDescription = null,
                tint = FNCHTheme.colors.secondary
            )

            Text(
                "Сохранить",
                style = FNCHTheme.typography.bodySmall,
                color = FNCHTheme.colors.secondary
            )
        }
    }
}
@Composable
fun NextNavBarItem(
    onClick: ()->Unit
){

    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = FNCHTheme.colors.white,
            containerColor = FNCHTheme.colors.primary
        ),
        shape = RoundedCornerShape(Dimensions.LargeRounded),
        contentPadding = PaddingValues(
            horizontal = Dimensions.MediumObjectSize,
            vertical = Dimensions.SmallSpacer
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.next),
                contentDescription = null,
            )
            Text(
                "Продолжить",
                style = FNCHTheme.typography.bodySmall,
            )
        }
    }
}

@Preview
@Composable
fun testNavBar(){
    var current by remember { mutableStateOf("Test") }
    Column(
        Modifier.fillMaxSize().background( FNCHTheme.colors.white),
        verticalArrangement = Arrangement.Center) {
        BottomNavBar({},{})
    }

}
