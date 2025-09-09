package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        if (d > b) {
            System.out.println(d);
        }
        if ((a > b) && (c < d)) {
            System.out.println(a);
        }
        if ((a | c) < d) {
            System.out.println(c);
        } else {
            System.out.println("not");
        }
        int number = in.nextInt();
        switch (number) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            default:
                System.out.println("many");
                break;
        }
        int res = (a < d) ? a + d : a - d;
        System.out.println(res);
        System.out.println("Квадрат чисел от 1 до n: ");
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "^2 = " + (i * i));
        }
        System.out.println("//////");
        System.out.println("Счет от 1 до m: ");
        int m = in.nextInt();
        int j = 5;
        while (j <= m) {
            System.out.println(j);
            j++;
        }
        System.out.println("//////");
        System.out.println("Числа от 1 до 20, пропускаем кратные 3, прерываем на 15:");
        for (int k = 1; k <= 20; k++) {
            if (k == 15) {
                break;      // сначала проверяем условие выхода
            }
            if (k % 3 == 0) {
                continue;   // потом пропускаем кратные 3
            }
            System.out.println(k);
        }

        System.out.println("//////");
        int x = in.nextInt();
        do {
            System.out.println("Hello");
            x++;
        } while (x < 5);

        System.out.println("//////");
        int[] arr = {8, 45, 123, 77, 0};
        for (int l = 0; l < arr.length; l++) {
            System.out.println(arr[l]);
        }

        int p = 10;
        p++;
        int w = 11;
        System.out.println(w == p);
        System.out.println("-----");

        Integer aa = 1;
        Integer bb = 1;
        Integer cc = new Integer(1);

        System.out.println(aa == bb); // true
        System.out.println(aa == cc); // false
        System.out.println(aa.equals(cc));// true

        System.out.println("/////////");

        boolean f = true;
        Boolean g = true;
        Boolean h = Boolean.valueOf(true);

        System.out.println(f == g);          // true
        System.out.println(g.equals(h));     // true

        System.out.println("/////////");
        long r = 1000L;
        Long s = 1000L;
        Long q = Long.valueOf(1000L);

        System.out.println(r == s);           // true
        System.out.println(s.equals(q));      // true
        System.out.println(s == new Long(1000L)); // false

        /*Integer t = null;
        Integer dd = t + 1;
        System.out.println(dd);*/

        System.out.println("Замена: ");
        String text = "Works, don't touch";
        String rep = text.replace("o", "a");
        System.out.println(rep);

        System.out.println("Обрезка: ");
        String full = "Powered by coffee, pizza and pure magic";
        String ind = full.substring(0, 17);
        System.out.println(ind);

        System.out.println("Разбиение: ");
        String str = "It's not a bug it's a feature.";
        String[] tex = str.split(" ");

        for (String resl : tex) {
            System.out.println(resl);
        }
        System.out.println("///////");
        String str1 = "coffe";
        String str2 = "coffe";
        String str3 = new String("coffe");
        String str4 = "COFFE";
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str1.equals(str3));//true
        System.out.println(str1.equals(str4));//false
        System.out.println(str1.equalsIgnoreCase(str4));//true

        System.out.println("///////");
        StringBuilder sb = new StringBuilder();

        //добавление в конец
        sb.append("my ");
        sb.append("name ");
        sb.append("is Alina");
        System.out.println(sb.toString());

        sb.delete(0, 8);
        System.out.println(sb.toString());

        sb.deleteCharAt(5);
        System.out.println(sb.toString());


        in.close();
    }
    }


