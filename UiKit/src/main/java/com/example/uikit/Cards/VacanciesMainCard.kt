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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.Avatars.UniversalAvatar
import com.example.uikit.Cards.ComponentCards.FNCHDivider
import com.example.uikit.Cards.ComponentCards.fnchCard
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW

@Composable
fun VacanciesMainCard(
    avTitle: String,
    post: String,
    team: String,
    time: String,
    countApplication: Int,
    minCost: Int,
    maxCost: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fnchCard(),
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(Dimensions.ExtraMediumPadding)) {

            UniversalAvatar(
                state = false,
                initials = avTitle,
                colorText = FNCHTheme.colors.primary,
                colorBack = FNCHTheme.colors.grey,
                textStyle = FNCHTheme.typography.bodyMedium.copy(fontWeight = FontWeight(800)),
                size = Dimensions.HeightButton
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(Dimensions.ExtraSmallPadding)
            ) {
                Text(
                    post,
                    style = FNCHTheme.typography.bodySmall,
                    color = FNCHTheme.colors.black
                )

                Row(

                ) {

                    Icon(
                        painter = painterResource(com.example.uikit.R.drawable.town),
                        modifier = Modifier.padding(top = Dimensions.ExtraSmallPadding, bottom =  Dimensions.ExtraSmallPadding, end = Dimensions.ExtraSmallPadding ),
                        contentDescription = null,
                        tint = FNCHTheme.colors.secondary
                    )
                    Text(
                        "$team",
                        style = FNCHTheme.typography.bodySmall,
                        color = FNCHTheme.colors.secondary
                    )

                    SpacerW(Dimensions.ExtraMediumPadding)

                    Icon(
                        painter = painterResource(com.example.uikit.R.drawable.clock),
                        modifier = Modifier.padding(top = Dimensions.ExtraSmallPadding, bottom =  Dimensions.ExtraSmallPadding, end = Dimensions.ExtraSmallPadding ),
                        contentDescription = null,
                        tint = FNCHTheme.colors.secondary
                    )
                    Text(
                        "$time",
                        style = FNCHTheme.typography.bodySmall,
                        color = FNCHTheme.colors.secondary
                    )


                }
                Row() {
                    Icon(
                        painter = painterResource(com.example.uikit.R.drawable.cash),
                        modifier = Modifier.padding(top = Dimensions.ExtraSmallPadding, bottom =  Dimensions.ExtraSmallPadding, end = Dimensions.ExtraSmallPadding ),
                        contentDescription = null,
                        tint = FNCHTheme.colors.secondary
                    )
                    Text(
                        "$${minCost}k - $${maxCost}k",
                        style = FNCHTheme.typography.fieldLabel,
                        color = FNCHTheme.colors.black
                    )

                }
            }
        }

        SpacerH(Dimensions.ExtraMediumPadding)

        FNCHDivider(color = FNCHTheme.colors.grey)

        SpacerH(Dimensions.ExtraMediumPadding)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom

        ) {

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text("$countApplication",
                    style = FNCHTheme.typography.bodySmall,
                    color = FNCHTheme.colors.primary
                )

                Text("APPLICANTS",
                    style = FNCHTheme.typography.bodySmall,
                    color = FNCHTheme.colors.secondary
                )
            }

            Icon(painter = painterResource(R.drawable.right),
                contentDescription = null,
                tint = FNCHTheme.colors.secondary,
                modifier = Modifier.padding(
                    bottom = Dimensions.ExtraMediumPadding
                ).clickable{
                    onClick()
                }
            )

        }
    }
}


@Preview
@Composable
fun PreviewVacanciesMainCard(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        VacanciesMainCard(
            "PD",
            "Senior Product Designer",
            "Product Team",
            "Full-time",
            24,
            120,
            160
        ){

        }
    }
}