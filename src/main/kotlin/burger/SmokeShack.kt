package burger

import db.BurgerMenu

class SmokeShack(
    override val name: String = "SmokeShack",
    override var price: Double = 8.9,
    override val displayInfo: String = "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
    override var burgerOption: Array<BurgerOption> = emptyArray()
) : BurgerMenu(name,displayInfo) {
    override fun addOption() {

    }
}