import kotlinx.coroutines.*
import java.util.Scanner


data class Git(val login: String, val repoCount: Int)

fun main() = runBlocking {
    val scanner = Scanner(System.`in`)
    println("Введите имя пользователя: ")
    val username = scanner.nextLine()
    println("Введите токен (или пароль): ")
    val token = scanner.nextLine()
    val block = "БЛОКИРОВКА"
    println("\nВыбран вариант 'блокировка'")
    if (block == "БЛОКИРОВКА") {
        println("Нажата кнопка")
        val results = loadDataBlock()

        println("\nРезультаты загрузки")
        results.forEach { user ->
            println("Участник: ${user.login} | Репозиториев: ${user.repoCount}")
        }
    }
}

suspend fun loadDataBlock(): List<Git> {
    println("Загрузка....Подождите немного")
    Thread.sleep(5000)
    val Data = listOf(
        Git(login = "Mark2", repoCount = 13),
        Git(login = "Exc04", repoCount = 16),
        Git(login = "JojoS", repoCount = 1),
        Git(login = "Fantom04", repoCount = 8),
        Git(login = "Lancer", repoCount = 15)
    )
    return Data.sortedByDescending { it.repoCount }
}