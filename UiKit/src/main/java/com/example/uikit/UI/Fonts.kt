package com.example.uikit.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.uikit.R

data class FNCHTypography(
    val screenHeader: TextStyle,
    val subheader: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val fieldLabel: TextStyle,
    val displaySmall: TextStyle
)

private fun textStyle(
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

val defaultFNCHTypography: FNCHTypography = FNCHTypography(
    screenHeader = textStyle(R.font.bold, 24, 32, -0.48f),
    subheader = textStyle(R.font.semi_bold, 18, 24, -0.18F),
    bodyMedium = textStyle(R.font.regular, 16, 24),
    bodySmall = textStyle(R.font.regular, 14, 20),
    fieldLabel = textStyle(R.font.semi_bold, 14, 20),
    displaySmall = textStyle(R.font.semi_bold, 12, 16)
)

val LocalFNCHTypography = staticCompositionLocalOf { defaultFNCHTypography }