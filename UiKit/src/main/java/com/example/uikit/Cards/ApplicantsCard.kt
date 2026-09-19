package com.example.uikit.Cards

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.example.uikit.Avatars.UniversalAvatar
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW

@Composable
fun ApplicantsCard(
    name: String,
    surname: String,
    post: String,
    state: String,
    place: String,
    phone: String,
    painter: Painter? = null,
    onClick:()-> Unit
){

    val clipboardManager = LocalClipboardManager.current

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
            .clip(RoundedCornerShape(Dimensions.LargeRounded))
            .background(FNCHTheme.colors.white)
            .border(
                Dimensions.SmallBorderStroke,
                FNCHTheme.colors.darkenWhite,
                RoundedCornerShape(Dimensions.LargeRounded)

            )
            .clickable{
                onClick()
            }
            .padding(Dimensions.ExtraMediumPadding),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(Dimensions.defaultWeight),
            ) {
                UniversalAvatar(
                    painter = painter,
                    state = false,
                    size = Dimensions.HeightButton
                )

                SpacerW(Dimensions.ExtraMediumPadding)

                Column() {
                    Text(
                        "$name $surname",
                        style = FNCHTheme.typography.fieldLabel,
                        color = FNCHTheme.colors.black
                    )

                    Text(
                        "$post",
                        style = FNCHTheme.typography.bodySmall,
                        color = FNCHTheme.colors.secondary
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(Dimensions.SmallAlpha)
                    .width(Dimensions.SnackBarHeight)
                    .clip(RoundedCornerShape(Dimensions.ExtraSmallRounded))
                    .background(FNCHTheme.colors.grey),
                contentAlignment = Alignment.Center
            ) {
                Text(state,
                    modifier = Modifier.padding(vertical = Dimensions.ExtraSmallPadding),
                    style = FNCHTheme.typography.fieldLabel,
                    color = FNCHTheme.colors.white
                )
            }
        }

        SpacerH(
            Dimensions.MediumSpacer
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.place),
                modifier = Modifier.padding(top = Dimensions.ExtraSmallPadding, bottom =  Dimensions.ExtraSmallPadding, end = Dimensions.ExtraSmallPadding ),
                contentDescription = null,
                tint = FNCHTheme.colors.secondary
            )
            Text(
                "$place",
                style = FNCHTheme.typography.bodySmall,
                color = FNCHTheme.colors.secondary
            )
        }

        SpacerH(
            Dimensions.ExtraLargePadding
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.phone),
                modifier = Modifier.padding(top = Dimensions.ExtraSmallPadding, bottom =  Dimensions.ExtraSmallPadding, end = Dimensions.ExtraSmallPadding ),
                contentDescription = null,
                tint = FNCHTheme.colors.secondary
            )
            Text(
                "$phone",
                style = FNCHTheme.typography.bodySmall,
                color = FNCHTheme.colors.secondary
            )
            Icon(
                painter = painterResource(R.drawable.copy),
                modifier = Modifier.padding(top = Dimensions.ExtraSmallPadding, bottom =  Dimensions.ExtraSmallPadding, start = Dimensions.ExtraSmallPadding )
                    .clickable{
                        clipboardManager.setText(AnnotatedString(phone))
                    },
                contentDescription = null,
                tint = FNCHTheme.colors.primary
            )
        }

    }

}


@Preview
@Composable
fun PreviewApplicantsCard(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        ApplicantsCard(
            "Alex",
            "Volkov",
            "Senior Product",
            "Интервью",
            "San Francisco, CA",
            "+1 415 555 0128",
            painterResource(R.drawable.avatar),
        ){

        }
    }
}