package com.example.uikit.UI

import android.graphics.Color


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

)