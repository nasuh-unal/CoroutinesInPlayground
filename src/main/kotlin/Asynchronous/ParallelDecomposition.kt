package Asynchronous
import Asynchronous.ParallelDecomposition.Companion.getWeatherReport
import kotlinx.coroutines.*

class ParallelDecomposition {
    companion object {
        suspend fun getForecast(): String {
            delay(5000)
            return "2-) Sunny"
        }
        suspend fun getTemperature(): String {
            delay(10000)
            return "3-) 30\u00b0C"
        }
        suspend fun getWeatherReport() = coroutineScope {
            val forecast=async{getForecast()}
            val temperature=async{getTemperature()}
            "${forecast.await()} ${temperature.await()}"
        }
    }
}

fun main() {
    runBlocking {
        println("1-) Weather forecast")
        println(getWeatherReport())
        println("4-) Have a good day!")
    }
}

/*
    -   Çıktı aynıdır, ancak burada bazı kayda değer çıkarımlar vardır. Daha önce de belirtildiği
    gibi, coroutineScope() yalnızca başlattığı tüm coroutine'ler de dahil olmak üzere tüm
    çalışmaları tamamlandığında geri dönecektir. Bu durumda, hem getForecast() hem de
    getTemperature()coroutine'lerinin işlerini bitirmeleri ve ilgili sonuçları döndürmeleri gerekir.
    Ardından Sunny metni ve 30°C birleştirilir ve kapsamdan döndürülür.
    Sunny 30°C hava durumu raporu çıktıya yazdırılır ve çağıran kişi Have a good day!
    ifadesinin son yazdırma deyimine geçebilir.

    -   CoroutineScope() ile, fonksiyon dahili olarak eşzamanlı iş yapıyor olsa da, coroutineScope
    tüm iş bitene kadar geri dönmeyeceği için çağırana eşzamanlı bir işlem olarak görünür.

    -   Decomposition eşzamanlılık için buradaki temel fikir, eşzamanlılığın bir uygulama detayı
    olduğu birden fazla eşzamanlı işlemi alıp tek bir eşzamanlı işlem haline getirebilmenizdir.
    Çağıran kodla ilgili tek gereklilik, bir suspend fonksiyon veya coroutine içinde olmaktır.
    Bunun dışında, çağıran kodun yapısının eşzamanlılık ayrıntılarını dikkate alması gerekmez.

    -   Bir önceki section da yaptığımız gibi hatta aynı çıktıyı veren bir uygulama yapacağız.
    Fakat bir takım farklılıklar bulunmakta. Farklı zamanlarda dönen suspend fonksiyonlarımızı
    tek bir fonksiyon altında toplayabiliriz. bunun için coroutinScope parametresini kullanacağız.
    Farklı zamanlarda dönen fonksiyonlarımızı async olarak alıp bunları await parametresi ile
    tutuyoruz. FARKLI ZAMANLARDA DÖNEN SUSPEND FONKSİYONLARA TEK BİR FONKSİYON ÜZERİNDEN ERİŞMEK
    İSTİYORSAK BU YÖNTEMİ UYGULAYACAĞIZ.

 */