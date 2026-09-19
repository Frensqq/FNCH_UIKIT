package com.example.uikit.Cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.Cards.ComponentCards.FNCHDivider
import com.example.uikit.Cards.ComponentCards.fnchCard
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW
import java.nio.file.WatchEvent

@Composable
fun ApplicantDetailsCard(
    name: String,
    surname: String,
    post: String,
    type: String,
    place: String,
    experience: String,
    noticePeriod: String
){

    Column(
        modifier = Modifier.fnchCard(padding = Dimensions.LargePadding),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text("$name $surname",
            style = FNCHTheme.typography.screenHeader,
            )
        SpacerH(Dimensions.ExtraSmallSpacer)
        Text("$post",
            style = FNCHTheme.typography.bodyMedium,
            color = FNCHTheme.colors.secondary
        )
        SpacerH(Dimensions.ExtraMediumPadding)

        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimensions.ExtraSmallSpacer)
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(FNCHTheme.colors.darkenWhite)
                    .padding(vertical = Dimensions.ExtraSmallSpacer, horizontal = Dimensions.MediumSpacer),
                contentAlignment = Alignment.Center
            ) {
                Text(type,
                    style = FNCHTheme.typography.bodySmall,
                    color = FNCHTheme.colors.secondary
                )
            }

            SpacerW(Dimensions.ExtraSmallSpacer)

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(FNCHTheme.colors.darkenWhite)
                    .padding(vertical = Dimensions.ExtraSmallSpacer, horizontal = Dimensions.MediumSpacer)
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(place,
                    style = FNCHTheme.typography.bodySmall,
                    color = FNCHTheme.colors.secondary
                )
            }

        }

        SpacerH(Dimensions.LargePadding)

        FNCHDivider()

        SpacerH(Dimensions.ExtraMediumPadding)

        Row(modifier = Modifier.fillMaxWidth()) {

            Column(Modifier.weight(Dimensions.defaultWeight)) {

                Text("Experience",
                    style = FNCHTheme.typography.bodySmall,
                    color = FNCHTheme.colors.secondary
                    )
                Text(experience,
                    style = FNCHTheme.typography.bodyMedium,
                    color = FNCHTheme.colors.black,
                )

            }

            SpacerW(Dimensions.ExtraMediumPadding)

            Column(Modifier.weight(Dimensions.defaultWeight)) {

                Text("Notice Period",
                    style = FNCHTheme.typography.bodySmall,
                    color = FNCHTheme.colors.secondary
                )
                Text(noticePeriod,
                    style = FNCHTheme.typography.bodyMedium,
                    color = FNCHTheme.colors.black,
                )

            }


        }



    }
}
@Preview
@Composable
fun PreviewApplicantDetailsCard(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        ApplicantDetailsCard(
            "Julian",
            "Sterling",
            "Senior Frontend Developer",
            "Shortlisted",
            "New York, NY",
            "8 Years",
            "Immediate"
        )
    }
}