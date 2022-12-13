public final class StarTriangle {



    /*
        Method satır sayısını alır.
        Birinci for dögüsünde i değeri 1'den başlayarak birer artar line değerine kadar line değeride dahil.
        İkinci for döngüsünde k değeri satır değeri ile i değeri arasındaki farktan başlar. Birer azalarak 0'a kadar
      devam eder.Ekrana space basar.
        Üçüncü for döngüsünde j 0'dan başlar. Birer artarak i değerine kadar ekrana yıldız basar.
        Sonrasında alt satıra geçer.

     */
    static void right(long line) {
        for (long i =1 ; i <= line; i++) {
            for(long k=line-i;k>0;k--){
                System.out.print(" ");
            }
            for (long j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /*
            Method satır sayısını alır.
            Birinci for dögüsünde i değeri 1'den başlayarak birer artar line değerine kadar line değeride dahil.
            İkinci for döngüsünde j 0'dan başlar. Birer artarak i değerine kadar ekrana yıldız basar.
            Sonrasında alt satıra geçer.

         */
    static void left(long line) {
        for (long i =1 ; i <= line; i++) {
            for (long j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
