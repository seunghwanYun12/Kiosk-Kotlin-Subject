package menu

import db.Menu

class Drinks(name: String, displayInfo: String) : Menu {

    override val name:String = name
    override val displayInfo:String = displayInfo

}