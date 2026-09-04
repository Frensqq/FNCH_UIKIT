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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme

@Composable
fun DestructiveSolidButton(
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
            contentColor = FNCHTheme.colors.white,
            disabledContentColor = FNCHTheme.colors.white,
            containerColor = FNCHTheme.colors.error,
            disabledContainerColor = FNCHTheme.colors.error
        ),
        contentPadding = PaddingValues(
            vertical = Dimensions.MediumPadding
        ),
    ) {
        Text(
            text = text,
            style = FNCHTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
fun TestDestructiveSolidButton(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        DestructiveSolidButton(
            {},
            "Destructive Solid"
        )
    }
}