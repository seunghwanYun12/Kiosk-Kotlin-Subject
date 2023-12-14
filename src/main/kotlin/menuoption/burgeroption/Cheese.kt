package menuoption.burgeroption

import db.Option

class Cheese(
    override val name: String = "Cheese",
    override val price: Double = 0.3
) : Option