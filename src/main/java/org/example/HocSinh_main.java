package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class HocSinh_main {
    public static void main(String[] args) {
        ArrayList<HocSinh> classroom = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            classroom.add(new HocSinh(randomName(), randomAge(), randomSccore()));
        }
        classroom.stream().forEach(HocSinh::info);
    }

    public static String randomName() {
        String[] names = {"Van", "Mai", "Huong", "Trinh", "Tran", "Phuong", "Tuan"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    public static int randomAge() {
        Random random = new Random();
        return random.nextInt(25 - 18 + 1) + 18;
    }

    public static double randomSccore() {
        Random random = new Random();
        double score = 1.0 + 9.0 * random.nextDouble();
        return Math.round(score * 10) / 10;
    }
}
