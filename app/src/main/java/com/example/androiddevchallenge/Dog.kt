package com.example.androiddevchallenge

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dog(
    val id: String,
    val breed: String,
    val origin: String,
    @DrawableRes val drawableResId: Int,
    @StringRes val descriptionResId: Int = R.string.lorem_ipsum
)
