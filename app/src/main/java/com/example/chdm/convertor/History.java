package com.example.chdm.convertor;

/**
 * Created by Dima on 27.09.2018.
 */

public class History {
    /**
     * Номер строки в истории
     */
    static int num = 0;
    /**
     * Содержимое истории
     */
    static String story = "";

    /**
     * Добавление истории
     * @param inP Система счисления 1-го числа
     * @param outP Система счисления 2-го числа
     * @param IN Входное число
     * @param OUT Переведенное число
     */
    public static void add(int inP, int outP, String IN, String OUT)
    {
        num++;
        story += num + ". " + IN + " (" + outP + " -> " + inP + ") " + OUT + ";" + "\n";
    }

    /**
     * Очистка истории
     */
    public static void clear()
    {
        num = 0;
        story = "";
    }

    /**
     * Взятие истории
     * @return
     */
    public static String getHistory()
    {
        return story;
    }
}
