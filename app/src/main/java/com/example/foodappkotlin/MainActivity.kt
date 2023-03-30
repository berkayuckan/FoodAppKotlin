package com.example.foodappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), FoodsAdapter.FoodItemClickListener  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodRecyclerView=findViewById<RecyclerView>(R.id.recyclerViewFoods)
        val foodArrayList: ArrayList<FoodModel> = ArrayList()


        foodArrayList.add(
            FoodModel(
                "Makarna", "30 dk", R.drawable.ic_makarna,
                """
                4 kişilik bir aile için 
                1 paket makarna 
                5 su bardağı su 
                1 tatlı kaşığı tuz
                Sıvı yağ
                """.trimIndent()
            )
        )

        foodArrayList.add(
            FoodModel(
                "Tavuk Sote", "25 dk", R.drawable.ic_tavukl_sote,
                """
                Yarım kg tavuk göğsü
                2 yemek kaşığı sıvı yağ
                1 tatlı kaşığı domates salçası
                2 adet yeşil biber
                1 adet kırmızı biber
                1 adet soğan
                2 diş sarımsak
                2 adet domates
                Karabiber
                Pul biber
                Tuz
                1 su bardağı su
                """.trimIndent()
            )
        )

        foodArrayList.add(
            FoodModel(
                "Taze Fasulye", "40 dk", R.drawable.ic_fasulye,
                """
                600 gr taze yeşil fasulye (çalı fasulye kullandım)
                2 adet domates
                1 adet soğan
                Yarım çay kaşığı pul biber
                Yarım çay kaşığı karabiber
                2 çay kaşığı tuz
                Yarım çay bardağı zeytinyağı (veya sıvı yağ)
                1,5 yemek kaşığı domates salçası
                2 su bardağı sıcak su
                """.trimIndent()
            )
        )


        val foodAdapter=FoodsAdapter(this,foodArrayList,this)
        val linearLayoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        foodRecyclerView.layoutManager=linearLayoutManager
        foodRecyclerView.adapter=foodAdapter

    }

    override fun onItemClicked(foodModel: FoodModel) {
        val intent=Intent(this@MainActivity,DetailActivity::class.java)
        intent.putExtra("foodModel",foodModel)
        startActivity(intent)
    }
}