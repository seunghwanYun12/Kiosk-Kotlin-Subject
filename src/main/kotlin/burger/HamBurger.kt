package burger

import db.Food
import db.Option

class HamBurger(
    override val name: String = "Hamburger",
    override var price: Double = 5.4,
    override val displayInfo: String = "비프패티를 기반으로 야채가 들어간 기본버거",
    override val optionList: Array<Option> = emptyArray(),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()