package com.example.uikit.Cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH

@Composable
fun CandidateCard(
    name: String,
    post: String,
    painter: Painter?
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimensions.LargeRounded))
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
            .border(Dimensions.SmallBorderStroke, FNCHTheme.colors.grey,RoundedCornerShape(
                Dimensions.LargeRounded))
            .padding(vertical = Dimensions.ExtraMediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(Dimensions.LargeAvatarSize)
                .clip(CircleShape)
                .dropShadow(
                    shape =CircleShape,
                    shadow = Shadow(
                        radius = Dimensions.AvatarSmallBlur,
                        spread = Dimensions.ZeroSize,
                        color = FNCHTheme.colors.black.copy(alpha = Dimensions.SmallWeight),
                        offset = DpOffset(x = Dimensions.ZeroSize, y = Dimensions.OneSize)
                    )
                )
                .border(Dimensions.LargeBorderStroke, FNCHTheme.colors.white, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter?: painterResource(R.drawable.avatar),
                modifier = Modifier.fillMaxSize(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        SpacerH(Dimensions.ExtraMediumPadding)

        Text(name,
            style = FNCHTheme.typography.displayMedium,
            color = FNCHTheme.colors.black
        )

        SpacerH(Dimensions.ExtraSmallSpacer)

        Text(
            post,
            style = FNCHTheme.typography.bodyMedium,
            color = FNCHTheme.colors.secondary
        )

    }

}

@Preview
@Composable
fun PreviewCandidateCard(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        CandidateCard("Elena Rodriguez", "Senior Product Desing", painter = null )

    }
}