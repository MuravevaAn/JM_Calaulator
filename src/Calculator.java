import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение в порядке \"Цифра1 оператор Цифра2\"");
        System.out.println("В качестве оператора можно вводить только + - * /");
        System.out.println("Цифры принимаются как Арабские, так и Римские. От 1/I до 10/X включительно:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(calc(str));
    }

    static String calc(String str) {
        int a;
        int b;
        String sumRoman;
        int sumArabic;
        Converter converter = new Converter();


        String[] str2 = str.split(" ");
        if (str2.length != 3) {
            throw new MyException("Ошибка, т.к. строка не является математической операцией");
        }

        boolean firstCheck = arabicOrRomanNumber(str2[0]);
        boolean secondCheck = arabicOrRomanNumber(str2[2]);

        if (firstCheck != secondCheck) {
            throw new MyException("Ошибка, используются одновременно разные системы счисления");
        }

        try {
            a = Integer.parseInt(str2[0]);
            b = Integer.parseInt(str2[2]);
            sumArabic = arabic(a, b, str2[1], true);
            return String.valueOf(sumArabic);
        } catch (NumberFormatException e) {
            a = converter.romanToArabic(str2[0]);
            b = converter.romanToArabic(str2[2]);
        }
        sumArabic = arabic(a, b, str2[1], false);
        sumRoman = converter.transform_number_to_roman_numeral(sumArabic);
        return sumRoman;
    }

    static boolean arabicOrRomanNumber (String qwe) {
        try {
            Integer.parseInt(qwe);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static int arabic(int a, int b, String operator, boolean isArabic) {
        int sum;

        if (!(a >= 1 && a <= 10)) {
            throw new MyException("Ошибка! Первое число должно быть от 1 до 10 включительно!");
        }

        if (!(b >= 1 && b <= 10)) {
            throw new MyException("Ошибка! Второе число должно быть от 1 до 10 включительно!");
        }

        switch (operator) {
            case "+" -> sum = a + b;
            case "-" -> sum = a - b;
            case "/" -> sum = a / b;
            case "*" -> sum = a * b;
            default -> throw new MyException("Ошибка! Оператор должен быть: + - * /");
        }
        if (sum <= 0 && !isArabic) {
            throw new MyException("Ошибка! в римской системе нет отрицательных чисел");
        }
        return sum;
    }
}
