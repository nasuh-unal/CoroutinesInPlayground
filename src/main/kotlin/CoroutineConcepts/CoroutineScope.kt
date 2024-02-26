package CoroutineConcepts

class CoroutineScope {

}

/*
    -   Bir CoroutineScope, bu kapsamdaki korutinlerin ne kadar süre yaşayacağına ilişkin
    sınırları belirleyen bir yaşam döngüsüne bağlıdır. Bir kapsam iptal edilirse, işi
    iptal edilir ve bu iptal alt işlerine yayılır. Kapsamdaki bir alt iş bir istisna ile
    başarısız olursa, diğer alt işler iptal edilir, üst iş iptal edilir ve istisna arayan
    kişiye yeniden atılır.

    -   Android, Activity (lifecycleScope) ve ViewModel (viewModelScope) gibi iyi
    tanımlanmış bir yaşam döngüsüne sahip varlıklarda coroutine kapsam desteği sağlar.
    Bu kapsamlar içinde başlatılan korutinler, Activity veya ViewModel gibi ilgili
    varlığın yaşam döngüsüne bağlı kalacaktır.

    -   Örneğin, bir Activity'de lifecycleScope adlı sağlanan korutin kapsamıyla bir
    korutin başlattığınızı varsayalım. Activity yok edilirse, lifecycleScope iptal edilir
    ve tüm alt korutinleri de otomatik olarak iptal edilir. Sadece Activity'nin yaşam
    döngüsünü takip eden coroutine'in istediğiniz davranış olup olmadığına karar vermeniz
    gerekir.




 */
fun main() {

}