package main.sudoku

fun main() {
    enterCommand()
}

private fun enterCommand() {
    println("Enter command:")
    when (readln()) {
        "help" -> {
            for (command in getCommands()) {
                println("${command.name}${if (command.name.length>4) "\t" else "\t\t"}- ${command.descr}")
            }
        }
        "generate" -> generateSudoku()
        else -> println("Command not found. Use command help")
    }
    enterCommand()
}

private fun getCommands(): List<Command> = listOf(
    Command("help", "print all commands or full description by command"),
    Command("generate", "generate sudoku")
)

data class Command(
    val name: String,
    val descr: String,
    val fullDescr: String? = null,
)