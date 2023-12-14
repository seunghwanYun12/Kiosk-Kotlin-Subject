package menu.drinks

import db.Food
import db.Option

class Coke(
    override val name: String = "Coke",
    override var price: Double = 1.1,
    override val displayInfo: String = "콜라",
    override val optionList: Array<Option> = emptyArray(),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()