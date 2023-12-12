package menu

import db.Menu

open class Beer(name: String, displayInfo: String) : Menu {

    override val name:String = name
    override val displayInfo:String = displayInfo

}