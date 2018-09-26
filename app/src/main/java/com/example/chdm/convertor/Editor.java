package com.example.chdm.convertor;

/**
 * Created by Dima on 27.09.2018.
 */

public class Editor {
    private static String line = "0";

    /**
     * Добавление символа
     * @param c Символ
     * @return Строка этих символов
     */
    public static String add(int c)
    {
        c = c - 48;
        char s;
        if (c < 10)
            s = (char)('0' + c);
        else
            s = (char)('A' + c - 17);
        if (line.equals("0"))
            line = "" + s;
        else
            line += s;
        return line;
    }

    /**
     * Добавление точки
     * @return Строка этих символов
     */
    public static String addDot()
    {
        line += ".";
        return line;
    }

    /**
     * Очищает конвертор
     * @return Строка этих символов
     */
    public static String clear()
    {
        line = "0";
        return line;
    }

    /**
     * Удаляет последний введеный символ
     * @return Строка этих символов
     */
    public static String back()
    {
        line = line.substring(0, line.length() - 1);
        if (line.equals(""))
            line = "0";
        return line;
    }
}
