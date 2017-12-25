package com.example.gambm.calcul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.lang.String.valueOf;

public class Calcul extends AppCompatActivity {

    @BindView(R.id.tvOut)
    protected TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        ButterKnife.bind(this);
    }

    private static final String TAG = "myLogs";

    private String out = "";
    private String delimeter;
    private String value1 = "", value2 = "";
    private boolean a = false;

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn0, R.id.btnDiv, R.id.btnPlus, R.id.btnMinus, R.id.btnMulti, R.id.btnEq, R.id.btnBack})
    protected void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                prepare(1);
                break;
            case R.id.btn2:
                prepare(2);
                break;
            case R.id.btn3:
                prepare(3);
                break;
            case R.id.btn4:
                prepare(4);
                break;
            case R.id.btn5:
                prepare(5);
                break;
            case R.id.btn6:
                prepare(6);
                break;
            case R.id.btn7:
                prepare(7);
                break;
            case R.id.btn8:
                prepare(8);
                break;
            case R.id.btn9:
                prepare(9);
                break;
            case R.id.btn0:
                prepare(0);
                break;
            case R.id.btnPlus:
                if (a == false)
                    oper("+");
                break;
            case R.id.btnMinus:
                if (a == false)
                    oper("-");
                break;
            case R.id.btnMulti:
                if (a == false)
                    oper("*");
                break;
            case R.id.btnDiv:
                if (a == false)
                    oper("/");
                break;
            case R.id.btnEq:
                body();
                break;
            case R.id.btnBack:
                finish();
                break;
        }
    }

    private void prepare(int value) {
        if (a)
            value2 += value;
        else
            value1 += value;
        out += value;
        tvOut.setText(out);
    }

    private void oper(String value) {
        out += value;
        delimeter = value;
        a = true;
        tvOut.setText(out);
    }

    private void body() {
        int pvalue1, pvalue2;
        pvalue1 = Integer.parseInt(value1);
        pvalue2 = Integer.parseInt(value2);
        double g;
        switch (delimeter) {
            case "+":
                g = pvalue1 + pvalue2;
                tvOut.setText(valueOf(g));
                break;
            case "-":
                g = pvalue1 - pvalue2;
                Log.d(TAG, valueOf(g));
                tvOut.setText(valueOf(g));
                break;
            case "*":
                g = pvalue1 * pvalue2;
                tvOut.setText(valueOf(g));
                break;
            case "/":
                try {
                    g = pvalue1 / pvalue2;
                    tvOut.setText(valueOf(g));
                } catch (Throwable t) {
                    Toast.makeText(this, "На ноль делить нельзя", Toast.LENGTH_LONG).show();
                }
                break;
        }
        a = false;
        out = "";
        delimeter = "";
        value1 = "";
        value2 = "";
    }
}

