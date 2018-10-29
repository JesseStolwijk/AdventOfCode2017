package edu.jesse.adventofcode2017

class Day2CorruptionChecksum: DailyPuzzle {
    override fun run(args: Array<String>): String {
        return args[0].split('\n').map {
            val elements = it.split('\t')

            val (min, max) = elements.foldRight(Int.MAX_VALUE to 0) { current: String, (min, max): Pair<Int, Int> ->
                val currentNumber = current.toInt()

                val newMin = if(currentNumber < min) {
                    currentNumber
                } else {
                    min
                }

                val newMax = if(currentNumber > max) {
                    currentNumber
                } else {
                    max
                }

                newMin to newMax
            }
            max - min
        }.sum().toString()
    }
}