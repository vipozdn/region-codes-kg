package com.lemon.regioncodeskg.ui.composable.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lemon.regioncodeskg.R

@Composable
internal fun KeyboardItem(text: String, colorResId: Int = R.color.black) {
        Text(modifier = Modifier.background(colorResource(id = R.color.white))
            .fillMaxWidth()
            .padding(vertical = 10.dp),
            text = text,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = colorResId))
}