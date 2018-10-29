package edu.jesse.adventofcode2017

import kotlin.math.*

class Day3SpiralMemory: DailyPuzzle {
    override fun run(args: Array<String>): String {
        val input = args[0]

        val inputRoot = ceil(sqrt(input.toDouble()))

        val size = if(inputRoot.toInt().rem(2) == 0) {
            inputRoot + 1
        } else {
            inputRoot
        }

        val totalMemory = size.pow(2).toInt()
        val offset = totalMemory - input.toInt()

        val gridSize = size.toInt() - 1
        val twoGridSize = 2 * gridSize
        val threeGridSize = 3 * gridSize

        val (x, y) = when{
            offset < gridSize -> gridSize to gridSize - offset
            offset < twoGridSize -> 0 to twoGridSize - offset
            offset < threeGridSize -> offset - twoGridSize to 0
            else -> gridSize to offset - threeGridSize
        }

        val center = floor(size / 2).toInt()
        val distanceToCenter = abs(x - center) + abs(y - center)

        return distanceToCenter.toString()
    }
}