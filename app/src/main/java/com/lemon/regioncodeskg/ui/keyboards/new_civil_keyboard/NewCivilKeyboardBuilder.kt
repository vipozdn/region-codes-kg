package com.lemon.regioncodeskg.ui.keyboards.new_civil_keyboard

import com.lemon.regioncodeskg.R
import com.lemon.regioncodeskg.ui.keyboards.KeyboardItemData

enum class NewCivilKeyboardBuilder(val keyboardItemData: KeyboardItemData) {

    NEW_CIVIL_1(KeyboardItemData("NC_1", "1")),
    NEW_CIVIL_2(KeyboardItemData("NC_2", "2")),
    NEW_CIVIL_3(KeyboardItemData("NC_3", "3")),
    NEW_CIVIL_4(KeyboardItemData("NC_4", "4")),
    NEW_CIVIL_5(KeyboardItemData("NC_5", "5")),
    NEW_CIVIL_6(KeyboardItemData("NC_6", "6")),
    NEW_CIVIL_7(KeyboardItemData("NC_7", "7")),
    NEW_CIVIL_8(KeyboardItemData("NC_8", "8")),
    NEW_CIVIL_9(KeyboardItemData("NC_9", "9")),
    NEW_CIVIL_0(KeyboardItemData("NC_0", "0")),
    NEW_CIVIL_C(KeyboardItemData("NC_C", "C", R.color.red_c));


    companion object {
        fun getKeyboardItemData(id: String): NewCivilKeyboardBuilder {
            return when (id) {
                NewCivilKeyboardItems.NEW_CIVIL_1 -> {
                    NEW_CIVIL_1
                }
                NewCivilKeyboardItems.NEW_CIVIL_2 -> {
                    NEW_CIVIL_2
                }
                NewCivilKeyboardItems.NEW_CIVIL_3 -> {
                    NEW_CIVIL_3
                }
                NewCivilKeyboardItems.NEW_CIVIL_4 -> {
                    NEW_CIVIL_4
                }
                NewCivilKeyboardItems.NEW_CIVIL_5 -> {
                    NEW_CIVIL_5
                }
                NewCivilKeyboardItems.NEW_CIVIL_6 -> {
                    NEW_CIVIL_6
                }
                NewCivilKeyboardItems.NEW_CIVIL_7 -> {
                    NEW_CIVIL_7
                }
                NewCivilKeyboardItems.NEW_CIVIL_8 -> {
                    NEW_CIVIL_8
                }
                NewCivilKeyboardItems.NEW_CIVIL_9 -> {
                    NEW_CIVIL_9
                }
                NewCivilKeyboardItems.NEW_CIVIL_0 -> {
                    NEW_CIVIL_0
                }
                NewCivilKeyboardItems.NEW_CIVIL_C -> {
                    NEW_CIVIL_C
                }
                else -> {
                    throw(java.lang.IllegalStateException())
                }
            }
        }
    }
}