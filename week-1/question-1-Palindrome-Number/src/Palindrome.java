import java.util.ArrayList;
import java.util.Objects;

public final class Palindrome {

    public Palindrome() {
    }

    /*
       Sayının polindrome olup olmadığını kontrol eden method.
       num değerini string'e çevirip parçalar halinde string dizesine atarız.Dizinin son elemanının indisini değişkene
       atarız.Palindrome kuralına göre karşılaştırma yaparız. j indisi en sondan başlayarak azalır ve obj ise 0.indesten
       başlayarak elemanları getirir. j indisinde ki eleman ile obj'deki eleman eşit olmadığında döngü durur ve method
        false döndürür. Girdi polindrome değildir.j değeri bir azalır ve j ye atar. j değeri dizi uzunluğunun yarısından
        az mı kontrolü yapılır.döngü sonlanır.Herhangi bir eşitsizlik olmadığında method true döndürür. Girdi polindromdur.
       */
    static boolean isPalindrome(Long num) {
        String[] inpNum = String.valueOf(num).split("");
        int j = inpNum.length - 1;

        for (String obj : inpNum) {
            if (!Objects.equals(obj, inpNum[j])) {
                return false;
            }
            j--;
            if (j < inpNum.length / 2) {
                break;
            }
        }

        //
        return true;
    }

    /*Sayıyı ters çevirir.
      num değerini string'e çevirip parçalar halinde string dizesine atarız ve bir String değişkeni tanımlarız.for
      döngüsünü son eleman indisinden başlatırız.Her turda i değeri birer azalır.Döngü sıfırdan küçük i değerine
      sahip olana kadar devam  eder. reverse değişeken değerine i. indisteki elamanı ekler ve reverse değişkenine
      atarız.Method reverse değerinin int tipini döndürür.
    */
    static long reverse(long num) {

        String[] inpNum = String.valueOf(num).split("");
        String reverse = "";

        for (int i = inpNum.length - 1; i >= 0; i--) {
            reverse = reverse.concat(inpNum[i]);
        }
        long result= Long.parseLong(reverse);

        return result;
    }

    //sayıyı ters çevirip kendisiyle toplar.
    static long reverseSum(long num) {
        return num + reverse(num);
    }

    /*
         Eğer array boş değilse; for-each ile longestChainNum arrayinin elemanlarını tek tek gezer. ve ekrana
         eleman + elemanın tersi = sonuç
         işlemini yazıdırır. num değeri polindrome olduğunda ekrana
         >>>>  Palindrome number.  count  step."
         yazdırır.Burada count kaç adımda polindromu bulduğumuzu gösteren değerdir.

     */
    static void longestChainPrint(ArrayList<Integer> longestChainNum) {
        if(longestChainNum!=null){


            for (long num : longestChainNum) {
                int count = 0;
                do {

                    System.out.print("\n" + num + "+" + Palindrome.reverse(num) + "=" + Palindrome.reverseSum(num));
                    num = Palindrome.reverseSum(num);
                    count++;
                } while (!Palindrome.isPalindrome(num));
                if (Palindrome.isPalindrome(num)) {
                    System.out.println("  >>>>  Palindrome number." + count + " step.");
                }
            }
        }
    }


    /*
        end ve start değerleri for döngüsünde kullanılacaktır. Bu sebeple negatif olma durumu ve end değeri start
    değerinden büyük mü kontrolü yapılır. Eger bu kontrol false verirse hata fırlatır ve uyarır.Probleme göre en uzun
    zincir sayısına sahip birden fazla sayı olabilir.Bu sebeple en uzun sayıları tutmak için polindromeNumbersResult
    array'ini oluşturuyoruz.Maximum zincir sayısını atayacağımız maxCount değişkenini belirtiyoruz. For düngüsünde i
    değerini result değişkenine atıyoruz ve sayaç olarak kullanıcak count değişkenini tanımlıyoruz 0 değerini
    atıyoruz.
        do-while dongüsü içerisin de result değişkenine sayıyı ters çevirip kendisi ile toplayan methodu
    kullanarak methodun döndürdüğü değeri atıyoruz. Sayac olan count değerini bir arttırıyoruz.result değerinin
    polindrom olaması durumunda döngüden çıkılır.

        result değeri polindrome ise ve maxCount değeri, count değerinden küçük ise maxCount değerine count değerini
    atıyoruz ve arrayi temizleyip kurala uyan değeri array e ekliyoruz. Eğer result polindrome ise ve maxCount
    değeri count değerine eşit olursa array e kurala uyan değeri  ekliyoruz.

    Method polindromeNumbersResult arrayini döndürür.
      */
    static ArrayList<Integer> longestChainNumbers(long start, long end) {

        ArrayList<Integer> palindromeNumbersResult;
        if (end > start && end > 0 && start > 0) {

            palindromeNumbersResult = new ArrayList<>();

            int maxCount = 0;

            for (long i = start; i < end; i++) {

                long result = i;
                int count = 0;

                do {
                    result = Palindrome.reverseSum(result);
                    count++;

                } while (!Palindrome.isPalindrome(result));

                if (Palindrome.isPalindrome(result)) {
                    if (maxCount < count) {
                        maxCount = count;
                        palindromeNumbersResult.clear();
                        palindromeNumbersResult.add((int) i);
                    } else if (maxCount == count) {
                        palindromeNumbersResult.add((int) i);

                    }

                }


            }
            return palindromeNumbersResult;
        } else {

            Exception e = new Exception("Baslangic degeri bitis degerinden kucuk yada esit olamaz. Baslangic ve bitis " +
                    "degeri pozitif olmalidir.");
            e.printStackTrace();

            return null;
        }

    }
}