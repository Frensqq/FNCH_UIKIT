package com.example.uikit.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.uikit.Avatars.AvatarImg
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW

@Composable
fun TopBarRef(
    title: String,
    onClickExit: () -> Unit,
    onClickMenu: () -> Unit,
    state: Boolean = false,
    painter: Painter? = null
){


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimensions.TopBarHeight)
                .dropShadow(
                    shape = RectangleShape,
                    shadow = Shadow(
                        radius = Dimensions.MediumBorderStroke,
                        spread = Dimensions.ZeroSize,
                        color = FNCHTheme.colors.black.copy(alpha = Dimensions.SmallWeight),
                        offset = DpOffset(x = Dimensions.ZeroSize, y = Dimensions.SmallBorderStroke)
                    )
                )
                .background(FNCHTheme.colors.white)
                .padding(horizontal = Dimensions.DefaultSpacer),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!state) {
                    Icon(
                        painter = painterResource(R.drawable.exit),
                        modifier = Modifier.clickable {
                            onClickExit()
                        },
                        contentDescription = null,
                        tint = FNCHTheme.colors.black
                    )
                }


                SpacerW(Dimensions.ExtraMediumPadding)

                Text(text = title,
                    style = FNCHTheme.typography.bodyMedium,
                    color = FNCHTheme.colors.black
                )
            }

            if (painter != null){
                AvatarImg(painter, size = Dimensions.MediumObjectSize)
            }
            else {
                if (!state) {
                    Icon(
                        painter = painterResource(R.drawable.menu),
                        modifier = Modifier.clickable {
                            onClickMenu()
                        },
                        contentDescription = null,
                        tint = FNCHTheme.colors.black
                    )
                }
            }
        }
}


@Preview
@Composable
fun testTopBarRef(){
    Box(
        Modifier.fillMaxSize().background( FNCHTheme.colors.white),
        contentAlignment = Alignment.Center) {

        TopBarRef(
            "HR Design System",
            {},
            {},
            state = false,
            painterResource(R.drawable.avatar)

        )

    }
}
