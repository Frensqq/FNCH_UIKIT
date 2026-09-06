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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH

@Composable
fun CandidateProgress(
    title: String,
    step: Int = 1,
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = Dimensions.ExtraMediumPadding)
        ) {

        var colorStep1 = FNCHTheme.colors.secondary
        var colorStep2 = FNCHTheme.colors.grey
        var colorStep3 = FNCHTheme.colors.grey


        when{
            step == 2 -> {
                colorStep1 = FNCHTheme.colors.primary
                colorStep2 = FNCHTheme.colors.secondary
                colorStep3 = FNCHTheme.colors.grey
            }
            step == 3 -> {
                colorStep1 = FNCHTheme.colors.primary
                colorStep2 = FNCHTheme.colors.primary
                colorStep3 = FNCHTheme.colors.secondary
            }
        }

        Text(
            text = "$title (Шаг $step из 3)",
            style = FNCHTheme.typography.bodySmall,

        )

        SpacerH(Dimensions.SmallSpacer)

        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimensions.SmallSpacer)
        ) {

            Box(modifier = Modifier
                .height(Dimensions.SmallObjectHeight)
                .weight(Dimensions.defaultWeight)
                .clip(CircleShape)
                .background(colorStep1))

            Box(modifier = Modifier
                .height(Dimensions.SmallObjectHeight)
                .weight(Dimensions.defaultWeight)
                .clip(CircleShape)
                .background(colorStep2))

            Box(modifier = Modifier
                .height(Dimensions.SmallObjectHeight)
                .weight(Dimensions.defaultWeight)
                .clip(CircleShape)
                .background(colorStep3)
            )

        }
    }

}

@Preview
@Composable
fun testProgress(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(FNCHTheme.colors.white),
        verticalArrangement = Arrangement.Center) {

        CandidateProgress("Candidate Progress")
        CandidateProgress("Candidate Progress",2)
        CandidateProgress("Candidate Progress",3)

    }

}