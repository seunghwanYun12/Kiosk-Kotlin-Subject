package db

import kotlin.math.floor

abstract class Food {
    abstract val name: String
    abstract val displayInfo: String
    abstract var price:Double
    abstract val optionList: Array<Option>
    abstract var selectedOption: Array<Option>
    fun addOption(option: Option){
        if(optionList.contains(option)) {
            price += option.price
            price = floor(price*10) / 10
            selectedOption = selectedOption.plus(option)
        }
    }

    override fun toString(): String {
        var optionNames = selectedOption.joinToString(", ") { it.name }
        if(optionNames.isEmpty()) optionNames = "추가된 옵션 없음"
        return "$name | $optionNames | $price | $displayInfo "
    }
}