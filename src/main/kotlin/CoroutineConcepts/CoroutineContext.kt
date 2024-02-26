package CoroutineConcepts



/*
    -   CoroutineContext, coroutine'in içinde çalışacağı context hakkında bilgi sağlar.
    CoroutineContext esasen, her bir öğenin benzersiz bir anahtara sahip olduğu öğeleri
    depolayan bir haritadır.

    name - benzersiz bir şekilde tanımlamak için coroutine'in adı
    job - coroutine'in yaşam döngüsünü kontrol eder
    dispatcher - işi uygun iş parçacığına gönderir
    Exception Handler - korutin içinde çalıştırılan kod tarafından atılan istisnaları işler

    Job() + Dispatchers.Main + exceptionHandler

    scope.launch(Dispatchers.Default) {
    ...
    }
 */