package ExceptionAndCancellation

import ExceptionAndCancellation.Exception.Companion.getWeatherReport
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class Exception {
        companion object {
            suspend fun getForecast(): String {
                delay(5000)
                return "2-) Sunny"
            }
            suspend fun getTemperature(): String {
                delay(10000)
                throw AssertionError("Temperature is invalid")
                return "3-) 30\u00b0C"
            }
            suspend fun getWeatherReport() = coroutineScope {
                val forecast=async{getForecast()}
                val temperature=async{getTemperature()}
                "${forecast.await()} ${temperature.await()}"
            }
        }
}
/*
    -   Coroutine'ler arasında ebeveyn çocuk ilişkisi olabilir
    -   GetTemperature ile getForecast aynı coroutine'in alt çocuğudur. İkisinde gelecek
        herhangi bir exception üst ebeveyn coroutine'lere yayılır. Üst coroutine iptal edilir
        bu da diğer alt coroutine'leri iptal eder.
 */
fun main() {
    runBlocking {
        println("1-) Weather forecast")
        println(getWeatherReport())
        println("4-) Have a good day!")
    }
}