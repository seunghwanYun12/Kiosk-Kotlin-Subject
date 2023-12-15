package menu

import db.Menu

class Burger(name: String, displayInfo: String) : Menu {

    override val name:String = name
    override val displayInfo:String = displayInfo

}