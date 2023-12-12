package main

fun String.isInt():Boolean = this.matches("[0-9]+".toRegex())


fun main(args: Array<String>) {
    println("######키오스크 작동중######")
    menu()
}

fun menu(){
    while (true) {
        println(
            "[ SHAKESHACK MENU ]\n" +
                    "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
                    "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
                    "3. Drinks          | 매장에서 직접 만드는 음료\n" +
                    "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
                    "0. 종료            | 프로그램 종료"
        )
        val chooseNum = readln()
        if(!chooseNum.isInt()){
            println("숫자를 입력해주세요")
            continue
        }
        when(chooseNum.toInt()){



            0 -> {
                println("키오스크 종료")
                break
            }
            else -> println("메뉴에 있는 숫자를 입력해주세요")
        }
    }
}