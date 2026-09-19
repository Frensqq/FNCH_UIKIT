package com.example.uikit.BottomBars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerW

@Composable
fun BottomNavBarShell(
    currentState: String,
    onChangeState: (String) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth()
            .height(Dimensions.BottomBarHeight)
            .dropShadow(
                shape = RoundedCornerShape(
                    topStart = Dimensions.SmallRounded,
                    topEnd = Dimensions.SmallRounded),
                shadow = Shadow(
                    radius = Dimensions.NavBarShadowR,
                    spread = Dimensions.ZeroSize,
                    color = FNCHTheme.colors.black.copy(alpha = Dimensions.SmallWeight),
                    offset = DpOffset(x = Dimensions.ZeroSize, y = Dimensions.NavBarShadowY)
                )
            ).clip(RoundedCornerShape(
                topStart = Dimensions.SmallRounded,
                topEnd = Dimensions.SmallRounded)
            )
            .background(FNCHTheme.colors.white)
            .border(
                width = Dimensions.SmallBorderStroke,
                FNCHTheme.colors.darkenWhite,
                shape = RoundedCornerShape(
                    topStart = Dimensions.SmallRounded,
                    topEnd = Dimensions.SmallRounded)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        BottomBarShellItem(
            painterResource(R.drawable.vacancies),
            "Vacancies",
            state = currentState == "Vacancies"
        ) {item->
            onChangeState(item)
        }
        SpacerW(Dimensions.LargeSpacer)
        BottomBarShellItem(
            painterResource(R.drawable.candidates),
            "Candidates",
            state = currentState == "Candidates"
        ) {item->
            onChangeState(item)
        }
        SpacerW(Dimensions.LargeSpacer)
        BottomBarShellItem(
            painterResource(R.drawable.settings),
            "Settings",
            state = currentState == "Settings"
        ) {item->
            onChangeState(item)
        }

    }

}

@Composable
fun BottomBarShellItem(icon: Painter,text: String, state: Boolean, onClick: (String) -> Unit){
    Column(
        Modifier
            .height(Dimensions.BottomBarObjectHeight)
            .clickable{
                onClick(text)
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        val color = if (state) FNCHTheme.colors.primary else FNCHTheme.colors.secondary

        Icon(painter = icon,
            contentDescription = null,
            tint = color
            )
        Text(
            text,
            style = FNCHTheme.typography.fieldLabel,
            overflow = TextOverflow.Visible,
            color = color
        )


    }
}


@Preview
@Composable
fun testNavBarShell(){
    var current by remember { mutableStateOf("Test") }
    Column(
        Modifier.fillMaxSize().background( FNCHTheme.colors.white),
        verticalArrangement = Arrangement.Center) {

        BottomNavBarShell(current) {
            current = it
        }

    }


    var text by remember { mutableStateOf("Test") }
    BottomBarShellItem(
        painterResource(R.drawable.search),
        "Product",
        state = text == "Product",{
            text = it
        }
    )
}
