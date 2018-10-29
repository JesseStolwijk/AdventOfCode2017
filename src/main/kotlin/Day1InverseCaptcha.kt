package edu.jesse.adventofcode2017

class Day1InverseCaptcha {
    fun run(args: Array<String>): String {
        val input = args[0]
        val parsedInput = input.map { it.toNumber() }
        val numbers = parsedInput + parsedInput[0]

        val (result, _) = numbers.foldRight(0 to 0) { currentNumber: Int, (accumulator, prevNumber): Pair<Int, Int> ->
            val newAcc = when(currentNumber) {
                prevNumber -> accumulator + currentNumber
                else -> accumulator
            }
            newAcc to currentNumber
        }
        return result.toString()
    }

    private fun Char.toNumber() = this.toString().toInt()
}
