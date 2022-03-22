public class Converter {
    public int romanToArabic(String romanStr) {


        if (romanStr.equals("I")) return 1;
        if (romanStr.equals("II")) return 2;
        if (romanStr.equals("III")) return 3;
        if (romanStr.equals("IV")) return 4;
        if (romanStr.equals("V")) return 5;
        if (romanStr.equals("VI")) return 6;
        if (romanStr.equals("VII")) return 7;
        if (romanStr.equals("VIII")) return 8;
        if (romanStr.equals("IX")) return 9;
        if (romanStr.equals("X")) return 10;

        return 0;
    }

    public String transform_number_to_roman_numeral(int number) {
        int[] roman_value_list = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_char_list = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman_value_list.length; i += 1) {
            while (number >= roman_value_list[i]) {
                number -= roman_value_list[i];
                res.append(roman_char_list[i]);
            }
        }
        return res.toString();
    }
}
