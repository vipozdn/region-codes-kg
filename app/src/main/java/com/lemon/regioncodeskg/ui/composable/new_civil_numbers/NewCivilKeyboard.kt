package com.lemon.regioncodeskg.ui.composable.new_civil_numbers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lemon.regioncodeskg.R
import com.lemon.regioncodeskg.ui.composable.common.KeyboardItem
import com.lemon.regioncodeskg.ui.keyboards.KeyboardItemData
import com.lemon.regioncodeskg.ui.keyboards.new_civil_keyboard.NewCivilKeyboardBuilder
import com.lemon.regioncodeskg.ui.keyboards.new_civil_keyboard.NewCivilKeyboardItems

@Preview
@Composable
internal fun ContentViewPreview() {
    ContentView()
}

@Composable
internal fun ContentView() {

    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Column(modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 30.dp)
                .wrapContentHeight()
                .width(100.dp)
                .background(colorResource(id = R.color.white)),
                verticalArrangement = Arrangement.Center) {

                Text(modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "01",
                    fontSize = 36.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black))

                Row(modifier = Modifier.wrapContentSize()) {
                    Image(painter = painterResource(id = R.drawable.flag_kyrgyzstan_72dp),
                        contentDescription = "flag_kg")

                    Text(text = "KG",
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black))
                }

            }
        }

        val shape = RoundedCornerShape(10.dp)

        Column(modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 30.dp)
            .fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.Bottom) {
            Row {
                val item1 = getKeyboardItem(NewCivilKeyboardItems.NEW_CIVIL_1)
                val item2 = getKeyboardItem(NewCivilKeyboardItems.NEW_CIVIL_2)
                val item3 = getKeyboardItem(NewCivilKeyboardItems.NEW_CIVIL_3)

                Row(modifier = Modifier
                    .weight(1f)
                    .clip(shape)) {
                    KeyboardItem(item1.text)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Row(modifier = Modifier
                    .weight(1f)
                    .clip(shape)) {
                    KeyboardItem(item2.text)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Row(modifier = Modifier
                    .weight(1f)
                    .clip(shape)) {
                    KeyboardItem(item3.text)
                }
            }
        }
    }
}

private fun getKeyboardItem(id: String): KeyboardItemData {
    return NewCivilKeyboardBuilder
        .getKeyboardItemData(id)
        .keyboardItemData
}