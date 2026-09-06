package com.example.uikit.Input

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW

@Composable
fun Select(
    onChange: (String) -> Unit,
    placeholder: String,
    value: String,
    valueList: List<String> = listOf("Engineering","Testing","Development"),
    titleText: String? = null,
){
    var expandMenu by remember{ mutableStateOf(false) }
    Column() {
        if (!titleText.isNullOrEmpty()) {

            Text(
                text = titleText,
                style = FNCHTheme.typography.labelMedium,
                color = FNCHTheme.colors.secondary
            )
            SpacerH(
                Dimensions.SmallSpacer
            )
        }


        BasicTextField(
            value = value,
            onValueChange = {},
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimensions.HeightButton)
                .background(
                    color = FNCHTheme.colors.darkenWhite,
                    shape = RoundedCornerShape(Dimensions.SmallRounded)
                )
                .border(
                    border = BorderStroke(
                        width = Dimensions.SmallBorderStroke,
                        color = FNCHTheme.colors.grey
                    ),
                    shape = RoundedCornerShape(Dimensions.SmallRounded)
                ),

            singleLine = true,
            textStyle = FNCHTheme.typography.bodyMedium.copy(
                color = FNCHTheme.colors.black
            ),
            cursorBrush = SolidColor(
                FNCHTheme.colors.primary
            ),

            decorationBox = { innerTextField ->

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = Dimensions.ExtraMediumPadding
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Box(
                        modifier = Modifier.weight(Dimensions.LargeAlpha),
                        contentAlignment = Alignment.CenterStart
                    ) {

                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = FNCHTheme.typography.bodyMedium,
                                color = FNCHTheme.colors.secondary
                            )
                        }
                        innerTextField()
                    }
                    SpacerW(Dimensions.MediumSpacer)

                    Icon(
                        painter = painterResource(
                            R.drawable.select
                        ),
                        modifier = Modifier.clickable {
                            expandMenu = true
                        },
                        contentDescription = null,
                        tint = FNCHTheme.colors.secondary
                    )

                }
            }
        )
        DropdownMenu(
            expandMenu,
            onDismissRequest = {
                expandMenu = false
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            valueList.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onChange(item)
                        expandMenu = false
                    }
                )
            }

        }
    }

}


@Preview
@Composable
fun TestSelect() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var text by remember { mutableStateOf("") }

        Select(
            onChange = {
                text = it
            },
            placeholder = "place",
            value = text,
            titleText = "test",
        )

        SpacerH(
            Dimensions.SmallSpacer
        )
        Select(
            onChange = {
                text = it
            },
            placeholder = "place",
            value = text,
            titleText = "test",
        )

        SpacerH(
            Dimensions.SmallSpacer
        )

        Select(
            onChange = {},
            placeholder = "",
            value = "value",
            titleText = "test"
        )
    }
}