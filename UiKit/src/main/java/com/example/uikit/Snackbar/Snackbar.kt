package com.example.uikit.Snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.Navigation.TopAppBar
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerW
import com.google.android.material.snackbar.Snackbar
import java.nio.file.WatchEvent

@Composable
fun Snackbar(
    text: String,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(Dimensions.SnackBarHeight)
            .clip(RoundedCornerShape(Dimensions.SmallRounded))
            .background(FNCHTheme.colors.black)
            .dropShadow(
                shape = RoundedCornerShape(Dimensions.SmallRounded),
                shadow = Shadow(
                    radius = Dimensions.SnackBarMediumBlur,
                    spread = Dimensions.SmallSpread,
                    color = FNCHTheme.colors.black.copy(alpha = Dimensions.MediumWeight),
                    offset = DpOffset(x = Dimensions.ZeroSize, y = Dimensions.SnackBarMediumShadowY)
                )
            ).dropShadow(
                shape = RoundedCornerShape(Dimensions.SmallRounded),
                shadow = Shadow(
                    radius = Dimensions.SnackBarSmallBlur,
                    spread = Dimensions.ExtraSmallSpread,
                    color = FNCHTheme.colors.black.copy(alpha = Dimensions.MediumWeight),
                    offset = DpOffset(x = Dimensions.ZeroSize, y = Dimensions.SnackBarSmallShadowY)
                )
            ).padding(Dimensions.ExtraMediumPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically


    ) {
        Row(
            Modifier
            .fillMaxWidth(Dimensions.MediumFillMax),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.checked),
                contentDescription = null,
                tint = FNCHTheme.colors.secondary
            )

            SpacerW(Dimensions.SmallSpacer)

            Text(text,
                style = FNCHTheme.typography.bodySmall,
                color = FNCHTheme.colors.darkenWhite
            )
        }

        Box(
            modifier = Modifier.clickable{
                onClick()
            }
        ){

            Text("UNDO",
                style = FNCHTheme.typography.labelMedium,
                color = FNCHTheme.colors.grey,
                modifier = Modifier.padding(
                    horizontal = Dimensions.SmallSpacer,
                    vertical = Dimensions.ExtraSmallSpacer
                )
            )

        }
    }
}


@Preview
@Composable
fun testTopBar(){
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Snackbar("Candidate card successfully\n" +
                "removed from the board") { }

    }
}