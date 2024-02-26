package CoroutineConcepts

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.async
import kotlinx.coroutines.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

fun main() {
    runBlocking {
        println("${Thread.currentThread().name} - runBlocking function")

        launch {
            println("${Thread.currentThread().name} - runBlocking function")

            withContext(Dispatchers.Default) {
                println("${Thread.currentThread().name} - runBlocking function")
                delay(100)

                println("${Thread.currentThread().name} - runBlocking function")
                println("10 results found")
            }
            println("${Thread.currentThread().name} - runBlocking function")
        }
        println("Loading ...")
    }

}
/*
    -   Kod main thread üzerinde yürütülürken withContext ile kodu default üzerinden
    yürütüyoruz. BU scope'un dışına çıktığında tekrardan main thread'den devam edecektir.

    -   withContext ile thread üzerinde değişiklik yapabiliriz.

    -

    -   Coroutine'ler, yürütülecek iş parçacığını belirlemek için
    dispatcher'ları kullanır. Bir iş parçacığı başlatılabilir, bazı işler yapar
    (bazı kodları yürütür) ve daha sonra yapılacak iş kalmadığında sonlandırılır.

    -   Bir kullanıcı uygulamanızı başlattığında, Android sistemi uygulamanız için yeni
    bir süreç ve "main thread" (ana iş parçacığı) olarak bilinen tek bir thread oluşturur.
    Ana iş parçacığı, Android sistem olayları, kullanıcı arayüzünün
    ekrana çizilmesi, kullanıcı girişi olaylarının ele alınması ve daha fazlası dahil
    olmak üzere uygulamanız için birçok önemli işlemi gerçekleştirir. Sonuç olarak,
    uygulamanız için yazdığınız kodların çoğu büyük olasılıkla main thread
    çalışacaktır.

    -   Kodunuzun thread davranışı söz konusu olduğunda anlamanız gereken iki terim
    vardır: bloklama ve bloklamama. Normal bir fonksiyon, işi tamamlanana kadar çağıran
    thread'i bloke eder. Bu, iş tamamlanana kadar çağıran thread'i vermeyeceği anlamına
    gelir, bu nedenle bu arada başka bir iş yapılamaz. Tersine, non-blocking kod belirli
    bir koşul karşılanana kadar çağıran thread'i verir, böylece bu arada başka işler
    yapabilirsiniz. Asenkron bir fonksiyonu, işi tamamlanmadan önce geri döndüğü için,
    kilitlenmeyen bir işi gerçekleştirmek için kullanabilirsiniz.

    -   Android uygulamaları söz konusu olduğunda, ana thread üzerinde blocking kodunu
    yalnızca oldukça hızlı bir şekilde çalışacaksa çağırmalısınız. Amaç, main thread'in
    engellenmemesini sağlamaktır, böylece yeni bir olay tetiklendiğinde işi hemen
    yürütebilir. Bu main thread, activity'leriniz için UI thread'idir ve UI çiziminden
    ve UI ile ilgili olaylardan sorumludur. Ekranda bir değişiklik olduğunda, kullanıcı
    arayüzünün yeniden çizilmesi gerekir. Ekrandaki animasyon gibi bir şey için, kullanıcı
    arayüzünün yumuşak bir geçiş gibi görünmesi için sık sık yeniden çizilmesi gerekir.
    Main Thread'in uzun süren bir iş bloğunu yürütmesi gerekiyorsa, ekran o kadar sık
    güncellenmez ve kullanıcı ani bir geçiş ("jank" olarak bilinir) görür ya da uygulama
    kilitlenebilir veya yavaş yanıt verebilir.

    -   Dispatchers.Main: Main Android thread üzerinde bir coroutine çalıştırmak için bu
    dispatcher'ı kullanın. Bu dispatcher öncelikle UI güncellemelerini ve etkileşimlerini
    işlemek ve hızlı iş yapmak için kullanılır.

    -   Dispatchers.IO: Bu dispatcher, main thread dışında disk veya ağ I/O
    gerçekleştirmek için optimize edilmiştir. Örneğin, dosyalardan okuma veya dosyalara
    yazma ve herhangi bir ağ işlemini yürütme.

    -   Dispatchers.Default: Bu, bağlamlarında herhangi bir dispatcher belirtilmediğinde
    launch() ve async() çağrılırken kullanılan varsayılan bir dispatcher'dır. Bu
    dağıtıcıyı main thread dışında hesaplama açısından yoğun işler gerçekleştirmek için
    kullanabilirsiniz. Örneğin, bir bitmap görüntü dosyasını işlemek gibi.

 */