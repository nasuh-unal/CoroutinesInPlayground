package Asynchronous
import Asynchronous.AsynchronousLaunch.Companion.printForecast
import Asynchronous.AsynchronousLaunch.Companion.printTemperature
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AsynchronousLaunch {
    companion object {
        suspend fun printForecast() {
            println("2-) Foggy")
            delay(5000)
            println("3-) Sunny")
        }
        suspend fun printTemperature() {
            delay(10000)
            println("5-) 30\u00b0C")
        }
    }
}
fun main() {
    runBlocking {
        println("1-) Weather forecast")
        launch {
            printForecast()
        }
        println("4-) Windy")
        launch { printTemperature() }
        delay(2000)
        println("6-) Rainy")
    }
}
/*
    -    Senkron bir şekilde yani sıralı bir şekilde değil de asenkron
    devam eden bir kod yazmak için suspend fonksiyonlarımızı
    launch ile belirtilen parametreler altında çağıracağız
    bu şekilde fonksiyonlarımızın içerisindeki kodların tamamlanmasını
    beklemeden kodumuz kaldığı yerden devam eder

    -    Rain'den önce delay vermesek foggy'den önce yazdırılırdı çünkü fonksiyona girilip yürütülene
    kadar derleyici devam edip rainy çıktısını verecekti
 */
