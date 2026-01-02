package org.example;

public class uppercaseFirstLetter {
    public String result(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        char[] arr = line.toCharArray();
        StringBuilder finalResult = new StringBuilder();
        StringBuilder newFinalResult = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (i == 0) {
                current = Character.toUpperCase(current);
                finalResult.append(current);
            } else if (arr[i - 1] == ' ' && arr[i] != ' ') {
                current = Character.toUpperCase(current);
                finalResult.append(current);
            } else if (arr[i] != ' ') {
                finalResult.append(current);
            }
        }
        for (int i = 0; i < finalResult.length(); i++) {
            char c = finalResult.charAt(i);
            if (i == 0){
                newFinalResult.append(c);
            } else if (Character.isUpperCase(c)){
                newFinalResult.append(' ');
                newFinalResult.append(c);
            } else {
                newFinalResult.append(c);
            }

        }
        return newFinalResult.toString().trim();
    }

    public static void main(String[] args) {
        uppercaseFirstLetter uppercaseFirstLetter = new uppercaseFirstLetter();
        System.out.println(uppercaseFirstLetter.result("      i       love       you!!!"));
    }
}
