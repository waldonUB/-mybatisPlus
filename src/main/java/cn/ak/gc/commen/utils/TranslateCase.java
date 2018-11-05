package cn.ak.gc.commen.utils;

public class TranslateCase {

    public static String lowerCase(String str) {
        char[] ch = str.toCharArray();
        int num = 0;
        for (char aCh : ch) {
            if (aCh >= 'A' && aCh <= 'Z') {
                num++;
            }
        }
        char[] chNew = new char[ch.length + num];
        int flag = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                chNew[i + flag] = ch[i];
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                chNew[i + flag] = '_';
                chNew[i + flag + 1] = (char) (ch[i] + 32);
                flag++;
            }
        }
        return new String(chNew);
    }

    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
