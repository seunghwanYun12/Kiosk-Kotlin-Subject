package menu.drinks

import db.Food
import db.Option

class Fanta(
    override val name: String = "Fanta",
    override var price: Double = 1.2,
    override val displayInfo: String = "환타",
    override val optionList: Array<Option> = emptyArray(),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()