import java.util.Scanner;

public class Run_calculator {

    public static void main(String[] args) {

                //Program info

        System.out.println("Программа может выполняться в двух режимах:");
        System.out.println("1 - Калькулятор, то есть скеладывать/вычитать/умножать/делить два дробных числа введённых пользователем.");
        System.out.println("2 - Поиск максимального(по длинне) слова в массиве. Размерность массива задаётся пользователем");

                //Var

        boolean succes_flag = false;
        String thread_choice;

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
    }
}
