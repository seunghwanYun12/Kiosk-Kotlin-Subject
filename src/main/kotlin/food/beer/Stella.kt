package food.beer

import db.Food
import db.Option

class Stella(
    override val name: String = "Stella",
    override var price: Double = 3.4,
    override val displayInfo: String = "스텔라 맥주",
    override val optionList: Array<Option> = emptyArray(),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()