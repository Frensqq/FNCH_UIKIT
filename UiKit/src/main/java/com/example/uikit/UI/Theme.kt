package com.example.uikit.UI

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun FNCHTheme(
    content: @Composable () -> Unit
){
    val colors = defaultFNCHColor

    val colorScheme = lightColorScheme(
        primary = colors.primary,
        secondary = colors.secondary,
        tertiary = colors.tertiary,
        error =  colors.error,
        background = colors.darkenWhite,
        onPrimary = colors.white,
        surface = colors.grey,
        onSurface = colors.black
    )

    val typography = defaultFNCHTypography()

    CompositionLocalProvider(
        LocalFNCHColor provides colors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = createFNCHTypography(),
            content = content
        )
    }


}

private fun createFNCHTypography(): Typography {
    val type = FNCHType

    return Typography(
        displayLarge = type.ScreenHeader,
        displayMedium = type.ScreenHeader,
        bodyMedium = type.BodyMedium,
        bodySmall = type.BodySmall,
        labelMedium = type.FieldLabel
    )
}

object FNCHTheme {
    val colors: FNCHColor
        @Composable
        get() = LocalFNCHColor.current

    val typography = createFNCHTypography()
}