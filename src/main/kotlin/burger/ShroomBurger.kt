package burger

import db.BurgerMenu

class ShroomBurger(
    override val name: String = "ShroomBurger",
    override var price: Double = 9.4,
    override val displayInfo: String = "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
    override var burgerOption: Array<BurgerOption> = emptyArray()
) : BurgerMenu(name,displayInfo) {
    override fun addOption() {

    }
}