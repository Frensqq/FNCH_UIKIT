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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW

@Composable
fun InputFields(
    onChange: (String) -> Unit,
    placeholder: String,
    value: String,
    titleText: String? = null,
    errorText: String? = null,
    isSearch: Boolean = false,
    isPass: Boolean = false,
    isDisable: Boolean = false,
) {

    var isFocused by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val shape = RoundedCornerShape(Dimensions.SmallRounded)

    val borderColor = when {
        !errorText.isNullOrEmpty() -> FNCHTheme.colors.error
        isFocused -> FNCHTheme.colors.primary
        else -> FNCHTheme.colors.grey
    }

    Column {

        if (!titleText.isNullOrEmpty()) {

            Text(
                text = titleText,
                style = FNCHTheme.typography.fieldLabel,
                color = when {
                    !errorText.isNullOrEmpty() -> FNCHTheme.colors.error
                    isFocused -> FNCHTheme.colors.primary
                    else -> FNCHTheme.colors.secondary
                }
            )

            SpacerH(
                Dimensions.ExtraSmallSpacer
            )
        }

        BasicTextField(
            value = value,
            onValueChange = {
                if (!isDisable) {
                    onChange(it)
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(Dimensions.HeightButton)
                .background(
                    color = FNCHTheme.colors.darkenWhite,
                    shape = shape
                )
                .border(
                    border = BorderStroke(
                        width = Dimensions.SmallBorderStroke,
                        color = borderColor
                    ),
                    shape = shape
                )
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },

            enabled = !isDisable,

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

                    if (isSearch) {

                        Icon(
                            painter = painterResource(
                                R.drawable.search
                            ),
                            contentDescription = null,
                            tint = FNCHTheme.colors.secondary
                        )

                        SpacerW(Dimensions.MediumSpacer)
                    }

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

                    if (isPass) {

                        SpacerW(Dimensions.MediumSpacer)

                        Icon(
                            painter = painterResource(
                                R.drawable.open_eye
                            ),
                            modifier = Modifier.clickable{
                                isPasswordVisible = !isPasswordVisible
                            },
                            contentDescription = null,
                            tint = FNCHTheme.colors.secondary
                        )
                    }
                }
            },
            visualTransformation = if (isPass && !isPasswordVisible) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },

        )

        if (!errorText.isNullOrEmpty()) {

            SpacerH(
                Dimensions.ExtraSmallSpacer
            )

            Text(
                text = errorText,
                style = FNCHTheme.typography.fieldLabel,
                color = FNCHTheme.colors.error
            )
        }
    }
}


@Preview
@Composable
fun TestInput() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var text by remember { mutableStateOf("") }

        InputFields(
            onChange = {
                text = it
            },
            placeholder = "place",
            value = text,
            titleText = "test",
            isSearch = true
        )

        SpacerH(
            Dimensions.ExtraSmallSpacer
        )
        InputFields(
            onChange = {
                text = it
            },
            placeholder = "place",
            value = text,
            titleText = "test",
            isPass = true
        )

        SpacerH(
            Dimensions.ExtraSmallSpacer
        )

        InputFields(
            onChange = {},
            placeholder = "",
            value = "value",
            titleText = "test",
            errorText = "test error",
            isSearch = true
        )
    }
}