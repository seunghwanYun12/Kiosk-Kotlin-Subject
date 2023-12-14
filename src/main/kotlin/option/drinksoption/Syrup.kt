package option.drinksoption

import db.Option

class Syrup(
    override val name: String = "Syrup",
    override val price: Double = 0.2
) : Option