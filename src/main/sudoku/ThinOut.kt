package main.sudoku

fun main() {
    println("Sudoku:")
    var sudoku = shuffle(generateBaseSudoku())
    printSudoku(sudoku)
    for (i in 1 .. (1..5).random() ) {
        println("$i step:")
        thinOut(sudoku, true)
    }
    printSudoku(sudoku)
}

fun thinOut(sudoku: Array<IntArray>, printLog: Boolean = false): Array<IntArray> {
    var x = (0 until  Config.SUDOKU_SIZE).random()
    var y = (0 until  Config.SUDOKU_SIZE).random()
    while (sudoku[x][y] == 0) {
        x = (0 until  Config.SUDOKU_SIZE).random()
        y = (0 until  Config.SUDOKU_SIZE).random()
    }
    sudoku[x][y] = 0

    if (printLog) {
        println("Clear cell ${x+1}-${y+1}")
    }

    return sudoku
}