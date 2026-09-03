package com.example.uikit.UI

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


data class FNCHColor(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val error: Color,
    val white: Color,
    val black: Color,
    val grey: Color,
    val darkenWhite: Color,
)

val defaultFNCHColor = FNCHColor(
    primary = Color(0xff004AC6),
    secondary = Color(0xff505F76),
    tertiary = Color(0xff943700),
    error = Color(0xffBA1A1A),
    white = Color(0xffFFFFFF),
    black = Color(0xff000000),
    grey = Color(0xffC3C6D7),
    darkenWhite = Color(0xffFAF8FF)
)

val LocalFNCHColor = staticCompositionLocalOf { defaultFNCHColor }
