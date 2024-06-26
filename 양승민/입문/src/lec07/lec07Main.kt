package lec07

import java.io.BufferedReader
import java.io.FileReader

fun main() {

    // 1. try catch finally
    fun parseIntOrThrow(string: String): Int {
        try{
            return string.toInt()
        }catch (e: NumberFormatException){
            throw IllegalArgumentException(e)
        }
    }

    fun parseIntOrThrow2(string: String): Int? {
        return try{
            return string.toInt()
        }catch (e: NumberFormatException){
            null;
        }
    }

    // 3. try with resources
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }

}