package main.sudoku

import java.util.stream.IntStream

/**
 * https://habr.com/ru/post/173795/
 */
fun main() {
    println("Sudoku:")
    var sudoku = shuffle(generateBaseSudoku())
    printSudoku(sudoku)
    for (i in 1..(15..20).random()) {
        thinOut(sudoku, true)
    }
    printSudoku(sudoku)

    println("Solve:")
    var cell = solve(sudoku)
    while (cell != null) {
        println("x=${cell.x+1}, y=${cell.y+1}, value=${cell.value}")
        sudoku[cell.x][cell.y] = cell.value
        cell = solve(sudoku)
    }
    printSudoku(sudoku)
}

fun solve(sudoku: Array<IntArray>, printLog: Boolean = false): Cell? {
    lastHeroX(sudoku, printLog).apply { if (this!=null) return this }
    lastHeroY(sudoku, printLog).apply { if (this!=null) return this }

    return null
}

private fun lastHeroY(sudoku: Array<IntArray>, printLog: Boolean = false): Cell? {
    var filled: Int
    var emptyX: Int = -1
    var emptyY: Int = -1
    var emptyCount: Int

    for (x in 0 until Config.SUDOKU_SIZE) {
        var exist: IntArray = intArrayOf()
        filled = 0;
        emptyCount = 0;
        for (y in 0 until Config.SUDOKU_SIZE) {
            if (sudoku[x][y] == 0) {
                if (emptyCount++ == 0) {
                    emptyX = x
                    emptyY = y
                }
            } else {
                filled++
                exist+=sudoku[x][y]
            }
        }
        if (filled == Config.SUDOKU_SIZE-1) {
            for (i in 1 .. Config.SUDOKU_SIZE) {
                if (!IntStream.of(*exist).anyMatch { n -> n == i }) {
                    return Cell(emptyX, emptyY, i)
                }
            }
        }
    }

    return null
}

private fun lastHeroX(sudoku: Array<IntArray>, printLog: Boolean = false): Cell? {
    var filled: Int
    var emptyX: Int = -1
    var emptyY: Int = -1
    var emptyCount: Int

    for (y in 0 until Config.SUDOKU_SIZE) {
        var exist: IntArray = intArrayOf()
        filled = 0;
        emptyCount = 0;
        for (x in 0 until Config.SUDOKU_SIZE) {
            if (sudoku[x][y] == 0) {
                if (emptyCount++ == 0) {
                    emptyX = x
                    emptyY = y
                }
            } else {
                filled++
                exist+=sudoku[x][y]
            }
        }
        if (filled == Config.SUDOKU_SIZE-1) {
            for (i in 1 .. Config.SUDOKU_SIZE) {
                if (!IntStream.of(*exist).anyMatch { n -> n == i }) {
                    return Cell(emptyX, emptyY, i)
                }
            }
        }
    }

    return null
}