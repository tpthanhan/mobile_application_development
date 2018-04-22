package com.thanhan.convertcurrency;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    Button button;
    EditText money_1;
    TextView money_2;
    Spinner spinner_1,spinner_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        final ConvertCurrency convertCurrency = new ConvertCurrency();

        money_1 =(EditText) findViewById(R.id.money_1);

        money_2 =(TextView) findViewById(R.id.money_2);
        spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        spinner_2 = (Spinner) findViewById(R.id.spinner_2);

        String[] arraySpinner = new String[] {"USD","EUR","VND","JPY","CNY","GBP"};

        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.spinner_item,arraySpinner);
        adapter_1.setDropDownViewResource(R.layout.spinner_item);
        spinner_1.setAdapter(adapter_1);

        spinner_2.setAdapter(adapter_1);

        money_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!money_1.getText().toString().equals("")) {
                    if (isNumeric(money_1.getText().toString())) {
                        double input = Double.parseDouble(money_1.getText().toString());
                        String a = spinner_1.getSelectedItem().toString();
                        String b = spinner_2.getSelectedItem().toString();
                        double result = convertCurrency.convert(input, a, b);
                        money_2.setText(String.valueOf(result));
                    }
                    else {
                        String input = money_1.getText().toString();
                        input = input.substring(0,input.length()-1);
                        money_1.setText(input);
                        Context context = getApplicationContext();
                        CharSequence text = "Nhập số thôi!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }
                }
                else {
                    money_2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!money_1.getText().toString().equals("")) {

                    double input = Double.parseDouble(money_1.getText().toString());
                    String a = spinner_1.getSelectedItem().toString();
                    String b = spinner_2.getSelectedItem().toString();
                    double result = convertCurrency.convert(input, a, b);
                    money_2.setText(String.valueOf(result));
                }
                else {
                    money_2.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!money_1.getText().toString().equals("")) {
                    double input = Double.parseDouble(money_1.getText().toString());
                    String a = spinner_1.getSelectedItem().toString();
                    String b = spinner_2.getSelectedItem().toString();
                    double result = convertCurrency.convert(input, a, b);
                    money_2.setText(String.valueOf(result));
                }
                else {
                    money_2.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }


}
