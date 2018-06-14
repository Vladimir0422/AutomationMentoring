package homeWork.module8.task1;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 6/4/2018
 */


public class CompressorForWords {
    public static void main(String[] args) {
        String stringForCompress = "h2elloooooooooooo2";
        String stringForUncompress = "hel2o9o9o9o9o2";

        System.out.println(compressString(stringForCompress));
        System.out.println(uncompressString(stringForUncompress));
    }

    public static String compressString(String stringForCompress) {
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
//        System.out.println(newString.toString());
        return stringForCompress;
    }

    public static String uncompressString (String stringForUncompress){
        final char MIN_NUMBER = 47;
        final char MAX_NUMBER = 58;
        StringBuilder newString = new StringBuilder();
        int numberOfRepeatedValue = 0;
        char previousCharacter = stringForUncompress.charAt(0);
        try {
            for (int i = 1; i < stringForUncompress.length(); i++) {
                if (stringForUncompress.charAt(i) > MIN_NUMBER && stringForUncompress.charAt(i) < MAX_NUMBER) {
                    numberOfRepeatedValue = Integer.parseInt(String.valueOf(stringForUncompress.charAt(i)));
                    for (int j = 1; j < numberOfRepeatedValue; j++) {
                        newString.append("" + previousCharacter);
                    }
                } else {
                    newString.append(previousCharacter);
                    previousCharacter = stringForUncompress.charAt(i);
                }
            }
            newString.append(previousCharacter);

            System.out.println(newString.toString());
        } catch (Exception e) {
            System.out.println("Isn't correct value");
        }
        return stringForUncompress;
    }

}

