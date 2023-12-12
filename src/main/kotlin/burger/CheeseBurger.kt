package burger

import db.BurgerMenu

class CheeseBurger(
    override val name: String = "Cheeseburger",
    override var price: Double = 6.9,
    override val displayInfo: String = "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
    override var burgerOption: Array<BurgerOption> = emptyArray()
) : BurgerMenu(name,displayInfo) {
    override fun addOption() {

    }
}