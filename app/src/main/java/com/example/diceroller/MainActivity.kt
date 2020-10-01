package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //finding the Button and attaching a listener to know when its been tapped
        //Then we call the rollDice function to roll the dice and update the image
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        //This will show the user a random dice when the app starts rather than a blank space
        rollDice()
    }

    //rollDice function that rolls the dice and updates the image according to the value
    private fun rollDice() {
        //Create a new Dice object and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView2)

        //Store in variable changing dice images ID in accordance to the roll
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //updating image in accordance to the roll
        diceImage.setImageResource(drawableResource)
        //updating contentDescription for screen readers
        diceImage.contentDescription = diceRoll.toString()
    }
}
//A Dice class which varies on the number of sides and a method which rolls the dice randomly
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}