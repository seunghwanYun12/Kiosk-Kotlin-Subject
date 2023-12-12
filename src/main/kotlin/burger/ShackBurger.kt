package burger

import db.BurgerMenu

class ShackBurger(
    override val name: String = "ShackBurger",
    override var price: Double = 6.9,
    override val displayInfo: String = "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
    override var burgerOption: Array<BurgerOption> = emptyArray()
) : BurgerMenu(name,displayInfo) {
    override fun addOption() {

    }
}