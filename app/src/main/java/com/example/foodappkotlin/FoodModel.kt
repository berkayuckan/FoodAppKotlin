package com.example.foodappkotlin

import java.io.Serializable

data class FoodModel(
    var foodName: String,
    var foodTime: String,
    var foodImage: Int,
    var foodInfo: String
): Serializable
