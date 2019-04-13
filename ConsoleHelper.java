package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Вспомогательный класс, для чтения или записи в консоль
 * В дальнейшем, вся работа с консолью должна происходить через этот класс.
 */
public class ConsoleHelper {

    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * должен выводить сообщение message в консоль
     * @param message - сообщение
     */
    public static void writeMessage(String message){
        System.out.println(message);
    }

    /**
     * должен считывать строку с консоли.
     * Если во время чтения произошло исключение, вывести пользователю
     * сообщение и повторить ввод.
     * @return - строку с консоли
     */
    public static String readString(){
        String s = "";
        while (true){
            try {
                s = consoleReader.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                continue;
            }
        }
        return s;
    }

    /**
     * должен возвращать введенное число и
     * использовать метод readString(). Внутри метода обработать исключение
     * NumberFormatException. Если произошло NumberFormatException
     * вывести сообщение и повторить ввод числа.
     * @return - число
     */
    public static int readInt(){
        int number = -1;
        while (true){
            try {
                number = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
                continue;
            }
        }
        return number;
    }
}
