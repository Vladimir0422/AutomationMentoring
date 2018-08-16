package com.epam.mentoring.homeWork.module8.task1;

import com.sun.xml.internal.org.jvnet.mimepull.DecodingException;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/4/2018
 */


public class CompressorForWords {

    public static void main(String[] args) throws Exception {
        String stringForCompress = "h2elloooooooooooo";
        String stringForUncompress = "hel2o9o9W2";

        System.out.println(compressString(stringForCompress));
        System.out.println(uncompressString(stringForUncompress));
    }

    public static StringBuilder compressString(String stringForCompress) {
        StringBuilder newString = new StringBuilder();
        int numberOfRepeatedValue = 1;
        char previousCharacter = stringForCompress.charAt(0);

        for (int i = 1; i < stringForCompress.length(); i++) {
            if (stringForCompress.charAt(i) == previousCharacter && numberOfRepeatedValue < 9) {
                numberOfRepeatedValue++;
            } else {
                if (numberOfRepeatedValue > 1) {
                    newString.append("" + previousCharacter + numberOfRepeatedValue);
                } else if (Character.isDigit(previousCharacter)) {
                    newString.append("" + 1 + previousCharacter);
                } else {
                    newString.append(previousCharacter);
                }
                numberOfRepeatedValue = 1;
                previousCharacter = stringForCompress.charAt(i);
            }
        }
        if (numberOfRepeatedValue > 1) {
            newString.append("" + previousCharacter + numberOfRepeatedValue);
        } else if (Character.isDigit(previousCharacter)) {
            newString.append("" + 1 + previousCharacter);
        } else {
            newString.append(previousCharacter);
        }
        return newString.append(previousCharacter);
    }

    public static StringBuilder uncompressString(String stringForUncompress) throws DecodingException {

        StringBuilder newString = new StringBuilder();
        int numberOfRepeatedValue = 0;
        char previousCharacter = stringForUncompress.charAt(0);

        for (int i = 1; i < stringForUncompress.length(); i++) {
            if (Character.isDigit(stringForUncompress.charAt(i))) {
                numberOfRepeatedValue = Integer.parseInt(String.valueOf(stringForUncompress.charAt(i)));
                for (int j = 1; j < numberOfRepeatedValue; j++) {
                    newString.append("" + previousCharacter);
                }
            } else if (numberOfRepeatedValue == 5) {
                throw new DecodingException("Cannot decode this string");
            } else {
                newString.append(previousCharacter);
                previousCharacter = stringForUncompress.charAt(i);
            }
        }
        newString.append(previousCharacter);
        return newString.append(previousCharacter);
    }
}

