package com.example.uikit.UI

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun FNCHTheme(
    colors: FNCHColor = defaultFNCHColor,
    typography: FNCHTypography = defaultFNCHTypography,
    content: @Composable () -> Unit
) {
    val colorScheme = remember(colors) {
        lightColorScheme(
            primary = colors.primary,
            secondary = colors.secondary,
            tertiary = colors.tertiary,
            error = colors.error,
            background = colors.darkenWhite,
            onPrimary = colors.white,
            surface = colors.grey,
            onSurface = colors.black
        )
    }

    val materialTypography = remember(typography) {
        Typography(
            displayLarge = typography.screenHeader,
            displayMedium = typography.subheader,
            bodyMedium = typography.bodyMedium,
            bodySmall = typography.bodySmall,
            labelMedium = typography.fieldLabel,
            displaySmall = typography.displaySmall
        )
    }

    CompositionLocalProvider(
        LocalFNCHColor provides colors,
        LocalFNCHTypography provides typography,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = materialTypography,
            content = content
        )
    }
}

object FNCHTheme {
    val colors: FNCHColor
        @Composable get() = LocalFNCHColor.current

    val typography: FNCHTypography
        @Composable get() = LocalFNCHTypography.current
}
