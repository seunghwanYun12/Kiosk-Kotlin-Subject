import main.isInt
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @Test()
    fun isInt() {
        var notNum = "string"
        var oneNum = "1"
        var manyNum = "123"
        var doubleNum = "123.123"

        assertFalse(notNum.isInt())
        assertTrue(oneNum.isInt())
        assertTrue(oneNum.isInt())
        assertTrue(manyNum.isInt())
        assertFalse(doubleNum.isInt())
    }
}