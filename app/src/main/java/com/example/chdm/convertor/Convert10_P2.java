package com.example.chdm.convertor;

/**
 * Created by Dima on 27.09.2018.
 */

public class Convert10_P2 {
    /**
     * Система счисления
     */
    private static int system = 0;
    /**
     * Точность
     */
    private final static int ACCURACY = 15;

    /**
     * Конвертирует число num в P систему
     * @param num
     * @return
     */
    public static String convert(double num)
    {
        if(num % 1 == 0)
            return int10ToP((long)num);//без знака
        else
            return int10ToP((long) num) + frac10ToP(num - (long)num);//со знаком
    }

    /**
     * Установка системы счисления
     * @param n Система счисления
     */
    public static void setSystem(int n)
    {
        system = n;
    }

    /**
     * int -> char
     * @param d
     * @return
     */
    private static char intToPChar(int d)
    {
        return (char)d;
    }

    /**
     * Переводит целую часть 10-го числа в P систему
     * @param r
     * @return
     */
    private static String int10ToP(long r)
    {
        String main_part = "";
        while (r >= system)
        {
            long count = r % system;
            if (count >= 10)
                main_part = (char)(count - 10 + 'A') + main_part;
            else
                main_part = (char)(count + '0') + main_part;
            r -= count;
            r /= system;
        }
        if (r >= 10)
            main_part = (char)(r - 10 + 'A') + main_part;
        else
            main_part = (char)(r + '0') + main_part;
        return main_part;
    }

    /**
     * Переводит дробную часть 10-го числа в P систему
     * @param f
     * @return
     */
    private static String frac10ToP(double f)
    {
        String extra_part = ".";
        for (int i = 0; i < ACCURACY && f > 0; i++)
        {
            f *= system;
            long count = (long)f;
            f -= count;
            if (count >= 10)
                extra_part = extra_part + (char)(count - 10 + 'A');
            else
                extra_part = extra_part + (char)(count + '0');
        }
        return extra_part;
    }

    /**
     * Получение системы счисления
     * @return
     */
    public static long getSystem()
    {
        return system;
    }
}
