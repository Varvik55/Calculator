

import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    // Объявление статической переменной для определения того, используются ли арабские числа
    private static boolean its_an_arabic_numbers = true;

    // Метод pars принимает строку input и возвращает массив строк, полученных разбиением строки по пробелам
    private static String[] pars(String input) {
        // Разбиение входной строки на подстроки по пробелам и удаление лишних пробелов в начале и конце строки
        String[] parsed_input = input.trim().split(" ");

        // Проверка, что количество элементов в массиве после разбиения равно 3
        if (parsed_input.length != 3) {
            // Создание объекта Scanner для повторного ввода данных с клавиатуры
            Scanner input_a_value_again = new Scanner(System.in);

            // Вывод сообщения пользователю о неверном формате ввода и запрос нового ввода
            System.out.println("Неверный формат ввода данных. Введите выражение, разделяя каждый символ _пробелом_");
            input = input_a_value_again.nextLine();

            // Закрытие Scanner после использования для предотвращения утечки ресурсов
            input_a_value_again.close();

            // Рекурсивный вызов метода pars с новым вводом
            return pars(input);
        } else {
            // Возвращение массива строк, если формат ввода верен
            return parsed_input;
        }
    }


    public static void main(String[] args) {

        System.out.println("Hello world!");
//Для сканера
        Scanner InputExpression = new Scanner(System.in);

        System.out.print("Введите выражение в формате (2 + 2) не забудьте про ПРОБЕЛЫ между цифрами: ");
        // возвращает строку и разделяет пробелами
        String input = InputExpression.nextLine();
        // цикл до тех пор пока вводимая строка не станет пустой
        while (!input.isEmpty()) {

            String[] parsed_input = Calculator.pars(input);
            String operation = parsed_input[1];
            Number values;
            int value1 = 0;
            int value2 = 0;
            // Переводим в int. Если введены римские, выкинет исключение
            try {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);


                //values = new Arabic(value1, value2, 0);
            } catch (NumberFormatException e) {
                its_an_arabic_numbers = false;
                System.out.println("Введены римские цифры");
                //values = new Romes(parsed_input[0], parsed_input[2], 0);
            }

            if (its_an_arabic_numbers) {
                values = new Arabic(value1, value2);
            } else {
                values = new Romes(parsed_input[0], parsed_input[2]);
            }

            if (operation.equals("+")) {
                values.sum();
            } else if (operation.equals("-")) {
                values.sub();
            } else if (operation.equals("/") || operation.equals(":")) {
                values.div();
            } else if (operation.equals("*") || operation.equals("x")) {
                values.mul();
            }

            if (its_an_arabic_numbers) {
                System.out.println("Ответ: " + values.getResult());
            } else {
                System.out.println("Ответ: " + values.getStringResult());
            }
            System.out.println();
            System.out.print("Введите следующее выражение: ");
            its_an_arabic_numbers = true;
            input = InputExpression.nextLine();
        }
        System.out.println("Вы вышли из калькулятора");



    }
}
