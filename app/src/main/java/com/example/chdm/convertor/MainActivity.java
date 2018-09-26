package com.example.chdm.convertor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Класс контроллер
     */
    Control ctrl;

    /**
     * Создание формы
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //для портретного режима
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBarP1_P2);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBarP2_P1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            /**
             * Обработчик события сдвига ползунка
             * @param seekBar
             * @param progress
             * @param fromUser
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                SeekBar seekBar1 = seekBar;
                SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBarP2_P1);
                TextView textView = (TextView) findViewById(R.id.textViewP1_P2);
                TextView editText1 = (TextView) findViewById(R.id.textViewOutputP1_P2);
                TextView editText2 = (TextView) findViewById(R.id.textViewOutputP2_P1);
                textView.setText("Число в системе счисления P=" + (seekBar1.getProgress() + 2));
                updateKeys();
                ConvertP1_10.setSystem(seekBar1.getProgress() + 2);
                editText1.setText(ctrl.setCommand("CL"));
                checkDot(editText1.getText().toString());
                editText2.setText("0");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * Обработчик события сдвига ползунка
             * @param seekBar
             * @param progress
             * @param fromUser
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBarP1_P2);
                SeekBar seekBar2 = seekBar;
                TextView textView1 = (TextView) findViewById(R.id.textViewP1_P2);
                TextView textView2 = (TextView) findViewById(R.id.textViewP2_P1);
                TextView editText1 = (TextView) findViewById(R.id.textViewOutputP1_P2);
                TextView editText2 = (TextView) findViewById(R.id.textViewOutputP2_P1);
                textView2.setText("Число в системе счисления P=" + (seekBar2.getProgress() + 2));
                Convert10_P2.setSystem(seekBar2.getProgress() + 2);
                editText2.setText(Convert10_P2.convert(ConvertP1_10.convert(editText1.getText().toString())));
                History.add(seekBar2.getProgress() + 2, seekBar1.getProgress() + 2, editText1.getText().toString(), editText2.getText().toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        ctrl = new Control();
    }

    /**
     * Обработка выбора элемента меню
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();
        Intent intent;
        // Операции для выбранного пункта меню
        switch (id)
        {
            case R.id.action_history:
                intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_help:
                intent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /**
     * Проверка наличие символа '.' в строке
     * @param line
     */
    void checkDot(String line)
    {
        Button b = (Button) findViewById(R.id.buttonDot);
        if(line.contains("."))
        {
            b.setEnabled(false);
        }
        else
        {
            b.setEnabled(true);
        }
    }

    /**
     * Блокировка/разблокировка кнопок
     */
    void updateKeys()
    {
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBarP1_P2);
        int system = seekBar1.getProgress() + 2;
        switch (system)
        {
            case 2: findViewById(R.id.button_2).setEnabled(false);
            case 3: findViewById(R.id.button_3).setEnabled(false);
            case 4: findViewById(R.id.button_4).setEnabled(false);
            case 5: findViewById(R.id.button_5).setEnabled(false);
            case 6: findViewById(R.id.button_6).setEnabled(false);
            case 7: findViewById(R.id.button_7).setEnabled(false);
            case 8: findViewById(R.id.button_8).setEnabled(false);
            case 9: findViewById(R.id.button_9).setEnabled(false);
            case 10: findViewById(R.id.buttonA).setEnabled(false);
            case 11: findViewById(R.id.buttonB).setEnabled(false);
            case 12: findViewById(R.id.buttonC).setEnabled(false);
            case 13: findViewById(R.id.buttonD).setEnabled(false);
            case 14: findViewById(R.id.buttonE).setEnabled(false);
            case 15: findViewById(R.id.buttonF).setEnabled(false);
            default: break;
        }
        switch (system)
        {
            case 16: findViewById(R.id.buttonF).setEnabled(true);
            case 15: findViewById(R.id.buttonE).setEnabled(true);
            case 14: findViewById(R.id.buttonD).setEnabled(true);
            case 13: findViewById(R.id.buttonC).setEnabled(true);
            case 12: findViewById(R.id.buttonB).setEnabled(true);
            case 11: findViewById(R.id.buttonA).setEnabled(true);
            case 10: findViewById(R.id.button_9).setEnabled(true);
            case 9: findViewById(R.id.button_8).setEnabled(true);
            case 8: findViewById(R.id.button_7).setEnabled(true);
            case 7: findViewById(R.id.button_6).setEnabled(true);
            case 6: findViewById(R.id.button_5).setEnabled(true);
            case 5: findViewById(R.id.button_4).setEnabled(true);
            case 4: findViewById(R.id.button_3).setEnabled(true);
            case 3: findViewById(R.id.button_2).setEnabled(true);
            default: break;
        }
    }

    /**
     * Обработка нажатия кнопки
     * @param view
     */
    public void onButton(View view)
    {
        Button b = (Button) findViewById(view.getId());
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBarP1_P2);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBarP2_P1);
        TextView textView1 = (TextView) findViewById(R.id.textViewP1_P2);
        TextView textView2 = (TextView) findViewById(R.id.textViewP2_P1);
        TextView editText1 = (TextView) findViewById(R.id.textViewOutputP1_P2);
        TextView editText2 = (TextView) findViewById(R.id.textViewOutputP2_P1);
        String ttt = b.getText().toString();
        editText1.setText("" + ctrl.setCommand(b.getText().toString()));
        checkDot(editText1.getText().toString());
        editText2.setText("0");
        textView2.setText("Число в системе счисления P=" + (seekBar2.getProgress() + 2));
        ConvertP1_10.setSystem(seekBar1.getProgress() + 2);
        Convert10_P2.setSystem(seekBar2.getProgress() + 2);
        editText2.setText(Convert10_P2.convert(ConvertP1_10.convert(editText1.getText().toString())));
        History.add(seekBar2.getProgress() + 2, seekBar1.getProgress() + 2, editText1.getText().toString(), editText2.getText().toString());
    }
}
