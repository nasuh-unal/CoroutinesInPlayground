package CoroutineConcepts

class Job {

}

/*
    -   Not: async() işleviyle başlatılan bir coroutine'den döndürülen Deferred
    nesnesi de bir Job'tur ve coroutine'in gelecekteki sonucunu tutar.

    -   Bir coroutine'i launch() işleviyle başlattığınızda, bir Job örneği döndürür.
    Job, yaşam döngüsünü yönetebilmeniz için coroutine'e bir handle veya referans tutar.

    -   Job, yaşam döngüsünü veya coroutine'in ne kadar süre yaşayacağını kontrol
    etmek için kullanılabilir, örneğin artık göreve ihtiyacınız yoksa coroutine'i iptal
    edebilirsiniz.

    -   Bir üst job iptal edilirse, alt job'lar de iptal edilir.
    -   Bir alt job job.cancel() kullanılarak iptal edildiğinde sonlandırılır,
    ancak üst job iptal edilmez.
    -   Bir job bir istisna ile başarısız olursa, ebeveynini bu istisna ile iptal eder.
    Bu, hatanın yukarı doğru yayılması olarak bilinir (ebeveyne, ebeveynin ebeveynine vb.)

*/
fun main() {

}