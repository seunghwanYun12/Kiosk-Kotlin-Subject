package burger

import menu.Burger

class Hamburger(
    override val name: String = "Hamburger",
    override val price: Double = 5.4,
    override val displayInfo: String = "비프패티를 기반으로 야채가 들어간 기본버거"
) : Burger