package com.example.fitbody.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FitBodyAction(
    val day: Int?,
    @StringRes val caption: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
)