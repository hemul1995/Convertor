package com.example.chdm.convertor;

/**
 * Created by Dima on 27.09.2018.
 */

public class Control {
    /**
     * Выполнение команды в конвертере
     * @param n id команды
     * @return Возврат результата
     */
    public String setCommand(String n)
    {
        String str = "";
        switch (n)
        {
            case "0": str = Editor.add(n.charAt(0)); break;
            case "1": str = Editor.add(n.charAt(0)); break;
            case "2": str = Editor.add(n.charAt(0)); break;
            case "3": str = Editor.add(n.charAt(0)); break;
            case "4": str = Editor.add(n.charAt(0)); break;
            case "5": str = Editor.add(n.charAt(0)); break;
            case "6": str = Editor.add(n.charAt(0)); break;
            case "7": str = Editor.add(n.charAt(0)); break;
            case "8": str = Editor.add(n.charAt(0)); break;
            case "9": str = Editor.add(n.charAt(0)); break;
            case "A": str = Editor.add(n.charAt(0)); break;
            case "B": str = Editor.add(n.charAt(0)); break;
            case "C": str = Editor.add(n.charAt(0)); break;
            case "D": str = Editor.add(n.charAt(0)); break;
            case "E": str = Editor.add(n.charAt(0)); break;
            case "F": str = Editor.add(n.charAt(0)); break;
            case ".": str = Editor.addDot();  break;
            case "BS": str = Editor.back(); break;
            case "CL": str = Editor.clear(); break;
            default:  break;
        }
        return str;
    }
}
