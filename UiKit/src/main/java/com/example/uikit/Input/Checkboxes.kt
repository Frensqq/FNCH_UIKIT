package com.example.uikit.Input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHColor
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW

@Composable
fun Checkboxes(
    onChangeState: (Boolean) -> Unit,
    state: Boolean = false,
    isDisabled: Boolean = false
){

    Row() {
        Box(
            Modifier
                .size(Dimensions.MediumObjectSize)
                .clip(
                    RoundedCornerShape(
                        Dimensions.ExtraSmallRounded
                    )
                ).background(
                    color = if(state) FNCHTheme.colors.primary
                    else FNCHTheme.colors.darkenWhite
                ).clickable{
                    if (!isDisabled){
                        onChangeState(!state)
                    }
                }
                .border(
                    width = Dimensions.SmallBorderStroke,
                    color = if (state) FNCHTheme.colors.primary
                    else{
                        if (isDisabled) FNCHTheme.colors.grey
                        else FNCHTheme.colors.secondary
                    },
                    shape = RoundedCornerShape(Dimensions.ExtraSmallRounded)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (state){
                Icon(
                    painter = painterResource(R.drawable.check),
                    contentDescription = null,
                    tint = FNCHTheme.colors.white
                )
            }
        }

        SpacerW(Dimensions.ExtraMediumSpacer)

        Text(
            text = if (state) "Checked"
            else{
                if (isDisabled) "Disabled"
                else "Unchecked"
            },
            style = FNCHTheme.typography.bodyMedium,
            color = if (state) FNCHTheme.colors.black
            else{
                if (isDisabled) FNCHTheme.colors.black.copy(
                    alpha = Dimensions.MediumAlpha
                )
                else FNCHTheme.colors.black
            },
        )
    }
}


@Preview
@Composable
fun TestCheck() {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(FNCHTheme.colors.white),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var test1 by remember { mutableStateOf(false) }
        Checkboxes(
            {test1 = it},
            test1,
            true
        )

        SpacerH(
            Dimensions.SmallSpacer
        )

        var test2 by remember { mutableStateOf(false) }
        Checkboxes(
            {test2 = it},
            test2,
            false
        )

        SpacerH(
            Dimensions.SmallSpacer
        )

        var test3 by remember { mutableStateOf(true) }
        Checkboxes(
            {test3 = it},
            test3,
            true
        )


    }
}