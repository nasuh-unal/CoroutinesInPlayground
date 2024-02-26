package ExceptionAndCancellation

import ExceptionAndCancellation.Cancellation.Companion.getWeatherReport
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class Cancellation {

    companion object {
        suspend fun getWeatherReport() = coroutineScope {
            val forecast = async { getForecast() }
            val temperature = async { getTemperature() }
            delay(200)
            "${forecast.await()}"
        }

        suspend fun getForecast(): String {
            delay(1000)
            return "Sunny"
        }

        suspend fun getTemperature(): String {
            delay(1000)
            return "30\u00b0C"
        }
    }

}

fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}
/*
    -   Burada öğrendiğiniz şey, bir coroutine'in iptal edilebileceği, ancak aynı
    kapsamdaki diğer coroutine'leri etkilemeyeceği ve ana coroutine'in iptal
    edilmeyeceğidir.
 */