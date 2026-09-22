package com.example.uikit.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import kotlin.random.Random

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    enabled: Boolean
) {
    val primaryColor = FNCHTheme.colors.primary
    val shape = RoundedCornerShape(Dimensions.SmallRounded)

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.HeightButton)
            .clip(shape)
            .drawWithCache {

                val random = Random(123)

                val noiseCount = (size.width * size.height *  Dimensions.MediumAlpha).toInt()

                val noisePoints = List(noiseCount) {
                    Offset(
                        x = random.nextFloat() * size.width,
                        y = random.nextFloat() * size.height
                    )
                }

                onDrawBehind {
                    drawRect(primaryColor)

                    if (!enabled) {
                        drawPoints(
                            points = noisePoints,
                            pointMode = PointMode.Points,
                            color = Color.White.copy(alpha = Dimensions.MediumAlpha),
                            strokeWidth = Dimensions.LargeAlpha
                        )
                    }
                }
            },
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            contentColor = FNCHTheme.colors.white,
            disabledContentColor = FNCHTheme.colors.white,
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(
            vertical = Dimensions.MediumPadding
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            style = FNCHTheme.typography.bodyMedium,
            color = FNCHTheme.colors.white
        )
    }
}

@Preview
@Composable
fun TestButton(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        PrimaryButton(
            {},
            "Primary Default",
            false
        )
    }
}