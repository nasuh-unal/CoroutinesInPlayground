package ExceptionAndCancellation

import ExceptionAndCancellation.TryCatch.Companion.getTemperature
import ExceptionAndCancellation.TryCatch.Companion.getWeatherReport
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class TryCatch {
    companion object {
        suspend fun getWeatherReport() = coroutineScope {
            val forecast = async { getForecast() }
            val temperature = async {
                try {
                    getTemperature()
                } catch (e: AssertionError) {
                    println("Caught exception $e")
                    "{ No temperature found }"
                }
            }
            "${forecast.await()} ${temperature.await()}"
        }

        suspend fun getForecast(): String {
            delay(1000)
            return "Sunny"
        }

        suspend fun getTemperature(): String {
            delay(500)
            throw AssertionError("Temperature is invalid")
            return "30\u00b0C"
        }
    }
}
/*
    -   Kodumuzda beklenmeyen hatalar uygulamamızın çökmesine neden olabilir. Bunu
    önlemek için Try Catch'den yararlanabiliriz. Beklenmeyen bir hatayı yakalayıp
    uygulamamızda hata mesajı almamıza neden olur ve böylece uygulama çökmez. Bunu
    main'de çıktı alırken yaparsak coroutine içerisinde çıktı alınan herşey hata
    olarak döner ama async ile bunu kullanırsak sadece hata olan coroutine hata döner
    diğer coroutinler olağan akışına devam eder. Yani burada await() çıktı verirken hata
    alıp almadığını bilmez sadece kendine verileni yazdırır.

    -   Uyarı: Korutin kodunuzdaki bir try-catch deyimi içinde, genel bir İstisna
    yakalamaktan kaçının çünkü bu çok geniş bir istisna yelpazesini içerir. Aslında
    kodunuzda düzeltilmesi gereken bir hata olan bir hatayı yanlışlıkla yakalıyor ve
    bastırıyor olabilirsiniz.

    -   Beklenmedik hatalar coroutine ağacında yukarı doğru yayılır.
 */

fun main() {
    runBlocking {
        println("Weather forecast")

        /*try {
            println(getWeatherReport())
        } catch (e: AssertionError) {
            println("Caught exception in runBlocking(): $e")
            println("Report unavailable at this time")
        }*/

        println(getWeatherReport())
        println("Have a good day!")
    }
}