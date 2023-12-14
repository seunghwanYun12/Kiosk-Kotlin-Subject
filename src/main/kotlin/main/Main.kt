package main

import db.DataBase
import db.Food
import kotlin.math.floor

fun String.isInt(): Boolean = this.matches("[0-9]+".toRegex())
val dataBase = DataBase.getInstance()

fun main(args: Array<String>) {
    println("######키오스크 작동시작######")
    var orderList: Array<Array<Food>> = emptyArray()

    while (true) { // 주문 하나
        var basket: Array<Food> = emptyArray()
        var insertMoney = 0.0

        while (true) { // 메뉴 선택
            println("---------------------")
            println(getNowStateMessage(insertMoney,basket))
            val chosenMenu = chooseMenu() ?: return
            when (chosenMenu) {
                "money" -> { // 돈 추가 프로세스
                    val chosenMoney = chooseMoney() ?:continue
                    insertMoney += chosenMoney
                    println("$chosenMoney 달러 추가 완료, 현재 달러 : $insertMoney\n")
                }

                "food" -> { // 음식 선택 프로세스
                    val chosenFoodMenu = chooseFoodMenu() ?: continue
                    val chosenFood = chooseFood(chosenFoodMenu) ?: continue
                    basket = basket.plus(chosenFood)
                }

                "basket" -> { // 장바구니 확인, 주문 완료 프로세스

                }
            }
        }
        //주문 완료 프로세스
        orderList = orderList.plus(basket)
    }
}

fun getNowStateMessage(insertMoney:Double,basket:Array<Food>):String {
    var price = 0.0
    var message = "[Now State]\n"
    message += "장바구니 : \n"
    if(basket.isEmpty()) message += "비어있음\n"
    else{
        basket.forEach {
            message += "$it\n"
            price += it.price
        }
    }
    price = floor(price*10) /10
    message += "필요 금액 : $price\n"
    message += "투입 금액 : $insertMoney\n"
    return message
}

fun chooseMenu(): String? {
    while (true) {
        var message = "[MENU]\n"
        message += "1. 돈 넣기\n"
        message += "2. 음식 메뉴 선택\n"
        message += "3. 장바구니\n"
        message += "0. 종료"
        println(message)

        val chooseNum = numberChoose(0,3)?:continue

        return when (chooseNum) {
            1 -> "money"
            2 -> "food"
            3 -> "basket"
            else -> null
        }
    }
}

fun chooseMoney():Double?{
    while (true) {
        var moneyList = dataBase.moneyList
        var message = "[Money MENU]\n"
        for (i in moneyList.indices) {
            message += "${i + 1}. ${moneyList[i].displayInfo}\n"
        }
        message += "0. 처음으로\t|\t처음으로"
        println(message)

        val chooseNum = numberChoose(0,moneyList.size)?:continue

        return if (chooseNum == 0) null else moneyList[chooseNum - 1].cost
    }
}

fun chooseFoodMenu(): String? {
    while (true) {
        var menuList = dataBase.menuList
        var message = "[${dataBase.storeName} MENU]\n"
        for (i in menuList.indices) {
            message += "${i + 1}. ${menuList[i].name}\t|\t${menuList[i].displayInfo}\n"
        }
        message += "0. 처음으로"
        println(message)

        val chooseNum = numberChoose(0,menuList.size)?:continue
        return if (chooseNum == 0) null else menuList[chooseNum - 1].name
    }
}

fun chooseFood(chosenMenu: String): Food? {
    var foodMenu = dataBase.menuMap[chosenMenu]
    if(foodMenu == null){
        println("없는 메뉴에요!")
        return null
    }
    else if(foodMenu.isEmpty()){
        println("메뉴 준비 중입니다.")
        return null
    }
    while (true) {
        var message = "[$chosenMenu MENU]\n"
        for (i in foodMenu.indices) {
            message += "${i + 1}. ${foodMenu[i].name}\t|\t${foodMenu[i].price}\t|\t${foodMenu[i].displayInfo}\n"
        }
        message += "0. 처음으로\t|\t처음으로"
        println(message)

        val chooseNum = numberChoose(0,foodMenu.size)?:continue
        if (chooseNum == 0) return null
        val food = foodMenu[chooseNum - 1].clone()
        chooseOption(food)
        return food
    }
}

fun chooseOption(food: Food) {
    while (true) {
        var message = "[${food.name} option]\n"
        message += "$food\n"
        message += "1. 장바구니 넣기\n"
        message += "2. 옵션 선택하기\n"
        println(message)
        var chooseNum = numberChoose(1,2)?:continue
        if (chooseNum == 1) return

        val options = food.optionList
        if (options.isEmpty()) {
            println("선택할 옵션이 없어요")
            continue
        }

        message = "[${food.name} option]\n"
        for (i in options?.indices!!) {
            message += "${i + 1}. ${options[i].name}\t|\t${options[i].price}\n"
        }
        message += "0. 뒤로가기\t|\t뒤로가기"
        println(message)
        chooseNum = numberChoose(0,options.size)?:continue

        if (chooseNum == 0) continue
        food.addOption(options[chooseNum.toInt() - 1])
    }
}

fun numberChoose(startNumber: Int, endNumber: Int):Int?{
    val chooseNum = readln()
    if (!chooseNum.isInt() || chooseNum.toInt() !in startNumber..endNumber) {
        println("잘못된 번호를 입력했어요 다시 입력해주세요.")
        return null
    }
    return chooseNum.toInt()
}