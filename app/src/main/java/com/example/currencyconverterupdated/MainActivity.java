package com.example.currencyconverterupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> listCurrency;
    TextView textView;
    EditText editText;
    double amount = 0, result = 0 ;
    int pos1 = 0, pos2 = 0;
    Spinner spinner1, spinner2;
    //double usa2vnd = 23.195, usa2cup = 26.5, usa2hrk = 6.40486, usa2jpy = 104.509, usa2rub = 77.1351, usa2kpw = 899.976, usa2cny = 6.70570, usa2krw = 1128.18;
    double usaChange2[] = {23.195, 1, 26.5, 6.40486, 104.509, 77.1351, 899.976, 6.70570, 1128.18};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCurrency = new ArrayList<>();
        listCurrency.add("Viet Nam (VND)");
        listCurrency.add("America (USA)");
        listCurrency.add("Cuba (CUP)");
        listCurrency.add("Croatia (HRK)");
        listCurrency.add("Japan (JPY)");
        listCurrency.add("Russia (RUB)");
        listCurrency.add("North Korea (KPW)");
        listCurrency.add("China (CNY)");
        listCurrency.add("Korea (KRW)");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listCurrency);
        spinner1 = findViewById(R.id.spinner1);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos2 = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                editText.setText("");
            }
        });
        findViewById(R.id.btn_convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Double.parseDouble(editText.getText().toString());
                result = convertCurrency(amount, pos1, pos2);
                textView.setText(String.valueOf((double) Math.round(result*1000)/1000));

            }
        });
        editText = findViewById(R.id.edit_amount);
        textView = findViewById(R.id.tv_result);
    }

    private double convertCurrency(double amount, int from, int to){
        return amount/usaChange2[from] * usaChange2[to];
    }


}