package food.beer

import db.Food
import db.Option

class Kirin(
    override val name: String = "Kirin",
    override var price: Double = 1.2,
    override val displayInfo: String = "기린 맥주",
    override val optionList: Array<Option> = emptyArray(),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()