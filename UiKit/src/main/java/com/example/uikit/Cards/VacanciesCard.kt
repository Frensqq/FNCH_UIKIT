package com.example.uikit.Cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme

@Composable
fun VacanciesCard(
    post: String,
    team: String,
    time: String,
    state: String,
    countApplication: Int,
    minCost: Int,
    maxCost: Int
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .dropShadow(
                shape = RoundedCornerShape(Dimensions.LargeRounded),
                shadow = Shadow(
                    radius = Dimensions.CardBlur,
                    spread = Dimensions.ZeroSize,
                    color = FNCHTheme.colors.black.copy(alpha = Dimensions.SmallWeight),
                    offset = DpOffset(x = Dimensions.ZeroSize, y = Dimensions.LargeBorderStroke)
                )
            )
            .background(FNCHTheme.colors.white)
            .border(
                Dimensions.SmallBorderStroke,
                FNCHTheme.colors.darkenWhite,
                RoundedCornerShape(Dimensions.LargeRounded)

            )
            .clip(RoundedCornerShape(Dimensions.LargeRounded))
            .padding(Dimensions.ExtraMediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Dimensions.ExtraSmallPadding)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
                ) {
                Text(post,
                    style = FNCHTheme.typography.labelMedium,
                    color = FNCHTheme.colors.black,
                    modifier = Modifier.weight(1f)
                )

                Box(
                    modifier = Modifier
                        .width(Dimensions.SnackBarHeight)
                        .clip(CircleShape)
                        .background(FNCHTheme.colors.grey),
                    contentAlignment = Alignment.Center
                ) {
                    Text(team,
                        modifier = Modifier.padding(vertical = Dimensions.ExtraSmallPadding),
                        style = FNCHTheme.typography.labelMedium,
                        color = FNCHTheme.colors.secondary
                    )
                }
            }
            Text(
                "$team • $time",


            )

        }


        Row() {

        }
    }
}