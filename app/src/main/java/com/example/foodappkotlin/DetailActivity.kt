package com.example.foodappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intentExtras=intent.extras
        val foodModel= intentExtras?.getSerializable("foodModel") as FoodModel
        val foodImageView=findViewById<ImageView>(R.id.detailImageViewFood)
        val foodTimeTextView=findViewById<TextView>(R.id.detailTextViewFoodTime)
        val foodInfo=findViewById<TextView>(R.id.textViewFoodInfo)

        foodImageView.setImageResource(foodModel.foodImage)
        foodTimeTextView.text=foodModel.foodTime
        foodInfo.text=foodModel.foodInfo

    }

}