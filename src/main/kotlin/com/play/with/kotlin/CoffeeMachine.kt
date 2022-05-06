package com.play.with.kotlin

var currentWater = 400
var currentMilk = 540
var currentBeans = 120
var currentCups = 9
var currentMoney = 550

fun main() {
    printMachineState()
    askAction()
    printMachineState()
}

fun printMachineState() {
    print(
        """
            The coffee machine has:
            $currentWater ml of water
            $currentMilk ml of milk
            $currentBeans g of coffee beans
            $currentCups disposable cups
            $$currentMoney of money
        """.trimIndent()
    )
}

fun makeEspresso() {
    currentMoney += 4
    currentWater -= 250
    currentBeans -=16
}

fun makeLatte() {
    currentMoney += 7
    currentWater -= 350
    currentMilk -= 75
    currentBeans -=20
}

fun makeCappuccino() {
    currentMoney += 6
    currentWater -= 200
    currentMilk -= 100
    currentBeans -=12
}

fun askAction() {
    println("Write action (buy, fill, take):")
    val userInput = readLine()!!
    when (userInput) {
        "buy" -> askChoice()
        "fill" -> fillMachine()
        "take" -> takeMoney()
    }
}

fun fillMachine() {
    print("Write how many ml of water do you want to add:")
    val addWater = readLine()!!.toInt()
    currentWater += addWater
    print("Write how many ml of milk do you want to add:")
    val addMilk = readLine()!!.toInt()
    currentMilk += addMilk
    print("Write how many grams of coffee beans do you want to add:")
    val addBeans = readLine()!!.toInt()
    currentBeans += addBeans
    print("Write how many disposable cups of coffee do you want to add:")
    val addCups = readLine()!!.toInt()
    currentCups += addCups
}

fun takeMoney() {
    print("I gave you $${currentMoney}")
    currentMoney = 0
}

fun askChoice() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val userChoice = readLine()!!.toInt()
    when (userChoice) {
        1 -> makeEspresso()
        2 -> makeLatte()
        3 -> makeCappuccino()
    }
    --currentCups
}