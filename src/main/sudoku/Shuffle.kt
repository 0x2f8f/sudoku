package main.sudoku

import java.util.Random

fun main() {
    println("Base sudoku:")
    printSudoku(generateSudoku())
    printSudoku(transpose(generateBaseSudoku(), true))
    printSudoku(swapRowsSmall(generateBaseSudoku(), true))
    printSudoku(swapColumnsSmall(generateBaseSudoku(), true))
    printSudoku(swapRowsBlock(generateBaseSudoku(), true))
    printSudoku(swapColumnsBlock(generateBaseSudoku(), true))
    println("Mixing all methods")
    printSudoku(shuffle(generateBaseSudoku()))
}

fun shuffle(sudoku: Array<IntArray>, printLog: Boolean = false): Array<IntArray> {
    transpose(sudoku, printLog)
    for (i in 0..(300..500).random()) {
        when ((1..6).random()) {
            1 -> swapRowsSmall(sudoku, printLog)
            2 -> swapRowsSmall(sudoku, printLog)
            3 -> swapColumnsSmall(sudoku, printLog)
            4 -> swapColumnsSmall(sudoku, printLog)
            5 -> swapRowsBlock(sudoku, printLog)
            6 -> swapColumnsBlock(sudoku, printLog)
        }
    }

    return sudoku
}

private fun transpose(sudoku: Array<IntArray>, printLog: Boolean = false): Array<IntArray> {
    if (printLog) {
        println("Transpose sudoku")
    }

    var tmp: Int;
    var i = 0;
    for (y in sudoku.indices) {
        for (x in i++ until Config.SUDOKU_SIZE) {
            tmp = sudoku[y][x]
            sudoku[y][x] = sudoku[x][y]
            sudoku[x][y] = tmp
        }
    }

    return sudoku
}

private fun swapRowsSmall(sudoku: Array<IntArray>, printLog: Boolean = false): Array<IntArray> {
    var row1: Int = (0 until Config.ROWS_IN_BLOCK_COUNT).random()
    var row2: Int = (0 until Config.ROWS_IN_BLOCK_COUNT).random()
    val block: Int = (0 until Config.BLOCK_COUNT).random()

    while (row2 == row1) {
        row2 = (0 until Config.ROWS_IN_BLOCK_COUNT).random()
    }

    row1+=block*Config.ROWS_IN_BLOCK_COUNT
    row2+=block*Config.ROWS_IN_BLOCK_COUNT

    if (printLog) {
        println("SwapRowsSmall sudoku")
        println("rows: ${row1 + 1} and ${row2 + 1}")
    }
    var tmp: Int
    for (x in 0 until Config.SUDOKU_SIZE) {
        tmp = sudoku[row1][x]
        sudoku[row1][x] = sudoku[row2][x]
        sudoku[row2][x] = tmp
    }

    return sudoku
}

private fun swapColumnsSmall(sudoku: Array<IntArray>, printLog: Boolean = false): Array<IntArray> {
    var col1: Int = (0 until Config.COLUMNS_IN_BLOCK_COUNT).random()
    var col2: Int = (0 until Config.COLUMNS_IN_BLOCK_COUNT).random()
    val block: Int = (0 until Config.BLOCK_COUNT).random()

    while (col2 == col1) {
        col2 = (0 until Config.COLUMNS_IN_BLOCK_COUNT).random()
    }

    col1+=block*Config.COLUMNS_IN_BLOCK_COUNT
    col2+=block*Config.COLUMNS_IN_BLOCK_COUNT

    if (printLog) {
        println("swapColumnsSmall sudoku")
        println("cols: ${col1 + 1} and ${col2 + 1}")
    }
    var tmp: Int
    for (y in 0 until Config.SUDOKU_SIZE) {
        tmp = sudoku[y][col1]
        sudoku[y][col1] = sudoku[y][col2]
        sudoku[y][col2] = tmp
    }

    return sudoku
}

private fun swapRowsBlock(sudoku: Array<IntArray>, printLog: Boolean = false): Array<IntArray> {
    val block1: Int = (0 until Config.BLOCK_COUNT).random()
    var block2: Int = (0 until Config.BLOCK_COUNT).random()
    while (block2 == block1) {
        block2 = (0 until Config.BLOCK_COUNT).random()
    }

    if (printLog) {
        println("swapRowsBlock sudoku")
        println("blocks: ${block1 + 1} and ${block2 + 1}")
    }
    var tmp: Int
    var y1: Int
    var y2: Int
    for (x in 0 until Config.SUDOKU_SIZE) {
        for (y in 0 until Config.COLUMNS_IN_BLOCK_COUNT) {
            y1 = y+block1*Config.ROWS_IN_BLOCK_COUNT
            y2 = y+block2*Config.ROWS_IN_BLOCK_COUNT

            tmp = sudoku[y1][x]
            sudoku[y1][x] = sudoku[y2][x]
            sudoku[y2][x] = tmp
        }
    }

    return sudoku
}

private fun swapColumnsBlock(sudoku: Array<IntArray>, printLog: Boolean = false): Array<IntArray> {
    val block1: Int = (0 until Config.BLOCK_COUNT).random()
    var block2: Int = (0 until Config.BLOCK_COUNT).random()
    while (block2 == block1) {
        block2 = (0 until Config.BLOCK_COUNT).random()
    }

    if (printLog) {
        println("swapColumnsBlock sudoku")
        println("blocks: ${block1 + 1} and ${block2 + 1}")
    }
    var tmp: Int
    var x1: Int
    var x2: Int
    for (y in 0 until Config.SUDOKU_SIZE) {
        for (x in 0 until Config.ROWS_IN_BLOCK_COUNT) {
            x1 = x+block1*Config.COLUMNS_IN_BLOCK_COUNT
            x2 = x+block2*Config.COLUMNS_IN_BLOCK_COUNT

            tmp = sudoku[y][x1]
            sudoku[y][x1] = sudoku[y][x2]
            sudoku[y][x2] = tmp
        }
    }

    return sudoku
}