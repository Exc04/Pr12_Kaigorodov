import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun Data(num: Int): String {
    val delayT = Random.nextLong(500,2000)
    delay(delayT)
    return  "$num занял ${delayT} мс"
}

fun main() = runBlocking { println("Ведите кол-во функций: ")
    val n = readln()?.toIntOrNull() ?: 0
    println("Запуск $n корутин")
    val startT = System.currentTimeMillis()
    val res = (1..n).map { id -> async { Data(id) } }
    val res1 = res.awaitAll()
    val endT = System.currentTimeMillis()
    res1.forEach { println(it)}
    println("Общее время выполнения ${endT-startT} мс")
}
