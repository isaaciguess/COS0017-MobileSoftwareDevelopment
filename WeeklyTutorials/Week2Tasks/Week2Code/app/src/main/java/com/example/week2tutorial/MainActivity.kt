package com.example.week2tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.week2tutorial.ui.theme.Week2TutorialTheme

import java.util.Random


fun main()
{
    val numberOfFish = 50
    val numberOfPlants = 23
    println("Number of Fish: ${numberOfFish} \n Number of Plants ${numberOfPlants}")
    printHello_2_1()
    conditionals_2_2(numberOfFish, numberOfPlants)
    conditonalRanges_2_3(numberOfFish)
    multipleConditionals_2_4(numberOfFish)
    nullOperator_2_5()
    loops_2_7()
    feedTheFish_2_8()
    filters_2_9()
    buildAquarium_2_10()
    buildConstructorAquarium_2_11()

}

fun printHello_2_1()
{
    println("Tutorial Task 2.1 Hello Kotlin")
    println("-----------------------------------------------------")
    println("Hello World")
    println("-----------------------------------------------------")
}

fun conditionals_2_2(numberOfFish: Int, numberOfPlants: Int)
{
    println("Tutorial Task 2.2 Compare Conditionals and booleans")
    println("-----------------------------------------------------")
    if (numberOfFish > numberOfPlants)
    {
        println("Good Ratio!")
    } else {
      println("Unhealthy ratio")
    }
    println("-----------------------------------------------------")
}

fun conditonalRanges_2_3(numberOfFish: Int)
{
    println("Tutorial Task 2.3 Conditional Ranges")
    println("-----------------------------------------------------")
    if (numberOfFish in 1..100) {
        println(numberOfFish)
    }
    println("-----------------------------------------------------")
}

fun multipleConditionals_2_4(numberOfFish: Int)
{
    println("Tutorial Task 2.4 Multiple Conditionals")
    println("-----------------------------------------------------")
    if (numberOfFish == 0) {
        println("Empty tank")
    } else if (numberOfFish < 40) {
        println("Got fish!")
    } else {
        println("That's a lot of fish!")
    }
    println("-----------------------------------------------------")
}

fun nullOperator_2_5()
{
    println("Tutorial Task 2.5 nullable types, and shorthand operators")
    println("-----------------------------------------------------")
    var fishFoodTreats: Int? = 6
    fishFoodTreats = fishFoodTreats?.dec() ?: 0
    println(fishFoodTreats)
    println("-----------------------------------------------------")
    fishFoodTreats = null
    fishFoodTreats = fishFoodTreats?.dec() ?: 0
    println(fishFoodTreats)
    println("-----------------------------------------------------")
}

fun arrays_2_6()
{
    println("Tutorial Task 2.6 array and list Demonstration")
    println("-----------------------------------------------------")
    val school = listOf("mackerel", "trout", "halibut")
    println(school)

    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.remove("shark")
    println(myList)

    val school1 = arrayOf("shark", "salmon", "minnow")
    println(java.util.Arrays.toString(school1))

    val mix = arrayOf("fish", 2)
    println(java.util.Arrays.toString(mix))

    val numbers = intArrayOf(1,2,3)
    println(java.util.Arrays.toString(numbers))

    val numbers1 = intArrayOf(4,5,6)
    val numbers2 = numbers1 + numbers
    println(numbers2[5])
    println("-----------------------------------------------------")
}

fun loops_2_7()
{
    println("Tutorial Task 2.7 Loop Demonstration")
    println("-----------------------------------------------------")
    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }
    println("$bubbles bubbles in the water\n")

    do {
        bubbles--
    } while (bubbles > 50)
    println("$bubbles bubbles in the water\n")

    repeat(2) {
        println("A fish is swimming")
    }
    println("-----------------------------------------------------")
}

fun randomDay() : String {

    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun feedTheFish_2_8() {

    println("Tutorial Task 2.8 Function Demonstration ")
    println("-----------------------------------------------------")
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("-----------------------------------------------------")
}

fun filters_2_9(){
    println("Tutorial Task 2.9 Filter Demonstration")
    println("-----------------------------------------------------")
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println( decorations.filter {it[0] == 'p'})
    println("-----------------------------------------------------")
}

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    fun printSize()
    {
        println(
            "Width $width cm" +
            "Length: $length cm" +
            "Height: $height cm"
        )
    }
}

fun buildAquarium_2_10(){
    println("Tutorial Task 2.10 Building class Demonstration")
    println("-----------------------------------------------------")
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()
    println("-----------------------------------------------------")
}


class aquariumWithConstructors(var length: Int = 100, var width: Int = 100, var height: Int = 40)
{
    constructor(numberOfFish: Int) : this(){
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }
    init{
        println("aquarium initializing")
    }
    init{
        println("Volume: ${width * length * height / 1000} l")
    }
    fun printSize()
    {
        println(
            "Width $width cm" +
                    "Length: $length cm" +
                    "Height: $height cm"
        )
    }
}

fun buildConstructorAquarium_2_11()
{
    println("Tutorial Task 2.11 Building class with constructor Demonstration")
    println("-----------------------------------------------------")
    val aquarium1 = aquariumWithConstructors()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = aquariumWithConstructors(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = aquariumWithConstructors(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = aquariumWithConstructors(width = 25, height = 35, length = 110)
    aquarium4.printSize()
    val aquarium5 = aquariumWithConstructors(numberOfFish = 29)
    aquarium5.printSize()
    println("Volume: ${aquarium5.width * aquarium5.length * aquarium5.height / 1000} l")
    println("-----------------------------------------------------")
}



