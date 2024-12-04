package com.example.w2d

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
import com.example.w2d.ui.theme.W2DTheme

fun main()
{

    CounterDemo()
    greetStudent("Hello", "mate")
}

fun greetStudent(greeting: String = "Welcome", name: String?)
{
    println("$greeting ${formatName(name)}")
}

fun formatName(name: String?) = name ?: "random student"

fun CounterDemo()
{
    val c = Counter("counterZero")
    val c1 = Counter("counterOne")

    val counters = listOf(c,c1,c)
    printCounters(counters)


    for (x in 1..4)
    {
        counters[1].increment()
    }
    printCounters(counters)

    for (x in 1 until 7){
        counters[0].increment()
    }
    printCounters(counters)
}



fun printCounters(counters: List<Counter>)
{
    for (c in counters){
        println("${c.name} is ${c.count}")
    }
    println("-------")
}

class Counter(val name: String)
{
    var count = 0

    fun increment()
    {
        count += 1
    }
}