package com.lemon.regioncodeskg.new_civil_numbers

import com.lemon.regioncodeskg.R
import com.lemon.regioncodeskg.ui.keyboards.new_civil_keyboard.NewCivilKeyboardItems

internal fun keysToResultResId(newCivilIds: List<String>): Int {
    if (newCivilIds.size > 2)
        return R.string.error_result

    return if (newCivilIds[0] == NewCivilKeyboardItems.NEW_CIVIL_0) {
        when(newCivilIds[1]) {
            NewCivilKeyboardItems.NEW_CIVIL_1 -> R.string.bishkek
            NewCivilKeyboardItems.NEW_CIVIL_2 -> R.string.osh
            NewCivilKeyboardItems.NEW_CIVIL_3 -> R.string.batken_region
            NewCivilKeyboardItems.NEW_CIVIL_4 -> R.string.jalal_abad_region
            NewCivilKeyboardItems.NEW_CIVIL_5 -> R.string.naryn_region
            NewCivilKeyboardItems.NEW_CIVIL_6 -> R.string.osh_region
            NewCivilKeyboardItems.NEW_CIVIL_7 -> R.string.talas_region
            NewCivilKeyboardItems.NEW_CIVIL_8 -> R.string.chuy_region
            NewCivilKeyboardItems.NEW_CIVIL_9 -> R.string.issyk_kul_region

            else -> R.string.error_result
        }
    } else {
        R.string.error_result
    }
}