package Synchronous
import Synchronous.Synchronous.Companion.printForecast
import Synchronous.Synchronous.Companion.printTemperature
import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("1-) Weather forecast")
        printForecast()
        printTemperature()
        println("4-) Clear")
    }
}

class Synchronous {
    companion object {
        suspend fun printForecast() {
            delay(1000)
            println("2-) Sunny")
        }

        suspend fun printTemperature() {
            delay(1000)
            println("3-) 30\u00b0C")
        }
    }
}
/*
    Senkron programlamada kod yürütülürken kodun devam etmesi için o fonksiyonda veya satırda olan
    işlemlerin bitmesi lazım. Fonksiyonda ve satırda herhangi bir kod parçası bitmeden devam etmez

    Coroutine'deki "co-" işbirliği anlamına gelir. Kod, bir şeyi beklemek için askıya aldığında
    altta yatan olay döngüsünü paylaşmak için işbirliği yapar, bu da bu arada başka işlerin
    yapılmasına olanak tanır. ("coroutine "deki "-routine" kısmı, fonksiyon gibi bir dizi talimat
    anlamına gelir). Bu örnekte, coroutine delay() komutuna ulaştığında askıya alınır.
    Coroutine'in askıya alındığı o bir saniye içinde başka işler yapılabilir (bu programda
    yapılacak başka bir iş olmamasına rağmen). Gecikme süresi sona erdiğinde, coroutine
    yürütmeye devam eder.
 */
