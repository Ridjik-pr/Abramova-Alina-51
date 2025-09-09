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
        }
        else{
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
        int res = (a<d) ? a+d : a-d;
        System.out.println(res);
        in.close();
    }
}
