import java.util.Scanner;

public class Run_calculator {

    public static void main(String[] args) {

                //Program info

        System.out.println("Программа может выполняться в двух режимах:");
        System.out.println("1 - Калькулятор, то есть складывать/вычитать/умножать/делить два дробных числа введённых пользователем.");
        System.out.println("2 - Поиск максимального(по длинне) слова в массиве. Размерность массива задаётся пользователем");

                //Var

        int to_print_counter;
        int counter_i; //Счетчики
        int array_bound = 0; //Граница массива
        boolean succes_flag = false; //Флаг выполнения
        String thread_choice; //Строка куда запихиваем выбор пользователя
        String max_len = null; //Для строки с максимальной длинной

                //User's thread choice:

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
    }
}
