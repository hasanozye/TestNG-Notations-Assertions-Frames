package test.day16;

public class C01_Review {
    //todo
    // Handling Windows : Eger otomasyon sirasindan birden fazla pencere veya tab aciliyorsa, pencereler
    // veya tablar arasinda driver’imizi gezdirmemiz gerekir.
    // Eger selenium 4 ile yeni gelen switchTo( ).newWindow( ) method’unu kullanirsak,
    // driver otomatik olarak yeni acilan window’a gecer, ancak bir linke tiklayarak yeni bir sayfa acildiysa,
    // driver eski sayfada kalir.
    // Eger otomasyon sirasinda birden fazla pencere aciliyorsa,
    // kullandigimiz her sayfada sayfanin window handle degerini String bir degiskene atamamizda fayda vardir.
    // Testin ilerleyen asamalarinda eski pencereye donmek istersek, kaydettigimiz bu window handle degerlerini kullaniriz.
    // Eger bizim driver’imiza actirmadigimiz ama link ile acilan bir pencere olursa;
    // ilk once bir Set olusturup, getWindowHandles( ) method’u ile acik olan tum sayfalarin window handle
    // degerlerini bu Set’e store ederiz
    // Olusturdugumuz Set’in icerisinde daha once bulundugumuz ve
    // window handle degerlerini aldigimiz sayfa(lar)nin window handle degerleri ve
    // son gectigimiz ama window handle degerini bilmedigimiz sayfanin window handle degeri bulunur
    // Set’teki window handle degerlerini for-each loop ile control edersek, onceki sayfalarin window handle
    // degerlerine esit olmayan, yeni sayfanin window handle degeridir.
    // Buldugumuz bu window handle degerini kullanarak yeni sayfaya gecis yapabiliriz

    //todo
    // Test Base’i nicin ABSTRACT yaptik ?
    // projeniz icerisindeki herhangi bir class'dan obje olusturabilir ve o obje sayesinde
    // ait oldugu class'daki
    // tum variable ve method'lara (access modfier izin verdigi surece) ulasabilirim
    // C01_Allerts obj=new C01_Allerts();
    // eger proje kapsaminda bir class'dan obje olusturulmasini engellemek isterseniz
    // o class'in constructor'ini private yapabiliriz
    // class'in kendisini abstract yapabiliriz
    // method cok tercih edilmez cunku OOP consept'e uymaz(cok sinirli sayida kullanimi vardir)
    // method'u kullanabiliriz, boylece o class'daki abstract olmayan (concrete) method'lari override
    // etmek mecburiyeti olmadan kullanabiliriz ama obje olusturamayiz
    // ornegin biz testBase class'ini abstract yaptigimizdan obje olusturamayiz ama child class'lardan
    // TestrBase'deki setUp ve teardown method'larini kullanabiliriz
    // TestBase obj1=new TestBase();	hata verir
}
