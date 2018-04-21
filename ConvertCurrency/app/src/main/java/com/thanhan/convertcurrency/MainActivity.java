package com.thanhan.convertcurrency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button button;
    EditText money_1;
    TextView money_2;
    Spinner spinner_1,spinner_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ConvertCurrency convertCurrency = new ConvertCurrency();

        button = (Button) findViewById(R.id.convert);
        money_1 =(EditText) findViewById(R.id.money_1);
        money_2 =(TextView) findViewById(R.id.money_2);
        spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        spinner_2 = (Spinner) findViewById(R.id.spinner_2);

        String[] arraySpinner = new String[] {"USD","EUR","VND","JPY","CNY","GBP"};

        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.spinner_item,arraySpinner);
        adapter_1.setDropDownViewResource(R.layout.spinner_item);
        spinner_1.setAdapter(adapter_1);

        spinner_2.setAdapter(adapter_1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input =Double.parseDouble(money_1.getText().toString());
                String a = spinner_1.getSelectedItem().toString();
                String b = spinner_2.getSelectedItem().toString();
                double result = convertCurrency.convert(input,a,b);
                money_2.setText(String.valueOf(result));
            }
        });

    }



}
