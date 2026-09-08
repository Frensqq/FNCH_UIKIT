package com.example.uikit.TextArea

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.Input.InputFields
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH
import org.w3c.dom.Text

@Composable
fun TextArea(
    value: String,
    onChangeValue: (String)-> Unit,
    placeholder: String
){

    BasicTextField(
        value = value,
        onValueChange = {
            onChangeValue(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = Dimensions.MinTextAreaHeight)
            .clip(RoundedCornerShape(Dimensions.LargeRounded))
            .background(FNCHTheme.colors.white)
            .border(
                width = Dimensions.SmallBorderStroke,
                FNCHTheme.colors.grey,
                RoundedCornerShape(Dimensions.LargeRounded)
            ).padding(
                Dimensions.ExtraMediumPadding
            ),
        textStyle = FNCHTheme.typography.bodyMedium,
        ){
        if (value.isNullOrEmpty()){
            Text(placeholder,
                style = FNCHTheme.typography.bodyMedium,
                color = FNCHTheme.colors.secondary
                )
        }
    }

}


@Preview
@Composable
fun TestInput() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        var text by remember { mutableStateOf("") }

        TextArea(text, {text = it }, "Brief overview of the practical task if \n" +
                "applicable...")
    }
}