package com.test.kelson.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {

    private float a;
    private float b;
    private float total;
    private boolean start;
    Calculator calc = new Calculator();


    @Overridegi
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = 0;
        start = true;
    }


    public void onClickCreateNum(View view){
        EditText result = (EditText)findViewById(R.id.result); //This is the result number on top
        String current = result.getText().toString(); //Get whats currently there
        Button num = (Button) view; //
        String number = num.getText().toString(); //Get the button number
        current += number;

        result.setText(current);

    }

    public void onClickClear(View view){
        EditText result = (EditText)findViewById(R.id.result);
        result.setText("");
        start = true;
    }

    public void onClickOperator(View view){
        Button op = (Button) view;
        String operator = op.getText().toString();

        EditText result = (EditText)findViewById(R.id.result);
        float x = Float.parseFloat(result.getText().toString());

        if(start){
            total = x;
            start = false;
        } else {
            switch (operator) {

                case "+":
                    total = calc.add(total, x);
                    break;
                case "-":
                    total = calc.subtract(total, x);
                    break;
                case "*":
                    total = calc.multiply(total, x);
                    break;
                case "/":
                    if(x != 0.0)
                        total = calc.divide(total, x);
                    break;

                case "=":

                    break;
                default:


            }
        }
    }
}
