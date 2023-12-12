package main

import db.DataBase

fun String.isInt():Boolean = this.matches("[0-9]+".toRegex())
val dataBase = DataBase.getInstance()

fun main(args: Array<String>) {
    println("######키오스크 작동시작######")
    while (true){
        val choseMenu = chooseMenu()

        if(choseMenu == "종료") return

        var menuTest = dataBase.menuMap[choseMenu]
        println(menuTest?.size)


    }
}

fun chooseMenu():String{
    while (true) {
        var menuList = dataBase.menuList
        var message="[ ${dataBase.storeName} MENU ]\n"
        for(i in menuList.indices){
            message += "${i+1}. ${menuList[i].name} \t | \t ${menuList[i].displayInfo}\n"
        }
        message += "0. 종료 \t | \t프로그램 종료"
        println(message)

        val chooseNum = readln()
        if(!chooseNum.isInt() || chooseNum.toInt() !in 0..menuList.size){
            println("잘못된 번호를 입력했어요 다시 입력해주세요.")
            continue
        }
        return if(chooseNum.toInt() == 0) "종료" else menuList[chooseNum.toInt()-1].name
    }
}