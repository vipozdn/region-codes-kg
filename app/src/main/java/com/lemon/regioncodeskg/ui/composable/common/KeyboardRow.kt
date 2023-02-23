package com.lemon.regioncodeskg.ui.composable.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.lemon.regioncodeskg.new_civil_numbers.composable.getKeyboardItem

@Composable
fun KeyboardRow(ids: Triple<String, String?, String>) {
    val shape = RoundedCornerShape(10.dp)

    Column(modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.Bottom) {
        Row {
            val item1 = getKeyboardItem(ids.first)
            val item2 = ids.second?.let { getKeyboardItem(it) }
            val item3 = getKeyboardItem(ids.third)

            Row(modifier = Modifier
                .weight(1f)
                .clip(shape)) {
                KeyboardItem(item1.text, item1.colorResource)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier
                .weight(1f)
                .clip(shape)) {
                item2?.let { KeyboardItem(item2.text, item2.colorResource) }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier
                .weight(1f)
                .clip(shape)) {
                KeyboardItem(item3.text, item3.colorResource)
            }
        }
    }
}