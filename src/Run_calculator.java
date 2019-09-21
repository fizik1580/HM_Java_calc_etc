import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Run_calculator {

    public static void main(String[] args) {

                //Program info

        System.out.println("Программа может выполняться в двух режимах:");
        System.out.println("1 - Калькулятор с авто округлением до 4 знака после запятой (Доступные операции: складывание/вычитание/умножение/деление двух дробных чисел введённых пользователем.");
        System.out.println("2 - Поиск максимального(по длинне) слова в массиве. Размерность массива задаётся пользователем");

                //Var

        float first_val = 0, second_val = 0, rezult = 0; //Для дробных значений пользоваиеля
        int to_print_counter;
        int counter_i; //Счетчики
        int array_bound = 0; //Граница массива
        boolean succes_flag = false; //Флаг выполнения
        String thread_choice; //Строка куда запихиваем выбор пользователя
        String max_len = null; //Для строки с максимальной длинной
        String action_choice = null; //Для выбора арифметического действия

//--------------------------------------------------------------------------------------------------------------------//
                //
                //User's thread choice
                //

        System.out.println("Выберите вариант выполнения программы, то есть введите 1 или 2:");

        do {

            succes_flag = false;

            Scanner in = new Scanner(System.in);
            thread_choice = in.next();

            if (thread_choice.isEmpty()) {

                System.out.println("Строка пуста! Введите значение");
                succes_flag = !succes_flag;
            }

            else if (!thread_choice.equals("1") && !thread_choice.equals("2")){

                System.out.println("Значения строки недопустимы! Введите корректное значение");
                succes_flag = !succes_flag;
            }

        } while (succes_flag);

                //
                //End of user's thread choice
                //
//--------------------------------------------------------------------------------------------------------------------//
                //
                //First thread
                //

        if (thread_choice.equals("1")){

            succes_flag = true;
            System.out.println("Введите первую дробь:");

            while (succes_flag) {

                try {

                    Scanner in = new Scanner(System.in);
                    first_val = in.nextFloat();
                    succes_flag = !succes_flag;

                } catch (java.util.InputMismatchException e) {

                    System.out.println("Ошибочный ввод: введите действительное число  или же проверьте что дробь введена в формате х,х");

                }
            }

            succes_flag = true;
            System.out.println("Введите вторую дробь:");

            while (succes_flag) {

                try {

                    Scanner in = new Scanner(System.in);
                    second_val = in.nextFloat();
                    succes_flag = !succes_flag;

                    if (second_val == 0){

                        System.out.println("Второе значение = 0. Операция деления будет нелоступна!");

                    }

                } catch (java.util.InputMismatchException e) {

                    System.out.println("Ошибочный ввод: введите действительное число или же проверьте что дробь введена в формате х,х");

                }
            }

            System.out.println("Выберите арифметическое действие из доступных введя его символ:");
            System.out.println("Для сложения введите +");
            System.out.println("Для вычитания введите -");
            System.out.println("Для умножения введите *");
            System.out.println("Для деления введите /");

            succes_flag = true;

            while (succes_flag){

                Scanner in = new Scanner(System.in);
                action_choice = in.next();

                succes_flag = true;

                if (action_choice.equals("+")){

                    rezult = first_val + second_val;
                    succes_flag = !succes_flag;

                }
                else if (action_choice.equals("-")){

                    rezult = first_val - second_val;
                    succes_flag = !succes_flag;

                }
                else if (action_choice.equals("*")){

                    rezult = first_val * second_val;
                    succes_flag = !succes_flag;

                }
                else if ((action_choice.equals("/")) && (second_val != 0)){

                    rezult = first_val / second_val;
                    succes_flag = !succes_flag;

                }
                else if ((action_choice.equals("/")) && (second_val == 0)){

                    System.out.println("Внимание! Значение второй переменной = 0. Деление не может быть выполнено корректно. Выберите другую операцию");

                }
                else{

                    System.out.println("Введён некорректный символ! Повторите ввод.");

                }
            }

            System.out.println("Итог операции = " + first_val + " " + action_choice + " " + second_val + " = " + rezult);
            //rezult = rezult * 10000;
            //rezult = Math.round(rezult);
            //rezult = rezult / 10000;

            BigDecimal rezult_n = new BigDecimal(rezult).setScale(4,RoundingMode.HALF_UP);

            System.out.println("Округлённое до 4 знака после запятой значение = " + rezult_n);

        }

                //
                //End ofFirst thread
                //
//--------------------------------------------------------------------------------------------------------------------//
                //
                //Second thread
                //

        if (thread_choice.equals("2")){

            succes_flag = true;
            System.out.println("Введите размерность массива");

            while (succes_flag) {

                try {

                    Scanner in = new Scanner(System.in);
                    array_bound = in.nextInt();
                    succes_flag = !succes_flag;

                }
                catch (java.util.InputMismatchException e) {

                    System.out.println("Ошибочный ввод: введите натуральное число");

                }

                if (array_bound < 0){

                    System.out.println("Размерность массива не может быть меньше 0");
                    succes_flag = !succes_flag;

                }
            }

                //Инициализируем массив строк

                String[] array = new String[array_bound];

                //Заполняем массив

            for (counter_i = 0; counter_i < array_bound; counter_i++){

                to_print_counter = counter_i + 1;
                System.out.println("Введите " + to_print_counter + " элемент массива:");
                Scanner in = new Scanner(System.in);
                array[counter_i] = in.next();

                if (counter_i == 0){

                    max_len = array[counter_i];

                }
                else{

                    if (array[counter_i].length() > max_len.length()){

                        max_len = array[counter_i];

                    }

                }

            }

            System.out.println("Ваш массив:");

            for (counter_i = 0; counter_i < array_bound; counter_i++) {

                System.out.println(array[counter_i]);

            }

            System.out.println("Самое длинное слово: " + max_len);

        }

        //
        //End of Second thread
        //
//--------------------------------------------------------------------------------------------------------------------//
    }
}
