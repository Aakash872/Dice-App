package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
       //Do a dice roll when the app starts
         rollDice()
    }
// Roll a dice and update the screen with a result
    private fun rollDice() {

    // Create a new object dice with 6 sides

        val dice = Dice()
        val diceRoll = dice.roll()

    //Find the image view in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

    // Determine which drawable id to use based on the dice roll
        diceImage.setImageResource(R.drawable.dice_2)

        val drawableResource = when(diceRoll){
            1 ->  R.drawable.dice_1
            2 ->  R.drawable.dice_2
            3 ->  R.drawable.dice_3
            4 ->  R.drawable.dice_4
            5 ->  R.drawable.dice_5
            else -> R.drawable.dice_6
        }

    // Update the image view with the correct drawable id
    diceImage.setImageResource(drawableResource)

    // Update the content description
    diceRoll.toString().also { diceImage.contentDescription = it }
    }


class Dice {
    fun roll() : Int {
        val numSides = 6
        return (1..numSides).random()
    }

}}
