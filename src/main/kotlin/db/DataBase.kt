package db

import menu.Beer
import menu.Burger
import menu.Drinks
import menu.FrozenCustard
import food.beer.Guinness
import food.beer.Kirin
import food.beer.Stella
import food.burger.*
import food.drinks.Coke
import food.drinks.Fanta
import option.burgeroption.*
import option.drinksoption.Syrup

class DataBase private constructor() {
    val storeName:String = "SHAKESHACK"
    val menuList:List<Menu> = listOf(
        Burger("Burgers","앵거스 비프 통살을 다져만든 버거"),
        FrozenCustard("Forzen Custard","매장에서 신선하게 만드는 아이스크림"),
        Drinks("Drinks","매장에서 직접 만드는 음료"),
        Beer("Beer","뉴욕 브루클린 브루어리에서 양조한 맥주"),
    )

    private val burgerList:List<Food> = listOf(
        CheeseBurger(optionList = arrayOf(PotatoBurn(), Cheese())),
        HamBurger(optionList = arrayOf(BeefPatty(), Ham())),
        ShackBurger(optionList = arrayOf(Tomato())),
        ShroomBurger(optionList = arrayOf(Cheese(), BeefPatty())),
        SmokeShack(optionList = arrayOf(Bacon()))
    )

    private val beerList:List<Food> = listOf(
        Guinness(),
        Kirin(),
        Stella()
    )

    private val drinksList:List<Food> = listOf(
        Coke(optionList = arrayOf(Syrup())),
        Fanta(optionList = arrayOf(Syrup()))
    )

    private val frozenCustardList:List<Food> = listOf(

    )

    val menuMap:Map<String,List<Food>> = mapOf(
        (menuList.find { it is Burger }?.name ?: "") to burgerList,
        (menuList.find { it is Beer }?.name ?: "") to beerList,
        (menuList.find { it is Drinks }?.name ?: "") to drinksList,
        (menuList.find { it is FrozenCustard }?.name ?: "") to frozenCustardList
    )

    companion object {
        private var INSTANCE: DataBase? = null
        fun getInstance(): DataBase {
            return INSTANCE ?: DataBase().apply {
                INSTANCE = this
            }
        }
    }

}