package option.burgeroption

import db.Option

class Tomato(
    override val name: String = "Tomato",
    override val price: Double = 0.3
) : Option