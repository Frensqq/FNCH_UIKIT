package com.example.uikit.BottomSheet

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.PrimaryButton
import com.example.uikit.Button.SecondaryButton
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.FNCHTheme
import com.example.uikit.UI.SpacerH

@Composable
fun CustomBottomSheet(
    isOpen: Boolean,
    onDismiss: () -> Unit,
    listData: List<BottomSheetData>,
    onChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier,
    sheetMaxHeight: Dp = Dimensions.sheetMaxHeight,
) {
    val density = LocalDensity.current
    val screenHeightPx = with(density) {
        LocalConfiguration.current.screenHeightDp.dp.toPx()
    }
    val maxSheetHeightPx = with(density) { sheetMaxHeight.toPx() }

    var actualSheetHeightPx by remember { mutableFloatStateOf(maxSheetHeightPx) }

    var dragOffsetPx by remember { mutableFloatStateOf(Dimensions.ZeroWeight) }

    LaunchedEffect(isOpen) {
        if (!isOpen) dragOffsetPx = Dimensions.ZeroWeight
    }

    val baseOffsetPx = if (isOpen) Dimensions.ZeroWeight else maxSheetHeightPx
    val animatedBase by animateFloatAsState(
        targetValue = baseOffsetPx,
        animationSpec = tween(durationMillis = Dimensions.defaultAnimateTime),
        label = "sheetBaseOffset"
    )
    val totalOffsetPx = (animatedBase + dragOffsetPx).coerceAtLeast(Dimensions.ZeroWeight)

    val scrimAlpha by animateFloatAsState(
        targetValue = if (isOpen) Dimensions.defaultWeight else Dimensions.ZeroWeight,
        animationSpec = tween(Dimensions.defaultAnimateTime),
        label = "scrimAlpha"
    )

    Box(modifier = modifier.fillMaxSize()) {
        if (scrimAlpha > Dimensions.ZeroWeight) {
            Box(
                Modifier
                    .fillMaxSize()
                    .alpha(scrimAlpha)
                    .background(Color.Black.copy(alpha = Dimensions.MediumAlpha))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { onDismiss() }
            )
        }

        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .heightIn(max = sheetMaxHeight)
                .offset(y = with(density) { totalOffsetPx.toDp() })
                .onSizeChanged { actualSheetHeightPx = it.height.toFloat() },
            shape = RoundedCornerShape(
                topStart = Dimensions.ExtraLargeRounded,
                topEnd = Dimensions.ExtraLargeRounded
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .draggable(
                            orientation = Orientation.Vertical,
                            state = rememberDraggableState { delta ->
                                dragOffsetPx = (dragOffsetPx + delta).coerceAtLeast(Dimensions.ZeroWeight)
                            },
                            onDragStopped = { velocity ->
                                val threshold = actualSheetHeightPx / Dimensions.thresholdBottomSheet
                                val shouldDismiss = dragOffsetPx > threshold || velocity > Dimensions.shouldDismissBottomSheet

                                if (shouldDismiss) {
                                    dragOffsetPx = screenHeightPx
                                    onDismiss()
                                } else {
                                    dragOffsetPx = Dimensions.ZeroWeight
                                }
                            }
                        )
                ) {
                    DefaultDragHandle()
                }

                BottomSheetContent(
                    listData,
                    onChange,
                )
            }
        }
    }
}

@Composable
private fun ItemBottomSheet(
    text: String,
    isCheck: Boolean,
    onClick: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.ExtraMediumPadding)
            .height(Dimensions.TopBarHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text,
            style = FNCHTheme.typography.bodyMedium,
            color = if (isCheck) FNCHTheme.colors.primary else FNCHTheme.colors.black,
            maxLines = 1
        )

        Box(
            modifier = Modifier
                .size(Dimensions.SmallObjectSize)
                .clip(CircleShape)
                .clickable { onClick(!isCheck) }
                .border(
                    Dimensions.MediumBorderStroke,
                    if (isCheck) FNCHTheme.colors.primary else FNCHTheme.colors.secondary,
                    CircleShape
                )
                .padding(Dimensions.ExtraSmallPadding)
                .background(
                    color = if (isCheck) FNCHTheme.colors.primary else Color.Transparent,
                    CircleShape
                )
        )
    }
}

@Composable
private fun BottomSheetContent(
    listData: List<BottomSheetData>,
    onChange: (Int, Boolean) -> Unit,
) {
    Column {
        Text(
            "Select Status",
            style = FNCHTheme.typography.displayMedium,
            modifier = Modifier.padding(horizontal = Dimensions.ExtraLargePadding),
            color = FNCHTheme.colors.black
        )

        SpacerH(Dimensions.ExtraMediumPadding)

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = Dimensions.ExtraMediumPadding)
                .heightIn(max = Dimensions.lazyColumnMaxHeight),
            verticalArrangement = Arrangement.spacedBy(Dimensions.ExtraSmallPadding)
        ) {
            itemsIndexed(listData) { index, item ->
                ItemBottomSheet(
                    text = item.text,
                    isCheck = item.state,
                    onClick = { newState -> onChange(index, newState) }
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimensions.bottomSheetButtonHeight)
                    .border(border = BorderStroke( Dimensions.SmallBorderStroke,FNCHTheme.colors.grey ), RectangleShape)
                    .padding(vertical = Dimensions.ExtraLargePadding, horizontal =  Dimensions.ExtraMediumPadding),
                horizontalArrangement = Arrangement.spacedBy( Dimensions.ExtraMediumPadding)
            ) {
                Box(modifier = Modifier.weight(Dimensions.defaultWeight)) {
                    SecondaryButton({}, "Отменить")
                }
                Box(modifier = Modifier.weight(Dimensions.defaultWeight)) {
                    PrimaryButton({}, "Обновить", true)
                }
            }
        }
    }
}

@Composable
private fun DefaultDragHandle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimensions.ExtraMediumPadding),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = Dimensions.ObjectWidth,
                    height = Dimensions.ExtraSmallObjectHeight
                )
                .clip(CircleShape)
                .background(FNCHTheme.colors.grey)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TestSheetPreview() {
    var isOpen by remember { mutableStateOf(false) }
    var testList by remember {
        mutableStateOf(
            listOf(
                BottomSheetData("В работе", true),
                BottomSheetData("Завершено", false),
                BottomSheetData("Отменено", false),
                BottomSheetData("Черновик", false),
            )
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { isOpen = true }) {
                Text("Открыть")
            }
        }

        CustomBottomSheet(
            isOpen = isOpen,
            onDismiss = { isOpen = false },
            listData = testList,
            onChange = { index, newState ->
                testList = testList.toMutableList().also {
                    it[index] = it[index].copy(state = newState)
                }
            }
        )
    }
}