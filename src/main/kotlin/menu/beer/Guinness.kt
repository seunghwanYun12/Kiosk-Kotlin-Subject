package menu.beer

import db.Food
import db.Option

class Guinness(
    override val name: String = "Guinness",
    override var price: Double = 3.4,
    override val displayInfo: String = "기네스 맥주",
    override val optionList: Array<Option> = emptyArray(),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()