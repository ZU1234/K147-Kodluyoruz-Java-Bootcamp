
/*
47 sayısını ters çevirip kendisiyle toplarsak; 47 + 74 = 121, bir palindromik sayı elde etmişoluruz. Bu prosedürle,
yani ters çevirip kendisiyle toplayarak, her sayıdan bir palindromik sayı üretmek bu kadar kolay değildir. Bazı
sayılar için bu işlemi defalarca tekrar ederek bir palindromik sayıya ulaşırız. Örneğin, 349 sayısı için bu
işlemi 3 kez zincirleme olarak tekrarlamamız gerekmektedir:Buna göre, 10’dan 100’e kadar olan sayılardan bu
prosedürle bir palindromik sayı elde edene kadar hangi sayı için en uzun zincirin oluşacağını bulan ve zinciri
ekrana yazdıran programı yazınız.


*/

public class Main {
    public static void main(String[] args) {

        Palindrome.longestChainPrint(Palindrome.longestChainNumbers(10,100 ));

    }




}