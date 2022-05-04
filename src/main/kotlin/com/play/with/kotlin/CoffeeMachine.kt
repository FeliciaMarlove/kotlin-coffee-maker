package com.play.with.kotlin

fun main() {
    val neededWater = 200
    val neededMilk = 50
    val neededBeans = 15

    print("Write how many ml of water the coffee machine has:")
    val actualWater = readLine()!!.toInt()
    print("Write how many ml of milk the coffee machine has:")
    val actualMilk = readLine()!!.toInt()
    print("Write how many grams of coffee beans the coffee machine has:")
    val actualBeans = readLine()!!.toInt()
    print("Write how many cups of coffee you will need:")
    val coffeesAsked = readLine()!!.toInt()

   if (coffeesAsked * neededWater <= actualWater && coffeesAsked * neededBeans <= actualBeans && coffeesAsked * neededMilk <= actualMilk) {
        val waterOverflow = (actualWater - (coffeesAsked * neededWater)) / neededWater
        val beansOverflow = (actualBeans - (coffeesAsked * neededBeans)) / neededBeans
        val milkOverflow = (actualMilk - (coffeesAsked * neededMilk)) / neededMilk
        val overflow = minOf(waterOverflow, milkOverflow, beansOverflow)
        print("Yes, I can make that amount of coffee")
        if (overflow >= 1) print(" (and even $overflow more than that)")
    } else {
        val waterCapacity = actualWater / neededWater
        val beansCapacity = actualBeans / neededBeans
        val milkCapacity = actualMilk / neededMilk
        val capacity = minOf(waterCapacity, beansCapacity, milkCapacity)
        print("No, I can make only $capacity cups of coffee")
    }


}
