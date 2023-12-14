package db

import burgeroption.Bacon

abstract class Food {
    abstract val name: String
    abstract val displayInfo: String
    abstract var price:Double
    abstract val optionList: Array<Option>
    abstract var selectedOption: Array<Option>
    fun addOption(option: Option){
        if(optionList.contains(option)) {
            price += option.price
            selectedOption.plus(option)
        }
    }

    override fun toString(): String {
        return "$name | ${optionList.toList()} | $price | $displayInfo "
    }
}