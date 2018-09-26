package com.example.chdm.convertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_help);

        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setText("Программа конвертер. \n\n" +
                "Работу выполнили:\n" +
                "студенты 3го курса,\n" +
                "группы ПМИ-31\n" +
                "Червонецкий Д. Н.,\n" +
                "Милякина Е.О.");
    }
}
