package burgeroption

import burger.BurgerOption

class Bacon(
    override val name: String = "Bacon",
    override val price: Double = 1.1
) : BurgerOption