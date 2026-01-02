package org.example;

public class chanLe {
    public String checkchanLe(int a){
        if (a%2 == 0){
            return "so chan";
        } else {
            return "so le";
        }

    }
    public static void main(String[] args){
        chanLe chanLe = new chanLe();
        System.out.println(chanLe.checkchanLe(2023));
    }
}
