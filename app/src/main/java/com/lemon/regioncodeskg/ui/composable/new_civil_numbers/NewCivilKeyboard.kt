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
import com.lemon.regioncodeskg.new_civil_numbers.UiEvent
import com.lemon.regioncodeskg.new_civil_numbers.ViewModelState
import com.lemon.regioncodeskg.ui.composable.common.KeyboardRow
import com.lemon.regioncodeskg.ui.keyboards.KeyboardItemData
import com.lemon.regioncodeskg.ui.keyboards.new_civil_keyboard.NewCivilKeyboardBuilder
import com.lemon.regioncodeskg.ui.keyboards.new_civil_keyboard.NewCivilKeyboardItems

@Preview
@Composable
internal fun ContentViewPreview() {
    ContentView(ViewModelState.INITIAL) {}
}

@Composable
internal fun ContentView(state: ViewModelState, onEvent: (UiEvent) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {

        val shape = RoundedCornerShape(10.dp)

        Column(modifier = Modifier
            .wrapContentWidth()
            .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Column(modifier = Modifier
                .padding(horizontal = 30.dp)
                .wrapContentHeight()
                .width(400.dp)
                .background(colorResource(id = R.color.white), shape = shape)
                .clip(shape),
                verticalArrangement = Arrangement.Center) {

                Text(modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    textAlign = TextAlign.Center,
                    text = "01",
                    fontSize = 100.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.black))

                Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    Image(painter = painterResource(id = R.drawable.flag_kyrgyzstan_72dp),
                        contentDescription = "flag_kg")

                    Text(modifier = Modifier.padding(horizontal = 5.dp),
                        text = "KG",
                        fontSize = 48.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.black))
                }

            }
        }

        Column(modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 30.dp)
            .fillMaxSize()
            .weight(1f),
            verticalArrangement = Arrangement.Bottom) {

            KeyboardRow(ids = Triple(NewCivilKeyboardItems.NEW_CIVIL_1,
                NewCivilKeyboardItems.NEW_CIVIL_2,
                NewCivilKeyboardItems.NEW_CIVIL_3))

            Spacer(modifier = Modifier.height(10.dp))

            KeyboardRow(ids = Triple(NewCivilKeyboardItems.NEW_CIVIL_4,
                NewCivilKeyboardItems.NEW_CIVIL_5,
                NewCivilKeyboardItems.NEW_CIVIL_6))

            Spacer(modifier = Modifier.height(10.dp))

            KeyboardRow(ids = Triple(NewCivilKeyboardItems.NEW_CIVIL_7,
                NewCivilKeyboardItems.NEW_CIVIL_8,
                NewCivilKeyboardItems.NEW_CIVIL_9))

            Spacer(modifier = Modifier.height(10.dp))

            KeyboardRow(ids = Triple(NewCivilKeyboardItems.NEW_CIVIL_C,
                null,
                NewCivilKeyboardItems.NEW_CIVIL_0))
        }
    }
}

fun getKeyboardItem(id: String): KeyboardItemData {
    return NewCivilKeyboardBuilder
        .getKeyboardItemData(id)
        .keyboardItemData
}