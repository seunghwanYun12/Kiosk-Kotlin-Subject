package burger

import burgeroption.BeefPatty
import burgeroption.Cheese
import db.Food
import db.Option

class ShroomBurger(
    override val name: String = "ShroomBurger",
    override var price: Double = 9.4,
    override val displayInfo: String = "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
    override val optionList: Array<Option> = arrayOf(Cheese(),BeefPatty()),
    override var selectedOption:Array<Option> = emptyArray()
) : Food()