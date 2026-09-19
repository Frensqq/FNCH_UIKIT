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
import androidx.compose.material3.Icon
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

@Composable
fun VacanciesCard(
    post: String,
    team: String,
    time: String,
    state: String,
    countApplication: Int,
    minCost: Int,
    maxCost: Int,
    onClick: () -> Unit
){
    Column(
        modifier = Modifier.fnchCard(),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Dimensions.ExtraSmallPadding)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
                ) {
                Text(post,
                    style = FNCHTheme.typography.fieldLabel,
                    color = FNCHTheme.colors.black,
                    modifier = Modifier.weight(Dimensions.LargeAlpha)
                )

                Box(
                    modifier = Modifier
                        .weight(Dimensions.SmallAlpha)
                        .width(Dimensions.SnackBarHeight)
                        .clip(CircleShape)
                        .background(FNCHTheme.colors.grey),
                    contentAlignment = Alignment.Center
                ) {
                    Text(state,
                        modifier = Modifier.padding(vertical = Dimensions.ExtraSmallPadding),
                        style = FNCHTheme.typography.fieldLabel,
                        color = FNCHTheme.colors.secondary
                    )
                }
            }
            Text(
                "$team • $time",
                style = FNCHTheme.typography.bodySmall,
                color = FNCHTheme.colors.secondary
            )

        }

        SpacerH(Dimensions.ExtraMediumPadding)

        FNCHDivider()

        SpacerH(Dimensions.ExtraMediumPadding)

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.cash),
                modifier = Modifier.padding(Dimensions.ExtraSmallPadding),
                contentDescription = null,
                tint = FNCHTheme.colors.secondary
            )
            Text("$${minCost}k - $${maxCost}k",
                style = FNCHTheme.typography.bodySmall,
                color = FNCHTheme.colors.black
                )

            SpacerW(Dimensions.LargePadding)

            Icon(
                painter = painterResource(R.drawable.candidates),
                modifier = Modifier.padding(Dimensions.ExtraSmallPadding),
                contentDescription = null,
                tint = FNCHTheme.colors.secondary
            )
            Text("$countApplication Applicants",
                style = FNCHTheme.typography.bodySmall,
                color = FNCHTheme.colors.black
            )
        }
    }
}


@Preview
@Composable
fun PreviewVacanciesCard(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        VacanciesCard(
            "Senior Product Designer",
            "Product Team",
            "Full-time",
            "Active",
            24,
            120,
            160
        ){

        }

    }
}