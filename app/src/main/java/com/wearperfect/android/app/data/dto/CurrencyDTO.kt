package com.wearperfect.android.app.data.dto

data class CurrencyDTO (
    val id: Byte,
    val name: String,
    val shortName: String,
    val desc: String,
    val thumbnail: String,
    val sourceLink: String,
    val countryId: Int,
    val active: Boolean
)
