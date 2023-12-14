package burgeroption

import db.Option

class Bacon(
    override val name: String = "Bacon",
    override val price: Double = 1.1
) : Option