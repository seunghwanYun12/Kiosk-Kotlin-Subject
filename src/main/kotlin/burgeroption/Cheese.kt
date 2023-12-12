package burgeroption

import burger.BurgerOption

class Cheese(
    override val name: String = "Cheese",
    override val price: Double = 0.3
) :BurgerOption