Coroutine
==================================
Bu repository'de synchronous ve asynchronous olarak yürütülen iki tür kod parçacıklarını inceledim. synchronous programlamada kod yürütülürken kodun devam etmesi için o fonksiyonda veya satırda olan
işlemlerin bitmesi lazım. Fonksiyonda ve satırda herhangi bir kod parçası bitmeden program başka bir kısma geçmez iken asynchronous programlamada fonksiyonlarımızın içerisindeki kodlar bitmeden diğer kodları 
yürütebiliriz. Paket olarak ayırdığım projemde class'lardaki çalışmalarımda çıkarımlarımı comment satırları içerisinde not aldım.

Kullandığım parametreler
--------------
- Suspend fun
- runBlocking
- async()
- launch()
- coroutineScope
- withContext
- await()
- try catch
