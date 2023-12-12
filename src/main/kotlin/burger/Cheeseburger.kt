package burger

import menu.Burger

class Cheeseburger(
    override val name: String = "Cheeseburger",
    override val price: Double = 6.9,
    override val displayInfo: String = "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"
) : Burger