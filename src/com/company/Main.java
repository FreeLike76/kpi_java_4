package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter coefficients:\nExample: 1 2 3 >>> 1 + 2x + 3x^2 = 0\n");
        ArrayList<Integer> a = readArray();
        ArrayList<Integer> b = readArray();

        printAsPolynom(a);
        printAsPolynom(b);
        System.out.print("Result:\n");
        ArrayList<Integer> c = multArrays(a, b);
        printAsPolynom(c);
    }

    public static ArrayList<Integer> readArray() {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> x = new ArrayList<>();
        for (String str : input.nextLine().split(" ")) {
            x.add(Integer.parseInt(str));
        }
        return x;
    }

    public static ArrayList<Integer> multArrays(ArrayList<Integer> a, ArrayList<Integer> b) {
        int size = a.size() + b.size() - 1;
        ArrayList<Integer> x = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            x.add(0);
        }

        for (int ai = 0; ai < a.size(); ai++) {
            for (int bi = 0; bi < b.size(); bi++) {
                x.set(ai + bi, x.get(ai + bi) + a.get(ai) * b.get(bi));
            }
        }
        return x;
    }

    public static void printAsPolynom(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print("(" + array.get(i) + ")*X^" + i + " ");
            if( i != array.size() - 1){
                System.out.print("+ ");
            }
        }
        System.out.print("= 0\n");
    }
}
