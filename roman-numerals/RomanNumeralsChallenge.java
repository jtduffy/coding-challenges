public class RomanNumeralsChallenge {

    public static void main(String [] args) {
        RomanNumeralsChallenge challenge = new RomanNumeralsChallenge();

        // Convert an int into a roman numeral String
        System.out.println("4000 should be MMMM:   " + challenge.intToRomanNumeral(4000));
        System.out.println("1000 should be M:   " + challenge.intToRomanNumeral(1000));
        System.out.println("1001 should be MI:   " + challenge.intToRomanNumeral(1001));
        System.out.println("900 should be CM:   " + challenge.intToRomanNumeral(900));
        System.out.println("1764 should be MDCCLXIV:   " + challenge.intToRomanNumeral(1764));
        System.out.println("4 should be IV:   " + challenge.intToRomanNumeral(4));
        System.out.println("1 should be I:   " + challenge.intToRomanNumeral(1));
    }

    public int romanNumeralToInt(String romanNumeral) {
        // Two parallel arrays, one for symbols and another with the mapped integer value. Could
        // do a HashMap, but this is easier to initialize in Java.
        final String [] romanNumerals = {"M", "M", "D", "C", "L", "X", "V", "I" };
        final int [] values = {1000, 500, 100, 50, 40, 10, 5, 1};

        if (romanNumeral.isEmpty()) {
            throw new IllegalArgumentException("Invalid Roman Numeral String");
        }

        return 0;
    }
    public String intToRomanNumeral(int value) {
        // Two parallel arrays, one for symbols and another with the mapped integer value. Could
        // do a HashMap, but this is easier to initialize in Java.

        // Based on the rules of roman numerals, these are the possible symbols that can make up a value.
        final String [] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        final int [] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder("");

        // No go if value is < 1 or > 4000
        if (value < 1 || value > 4000) {
            throw new IllegalArgumentException("value must be > 1 && <= 4000");
        }

        // Since the arrays are highest values --> lowest, we simply add the corresponding roman numeral
        // to our result as long as the value is greater/equal than the current roman numeral. This means
        // only one time looping through the roman numeral list, with potentially looping multiple times
        // as we subtract the roman numeral integer value from our overall target value.
        for (int idx = 0; idx <romanNumerals.length; idx++) {
            while (value >= values[idx]) {
                result.append(romanNumerals[idx]);
                value -= values[idx];
            }
        }

        return result.toString();
    }
}
