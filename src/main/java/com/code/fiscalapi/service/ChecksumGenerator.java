package com.code.fiscalapi.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ChecksumGenerator {

    public String getLastCharacterOfFiscalCode(String generatedCode) {
        Map<String, Integer> oddMap = getOddMap();
        Map<String, Integer> evenMap = getEvenMap();
        Map<Integer, String> remainderMap = getRemainderMap();
        String evenString = "";
        String oddString = "";
        Integer counter = 0;

        for (int i = 0; i < generatedCode.length(); i++) {
            if (i % 2 == 0) {
                evenString += generatedCode.charAt(i);
            } else {
                oddString += generatedCode.charAt(i);
            }
        }

        counter += iterateStringToGenerateSum(oddMap, oddString, counter);
        counter += iterateStringToGenerateSum(evenMap, evenString, counter);

        return remainderMap.get(counter % 26);
    }

    private Integer iterateStringToGenerateSum(Map<String, Integer> valueMap, String characterString, int counter) {
        for (int i = 0; i < characterString.length(); i++) {
            counter += valueMap.get(String.valueOf(characterString.charAt(i)));
        }
        return counter;
    }

    private Map<Integer, String> getRemainderMap() {
        Map<Integer, String> remainderMap = new HashMap<>();
        remainderMap.put(0, "A");
        remainderMap.put(1, "B");
        remainderMap.put(2, "C");
        remainderMap.put(3, "D");
        remainderMap.put(4, "E");
        remainderMap.put(5, "F");
        remainderMap.put(6, "G");
        remainderMap.put(7, "H");
        remainderMap.put(8, "I");
        remainderMap.put(9, "J");
        remainderMap.put(10, "K");
        remainderMap.put(11, "L");
        remainderMap.put(12, "M");
        remainderMap.put(13, "N");
        remainderMap.put(14, "O");
        remainderMap.put(15, "P");
        remainderMap.put(16, "Q");
        remainderMap.put(17, "R");
        remainderMap.put(18, "S");
        remainderMap.put(19, "T");
        remainderMap.put(20, "U");
        remainderMap.put(21, "V");
        remainderMap.put(22, "W");
        remainderMap.put(23, "X");
        remainderMap.put(24, "Y");
        remainderMap.put(25, "Z");
        return remainderMap;
    }

    private Map<String, Integer> getOddMap() {
        Map<String, Integer> oddMap = new HashMap<>();
        oddMap.put("0", 1);
        oddMap.put("1", 0);
        oddMap.put("2", 5);
        oddMap.put("3", 7);
        oddMap.put("4", 9);
        oddMap.put("5", 13);
        oddMap.put("6", 15);
        oddMap.put("7", 17);
        oddMap.put("8", 19);
        oddMap.put("9", 21);
        oddMap.put("A", 1);
        oddMap.put("B", 0);
        oddMap.put("C", 5);
        oddMap.put("D", 7);
        oddMap.put("E", 9);
        oddMap.put("F", 13);
        oddMap.put("G", 15);
        oddMap.put("H", 17);
        oddMap.put("I", 19);
        oddMap.put("J", 21);
        oddMap.put("K", 2);
        oddMap.put("L", 4);
        oddMap.put("M", 18);
        oddMap.put("N", 20);
        oddMap.put("O", 11);
        oddMap.put("P", 3);
        oddMap.put("Q", 6);
        oddMap.put("R", 8);
        oddMap.put("S", 12);
        oddMap.put("T", 14);
        oddMap.put("U", 16);
        oddMap.put("V", 10);
        oddMap.put("W", 22);
        oddMap.put("X", 25);
        oddMap.put("Y", 24);
        oddMap.put("Z", 23);

        return oddMap;
    }

    private Map getEvenMap() {
        Map<String, Integer> evenMap = new HashMap<>();
        evenMap.put("0", 0);
        evenMap.put("1", 1);
        evenMap.put("2", 2);
        evenMap.put("3", 3);
        evenMap.put("4", 4);
        evenMap.put("5", 5);
        evenMap.put("6", 6);
        evenMap.put("7", 7);
        evenMap.put("8", 8);
        evenMap.put("9", 9);
        evenMap.put("A", 0);
        evenMap.put("B", 1);
        evenMap.put("C", 2);
        evenMap.put("D", 3);
        evenMap.put("E", 4);
        evenMap.put("F", 5);
        evenMap.put("G", 6);
        evenMap.put("H", 7);
        evenMap.put("I", 8);
        evenMap.put("J", 9);
        evenMap.put("K", 10);
        evenMap.put("L", 11);
        evenMap.put("M", 12);
        evenMap.put("N", 13);
        evenMap.put("O", 14);
        evenMap.put("P", 15);
        evenMap.put("Q", 16);
        evenMap.put("R", 17);
        evenMap.put("S", 18);
        evenMap.put("T", 19);
        evenMap.put("U", 20);
        evenMap.put("V", 21);
        evenMap.put("W", 22);
        evenMap.put("X", 23);
        evenMap.put("Y", 24);
        evenMap.put("Z", 25);

        return evenMap;
    }
}
