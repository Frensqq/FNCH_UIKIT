package com.example.uikit.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH

private const val TOTAL_STEPS = 3

@Composable
fun CandidateProgress(
    title: String,
    step: Int = 1,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimensions.ExtraMediumPadding)
    ) {
        Text(
            text = "$title (Шаг $step из $TOTAL_STEPS)",
            style = FNCHTheme.typography.bodySmall,
        )

        SpacerH(Dimensions.SmallSpacer)

        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimensions.SmallSpacer)
        ) {
            repeat(TOTAL_STEPS) { index ->
                StepIndicator(
                    color = stepColor(index = index, step = step),
                    modifier = Modifier
                        .height(Dimensions.SmallObjectHeight)
                        .weight(Dimensions.defaultWeight),
                )
            }
        }
    }
}


@Composable
private fun stepColor(index: Int, step: Int): Color {
    val colors = FNCHTheme.colors
    return when {
        index < step - 1 -> colors.primary
        index == step - 1 -> colors.secondary
        else -> colors.grey
    }
}

@Composable
private fun StepIndicator(
    color: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color)
    )
}

@Preview
@Composable
private fun CandidateProgressPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FNCHTheme.colors.white),
        verticalArrangement = Arrangement.Center,
    ) {
        CandidateProgress("Candidate Progress")
        CandidateProgress("Candidate Progress", 2)
        CandidateProgress("Candidate Progress", 3)
    }
}