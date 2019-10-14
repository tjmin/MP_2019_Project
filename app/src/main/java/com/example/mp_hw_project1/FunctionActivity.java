package com.example.mp_hw_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FunctionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        final TextView tv1 = (TextView)findViewById(R.id.text1);
        final TextView tv2 = (TextView)findViewById(R.id.text2);
        final TextView tv3 = (TextView)findViewById(R.id.text3);

        final String curText = tv1.getText().toString();

        //button0~9
        Button btn0 = (Button) findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "0";
                tv3.setText(curText);
            }
        });
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "1";
                tv3.setText(curText);
            }
        });
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "2";
                tv3.setText(curText);

            }
        });
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "3";
                tv3.setText(curText);

            }
        });
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "4";
                tv3.setText(curText);

            }
        });
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "5";
                tv3.setText(curText);

            }
        });
        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "6";
                tv3.setText(curText);

            }
        });
        Button btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "7";
                tv3.setText(curText);
            }
        });
        Button btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "8";
                tv3.setText(curText);
            }
        });
        Button btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String curText = tv3.getText().toString() + "9";
                tv3.setText(curText);
            }
        });

        //사칙연산
        Button btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv2.setText("+");
            }
        });
        Button btnSub = (Button) findViewById(R.id.buttonSubstract);
        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv2.setText("-");
            }
        });
        Button btnMul = (Button) findViewById(R.id.buttonMultiply);
        btnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv2.setText("x");
            }
        });
        Button btnDiv = (Button) findViewById(R.id.buttonDivide);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv2.setText("/");
            }
        });

        Button btnClr = (Button) findViewById(R.id.buttonClear);
        btnClr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv1.setText("0");
                tv2.setText("");
                tv3.setText("");
            }
        });


        Button btnRes = (Button) findViewById(R.id.buttonResult);
        btnRes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String sa = tv1.getText().toString();
                final String sb = tv3.getText().toString();
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);

                if (b == 0) {
                    return;
                }

                int res = 0;
                switch (tv2.getText().toString()) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "x":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                    case "":
                        res = b;
                        break;
                }
                Log.d("mydebugCalculate", Integer.toString(res));

                tv1.setText(Integer.toString(res));
                tv2.setText("");
                tv3.setText("");
            }
        });


    }
}
