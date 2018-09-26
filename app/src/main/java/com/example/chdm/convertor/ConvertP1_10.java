package com.example.chdm.convertor;

/**
 * Created by Dima on 27.09.2018.
 */

public class ConvertP1_10 {
    /**
     * Система счисления
     */
    private static long system = 2;

    /**
     * Конвертирует число num в 10 систему
     * @param num
     * @return
     */
    public static double convert(String num)
    {
        if (num.contains(".") == true)
        {
            return pIntTo10(num.substring(0, num.indexOf("."))) + pFracTo10(num.substring(num.indexOf(".")));
        }
        else
            return pIntTo10(num);
    }

    /**
     * Установка системы счисления
     * @param n Система счисления
     */
    public static void setSystem(long n)
    {
        system = n;
    }

    /**
     * char -> int
     * @param A
     * @return
     */
    private static long pCharToInt(char A)
    {
        if (A > '9')
            return (A - 'A');
        else
            return (A - '0');
    }

    /**
     * Переводит целую часть P-го числа в 10 систему
     * @param line
     * @return
     */
    private static long pIntTo10(String line)
    {
        long main = 0;
        for (int i = 0, j = line.length() - 1; i < line.length(); i++, j--)
        {
            int u = line.charAt(j);
            if (u < 'A')
                main += (long)((u - '0') * Math.pow(system, i));
            else
                main += (long)((u - 'A' + 10) * Math.pow(system, i));
        }
        return main;
    }

    /**
     * Переводит дробную часть P-го числа в 10 систему
     * @param line
     * @return
     */
    private static double pFracTo10(String line)
    {
        double extra = 0;
        for (int i = -1, j = 1; j < line.length(); i--, j++)
        {
            int u = line.charAt(j);
            if (u < 'A')
                extra += (u - '0') * Math.pow(system, i);
            else
                extra += (u - 'A' + 10) * Math.pow(system, i);
        }
        return extra;
    }
}
