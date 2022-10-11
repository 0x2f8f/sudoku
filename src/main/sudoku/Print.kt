package main.sudoku

fun printSudoku(sudoku: Array<IntArray>) {
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