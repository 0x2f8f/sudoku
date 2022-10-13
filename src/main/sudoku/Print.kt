package main.sudoku

fun printSudoku(sudoku: Array<IntArray>) {
    for (y in sudoku.indices) {
        print("[")
        for (x in sudoku[y].indices) {
            if (sudoku[x][y]==0) {
                print("  ")
            } else {
                print(" ${sudoku[x][y]}")
            }

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