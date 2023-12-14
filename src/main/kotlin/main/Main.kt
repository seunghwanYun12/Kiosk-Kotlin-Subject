package main

import db.DataBase
import db.Food

fun String.isInt(): Boolean = this.matches("[0-9]+".toRegex())
val dataBase = DataBase.getInstance()

fun main(args: Array<String>) {
    println("######키오스크 작동시작######")
    var orderList: Array<Array<Food>> = emptyArray()

    while (true) { // 주문 하나
        var foodList: Array<Food> = emptyArray()
        var insertMoney = 0.0

        while (true) { // 메뉴 선택
            val choseMenu = chooseMenu() ?: return
            when (choseMenu) {
                "money" -> { // 돈 추가 프로세스

                }

                "food" -> { // 음식 선택 프로세스
                    val choseFoodMenu = chooseFoodMenu() ?: continue
                    val choseFood = chooseFood(choseFoodMenu) ?: continue
                    foodList = foodList.plus(choseFood!!)
                }

                "basket" -> { // 장바구니 확인, 주문 완료 프로세스

                }
            }
        }
        //주문 완료 프로세스
        orderList = orderList.plus(foodList)
    }
}

fun chooseMenu(): String? {
    while (true) {
        var message = "[MENU]\n"
        message += "1. 돈 넣기\t|\t돈 넣기\n"
        message += "2. 음식 메뉴 선택\t|\t음식 메뉴 선택\n"
        message += "3. 장바구니\t|\t장바구니\n"
        message += "0. 종료\t|\t종료"
        println(message)

        val chooseNum = readln()
        if (!chooseNum.isInt() || chooseNum.toInt() !in 0..3) {
            println("잘못된 번호를 입력했어요 다시 입력해주세요.")
            continue
        }
        return when (chooseNum.toInt()) {
            1 -> "money"
            2 -> "food"
            3 -> "basket"
            else -> null
        }
    }
}

fun chooseFoodMenu(): String? {
    while (true) {
        var menuList = dataBase.menuList
        var message = "[${dataBase.storeName} MENU ]\n"
        for (i in menuList.indices) {
            message += "${i + 1}. ${menuList[i].name}\t|\t${menuList[i].displayInfo}\n"
        }
        message += "0. 처음으로\t|\t처음으로"
        println(message)

        val chooseNum = readln()
        if (!chooseNum.isInt() || chooseNum.toInt() !in 0..menuList.size) {
            println("잘못된 번호를 입력했어요 다시 입력해주세요.")
            continue
        }
        return if (chooseNum.toInt() == 0) null else menuList[chooseNum.toInt() - 1].name
    }
}

fun chooseFood(choseMenu: String): Food? {
    var foodMenu = dataBase.menuMap[choseMenu]
    if(foodMenu == null){
        println("없는 메뉴에요!")
        return null
    }
    else if(foodMenu.isEmpty()){
        println("메뉴 준비 중입니다.")
        return null
    }
    while (true) {
        var message = "[$choseMenu MENU]\n"
        for (i in foodMenu?.indices!!) {
            message += "${i + 1}. ${foodMenu[i].name}\t|\t${foodMenu[i].price}\t|\t${foodMenu[i].displayInfo}\n"
        }
        message += "0. 처음으로\t|\t처음으로"
        println(message)
        val chooseNum = readln()
        if (!chooseNum.isInt() || chooseNum.toInt() !in 0..foodMenu.size) {
            println("잘못된 번호를 입력했어요 다시 입력해주세요.")
            continue
        }
        if (chooseNum.toInt() == 0) return null
        val food = foodMenu[chooseNum.toInt() - 1].clone()
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
        var chooseNum = readln()
        if (!chooseNum.isInt() || chooseNum.toInt() !in 1..2) {
            println("잘못된 번호를 입력했어요 다시 입력해주세요.")
            continue
        }
        if (chooseNum.toInt() == 1) return

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
        chooseNum = readln()
        if (!chooseNum.isInt() || chooseNum.toInt() !in 0..options.size) {
            println("잘못된 번호를 입력했어요 다시 입력해주세요.")
            continue
        }
        if (chooseNum.toInt() == 0) continue
        food.addOption(options[chooseNum.toInt() - 1])
    }

}