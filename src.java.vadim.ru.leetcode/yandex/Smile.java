package yandex;

public class Smile {
    public static void main(String[] args) {
        String s = "Привет :-(((( я сегодня грустный";
        String s2 = "Привет :-)) я сегодня веселый или грустный :-(";

        System.out.println(s.replaceAll(":-[()]+", ""));
        System.out.println(s2.replaceAll(":-[()]+", ""));
    }
}
