package com.emlakcepte.question1B.model;

public class ErrorMessage {
    public static String password(String msg) {
        switch (msg) {
            case "password<5":
                msg = "Şifre en az 5 karakterli olmalıdır.";
                break;
            case "oldPassword":
                msg = "Parolanız son 3 şifreniz ile aynı olamaz!";
                break;
            case "error":
                msg = "Hatali kullanici girisi. Eger uye degilseniz uye olunuz.";
                break;

            default:
        }


        //JOptionPane.showMessageDialog(null,msg);;
        return msg;
    }

    public static String realty(String msg) {
        switch (msg) {
            case "realty>3":
                msg = "Bireysel kullaniclar konut tipinde en fazla 3 ilan girebilir.";
                break;


        }
        return msg;
    }

    public static String login(String msg) {
        switch (msg) {
            case "success":
                msg = "Kayit basarili.";
                break;
            case "register":
                msg = "Kaydiniz mevcuttur.";
                break;
            case "no_registration":
                msg = "Kullanici kaydi mevcut degil! Lutfen kayit olunuz.";
                break;
            case "login_up":
                msg = "Lutfen giris yapiniz. Kayitli degilseniz kayit olunuz.";
                break;
            default:
        }


        return msg;
    }
}
