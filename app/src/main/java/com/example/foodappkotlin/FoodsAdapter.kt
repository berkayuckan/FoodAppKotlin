package com.example.foodappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FoodsAdapter(context:Context, foodList:ArrayList<FoodModel>,foodItemClickListener: FoodItemClickListener): RecyclerView.Adapter<FoodsAdapter.FoodViewHolder>() {

    private val foodList: List<FoodModel>
    private val layoutInflater: LayoutInflater
    private val foodItemClickListener: FoodItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsAdapter.FoodViewHolder {
        val itemView=layoutInflater.inflate(R.layout.row_food,parent,false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodsAdapter.FoodViewHolder, position: Int) {
        val foodModel=foodList.get(position)
        holder.foodName.text=foodModel.foodName
        holder.foodTime.text=foodModel.foodTime
        holder.foodImage.setImageResource(foodModel.foodImage)
        holder.foodCardView.setOnClickListener {
            foodItemClickListener.onItemClicked(foodModel)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    init {
        layoutInflater= LayoutInflater.from(context)
        this.foodList=foodList
        this.foodItemClickListener=foodItemClickListener
    }


    class FoodViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val foodName: TextView
        val foodTime: TextView
        val foodImage: ImageView
        val foodCardView: CardView

        init {
            foodName=itemView.findViewById(R.id.textViewFoodName)
            foodTime=itemView.findViewById(R.id.textViewFoodTime)
            foodImage=itemView.findViewById(R.id.imageViewFood)
            foodCardView=itemView.findViewById(R.id.cardViewFood)
        }

    }

    interface FoodItemClickListener{
        fun onItemClicked(foodModel: FoodModel)
    }

}