package Asynchronous
import Asynchronous.AsynchronousAsync.Companion.getForecast
import Asynchronous.AsynchronousAsync.Companion.getTemperature
import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("1-) Weather forecast")

        val forecast: Deferred<String> = async {
            getForecast()
        }

        val temperature: Deferred<String> = async {
            getTemperature()
        }

        println("${forecast.await()} ${temperature.await()}")
        println("4-) Have a good day!")
    }
}

class AsynchronousAsync {
    companion object {
        suspend fun getForecast(): String {
            delay(5000)
            return "2-) Sunny"
        }

        suspend fun getTemperature(): String {
            delay(10000)
            return "3-) 30\u00b0C"
        }
    }
}
/*
    -    Uygulamalarımızda bazen internetten dönen istekler farklı zamanlarda dönebilir. Bu tür
    istekleri bir ekranda aynı zamanda göstermek isteyebiliriz yani ikisi veya daha fazlası
    ekranda aynı zamanda görünsün isteyebiliriz. Async tam da burada bizim isteğimizi karşılıyor.

    -    Async() fonksiyonu, Deferred türünde bir nesne döndürür; bu, sonucun hazır olduğunda
    orada olacağına dair bir söz gibidir. Deferred nesnesi üzerindeki sonuca await()
    kullanarak erişebilirsiniz.

    -   Suspend fonksiyonları deferred türünde bir değişkene atıyoruz ardından await()
    parametresiyle iki değeri aynı anda yazdırıyoruz
 */

