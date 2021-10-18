package utils

fun Int.isBetween(num1 : Int, num2 : Int) : Boolean = this in num1..num2

fun String.capitalizeWords(): String = split(" ").map { it.capitalize() }.joinToString(" ")
