package com.lemon.regioncodeskg.ui.composable.new_civil_numbers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lemon.regioncodeskg.R
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
internal fun ContentViewPreview() {
    ContentView()
}

@Composable
internal fun ContentView() {

    Column(modifier = Modifier
        .padding(vertical = 10.dp, horizontal = 30.dp)
        .wrapContentHeight()
        .width(100.dp)
        .background(colorResource(id = R.color.white))) {

        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {

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

}