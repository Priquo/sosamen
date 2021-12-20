package com.example.sosamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button doCalc, doActiv;
    EditText text1, text2;
    Spinner plus;
    String item = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doCalc = findViewById(R.id.doCalc);
        doActiv = findViewById(R.id.doActiv);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        plus = findViewById(R.id.plus);

        String[] zalupa = {"+", "-", "*", "/"};

        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, zalupa);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner

        plus.setAdapter(adapter);

//        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                item = (String)adapterView.getItemAtPosition(i);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        };
//        plus.setOnItemClickListener((AdapterView.OnItemClickListener) itemSelectedListener);

        doCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!text1.getText().equals("") && !text2.getText().equals(""))
                {
                    int itog;
                    switch (plus.getSelectedItem().toString())
                    {
                        case "+":
                            itog = Integer.parseInt(text1.getText().toString());
                            itog += Integer.parseInt(text2.getText().toString());
                            Toast.makeText(MainActivity.this, Integer.toString(itog), Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"вы залупа блять иди нахуй", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}