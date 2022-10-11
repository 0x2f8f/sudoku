package main.sudoku

/*
https://habr.com/ru/post/192102/
 */
fun main() {
    println("Generate sudoku...")
    val sudoku = generateBaseSudoku()
    printSudoku(sudoku)
}

fun generateSudoku(): Array<IntArray> {
    return generateBaseSudoku()
}

fun generateBaseSudoku(): Array<IntArray> {
    val sudoku: Array<IntArray> = Array(Config.SUDOKU_SIZE) {
        IntArray(Config.SUDOKU_SIZE)
    }

    var c = 1;
    for (y in sudoku.indices) {
        if (y%3==0 ) {
            c=y/3+1
        } else {
            c+=3
        }

        for (x in sudoku[y].indices) {
            sudoku[y][x] = c++
            if (c>9) c=1
        }
    }

    return sudoku
}