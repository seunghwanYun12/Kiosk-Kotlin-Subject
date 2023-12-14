package option.burgeroption

import db.Option

class Ham(
    override val name: String = "Ham",
    override val price: Double = 1.2
) : Option