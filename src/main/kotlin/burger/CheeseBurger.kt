package burger

import burgeroption.Bacon
import burgeroption.Cheese
import burgeroption.PotatoBurn
import db.Food
import db.Option

class CheeseBurger(
    override val name: String = "Cheeseburger",
    override var price: Double = 6.9,
    override val displayInfo: String = "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
    override val optionList: Array<Option> = emptyArray(),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()