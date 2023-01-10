package com.medium.model;

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
}
