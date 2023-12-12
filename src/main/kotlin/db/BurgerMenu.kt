package db

import burger.BurgerOption
import menu.Burger

abstract class BurgerMenu(override val name: String, override val displayInfo: String): Burger(name,displayInfo) {
    abstract var price:Double
    abstract var burgerOption: Array<BurgerOption>
    abstract fun addOption()
}