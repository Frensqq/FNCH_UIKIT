package com.example.uikit.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import kotlin.random.Random

@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    text: String,
) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimensions.HeightButton),

        shape = RoundedCornerShape(Dimensions.SmallRounded),
        colors = ButtonDefaults.buttonColors(
            contentColor = FNCHTheme.colors.primary,
            disabledContentColor = FNCHTheme.colors.primary,
            containerColor = FNCHTheme.colors.white,
            disabledContainerColor = FNCHTheme.colors.white
        ),
        contentPadding = PaddingValues(
            vertical = Dimensions.MediumPadding
        ),
        border = BorderStroke(2.dp, FNCHTheme.colors.primary)

    ) {
        Text(
            text = text,
            style = FNCHTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
fun TestSecondaryButton(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        SecondaryButton(
            {},
            "Secondary"
        )
    }
}