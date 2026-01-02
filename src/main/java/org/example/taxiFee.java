package org.example;

import java.util.Scanner;

public class taxiFee {
    /**
     * taxi
     * km dau tien 13000
     * tu km thu 2 choi km 10000 km
     * tu km thu 11 tro di 8000 km
     */
    public int inputKm() {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        while (a <= 0) {
            System.out.println("Enter Km:");
            a = scanner.nextInt();
        }
        return a;
    }

    public static void main(String[] args) {
        taxiFee taxiFee = new taxiFee();
        int a = taxiFee.inputKm();
        float total = 0;
        if (a >= 1) {
            total = 13000;
        }
        if (a > 1 && a < 10) {
            total = total + 9 * 10000;
        } else if (a > 10) {
            total = total + 9 * 10000;
            total = total + (a - 10) * 8000;
        }

        System.out.println("Total ="+ total);
    }
}
