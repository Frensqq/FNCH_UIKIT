package com.example.uikit.UI

import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.uikit.R

data class FNCHTypography(
    val ScreenHeader: TextStyle,
    val Subheader: TextStyle,
    val BodyMedium: TextStyle,
    val BodySmall: TextStyle,
    val FieldLabel: TextStyle
)

fun defaultFNCHTypography(): FNCHTypography{

    fun textStyle(
        fontRes: Int,
        fontSize: Int,
        lineHeight: Int,
        letterSpacing: Float = 0F
    ) = TextStyle(
        fontFamily = FontFamily(Font(fontRes)),
        fontSize = fontSize.sp,
        lineHeight = lineHeight.sp,
        letterSpacing = letterSpacing.sp
    )


    return FNCHTypography(
        ScreenHeader = textStyle(
            R.font.bold,
            24,
            32,
            -0.48f
        ),
        Subheader = textStyle(
            R.font.semi_bold,
            18
            ,24,
            -0.18F
        ),
        BodyMedium = textStyle(
            R.font.regular,
            16
            ,24
        ),
        BodySmall = textStyle(
            R.font.regular,
            14,
            20
        ),
        FieldLabel = textStyle(
            R.font.semi_bold,
            14,
            20
        )
    )

    val FNCHType = defaultFNCHTypography()
}