package main.sudoku

fun main() {
    println("Generate sudoku...")
    val sudoku = generateBaseSudoku()
    printSudoku(sudoku)
}

fun generateSudoku(): Array<IntArray> {
    return generateBaseSudoku()
}

private fun generateBaseSudoku(): Array<IntArray> {
    val sudoku: Array<IntArray> = Array(9) {
        IntArray(9)
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

private fun printSudoku(sudoku: Array<IntArray>) {
    println("Print sudoku:")
    for (y in sudoku.indices) {
        print("[")
        for (x in sudoku[y].indices) {
            print(" ${sudoku[y][x]}")
            if ( (x+1)%3==0 && x<(sudoku[y].size-1) ) {
                print(" ]  [")
            }
        }
        print(" ]")
        println()
        if ( (y+1)%3==0 ) {
            println()
        }
    }
}