package com.play.with.kotlin

class CoffeeMachine {
    private var currentWater = 400
    private var currentMilk = 540
    private var currentBeans = 120
    private var currentCups = 9
    private var currentMoney = 550

    private fun printMachineState() {
        println(
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

    private fun makeEspresso() {
        val cost = 4
        val water = 250
        val milk = 0
        val beans = 16
        if (checkResources(water, milk, beans)) {
            updateCurrent(cost, water, milk, beans)
        }
    }

    private fun makeLatte() {
        val cost = 7
        val water = 350
        val milk = 75
        val beans = 20
        if (checkResources(water, milk, beans)) {
            updateCurrent(cost, water, milk, beans)
        }
    }

    private fun makeCappuccino() {
        val cost = 6
        val water = 200
        val milk = 100
        val beans = 12
        if (checkResources(water, milk, beans)) {
            updateCurrent(cost, water, milk, beans)
        }
    }

    private fun updateCurrent(cost: Int, water: Int, milk: Int, beans: Int) {
        currentMoney += cost
        currentWater -= water
        currentMilk -= milk
        currentBeans -= beans
        --currentCups
    }

    private fun checkResources(neededWater: Int, neededMilk: Int, neededBeans: Int): Boolean {
        val enoughWater = neededWater <= currentWater
        val enoughMilk = neededMilk <= currentMilk
        val enoughBeans = neededBeans <= currentBeans
        val canMakeCoffee = enoughWater && enoughMilk && enoughBeans
        if (canMakeCoffee) {
            println("I have enough resources, making you a coffee!")
        } else {
            println(
                when {
                    !enoughWater -> "Sorry, not enough water!"
                    !enoughMilk -> "Sorry, not enough milk!"
                    !enoughBeans -> "Sorry, not enough beans!"
                    else -> "Something went wrong"
                }
            )
        }
        return canMakeCoffee
    }

    fun askAction() {
        var mustExit = false
        do {
            print("Write action (buy, fill, take, remaining, exit):")
            val userInput = readLine()!!.trim()
            when (userInput) {
                "buy" -> askChoice()
                "fill" -> fillMachine()
                "take" -> takeMoney()
                "remaining" -> printMachineState()
                "exit" -> mustExit = true
            }
        } while (!mustExit)
    }

    private fun fillMachine() {
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

    private fun takeMoney() {
        println("I gave you $${currentMoney}")
        currentMoney = 0
    }

    private fun askChoice() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val userChoice = readLine()!!
        when (userChoice) {
            "1" -> makeEspresso()
            "2" -> makeLatte()
            "3" -> makeCappuccino()
            "back" -> return
        }
    }
}



