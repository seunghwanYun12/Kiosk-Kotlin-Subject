package burger

import menu.Burger

class SmokeShack(
    override val name: String = "SmokeShack",
    override val price: Double = 8.9,
    override val displayInfo: String = "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
) : Burger