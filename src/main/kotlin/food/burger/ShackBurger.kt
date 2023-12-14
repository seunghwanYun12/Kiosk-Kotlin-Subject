package food.burger

import db.Food
import db.Option

class ShackBurger(
    override val name: String = "ShackBurger",
    override var price: Double = 6.9,
    override val displayInfo: String = "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
    override val optionList: Array<Option> = emptyArray(),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()