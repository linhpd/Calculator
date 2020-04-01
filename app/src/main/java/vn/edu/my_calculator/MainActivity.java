package vn.edu.my_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Integer;
import java.lang.String;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNumber;
    private TextView txtResult;

    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnPoint;
    private Button btnResult;
    private Button btnClearNumber;
    private Button btnClearAll;
    private Button btnDelete;

    int a = 0, b = 0, result = 0;
    char c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }

    public void initWidget(){
        edtNumber = findViewById(R.id.edt_num);
        txtResult = findViewById(R.id.txt_result);

        btnNumber0 = findViewById(R.id.btn_num0);
        btnNumber1 = findViewById(R.id.btn_num1);
        btnNumber2 = findViewById(R.id.btn_num2);
        btnNumber3 = findViewById(R.id.btn_num3);
        btnNumber4 = findViewById(R.id.btn_num4);
        btnNumber5 = findViewById(R.id.btn_num5);
        btnNumber6 = findViewById(R.id.btn_num6);
        btnNumber7 = findViewById(R.id.btn_num7);
        btnNumber8 = findViewById(R.id.btn_num8);
        btnNumber9 = findViewById(R.id.btn_num9);

        btnCong = findViewById(R.id.btn_cong);
        btnTru = findViewById(R.id.btn_tru);
        btnNhan = findViewById(R.id.btn_nhan);
        btnChia = findViewById(R.id.btn_chia);

        btnPoint = findViewById(R.id.btn_point);
        btnResult = findViewById(R.id.btn_result);
        btnClearNumber = findViewById(R.id.btn_clearNumber);
        btnClearAll = findViewById(R.id.btn_clearAll);
        btnDelete = findViewById(R.id.btn_delete);
    }

    public void setEventClickViews(){
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnClearNumber.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

/* public int returnResult(String a){
     int temp = 0;
     if (a.contains(".")){
         String[] output = a.split("\\.");
         int b = Integer.parseInt(output[0]);
         int c = Integer.parseInt(output[1]);
         temp = b + c;
     }
     if (a.contains("-")){
         String[] output = a.split("-");
         int b = Integer.parseInt(output[0]);
         int c = Integer.parseInt(output[1]);
         temp = b - c;
     }
     if (a.contains("x")){
         String[] output = a.split("x");
         int b = Integer.parseInt(output[0]);
         int c = Integer.parseInt(output[1]);
         temp = b * c;
     }
     if (a.contains("/")){
         String[] output = a.split("/");
         int b = Integer.parseInt(output[0]);
         int c = Integer.parseInt(output[1]);
         temp = b / c;
     }
     return temp;
 }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_num0:
                edtNumber.append("0");
                break;
            case R.id.btn_num1:
                edtNumber.append("1");
                break;
            case R.id.btn_num2:
                edtNumber.append("2");
                break;
            case R.id.btn_num3:
                edtNumber.append("3");
                break;
            case R.id.btn_num4:
                edtNumber.append("4");
                break;
            case R.id.btn_num5:
                edtNumber.append("5");
                break;
            case R.id.btn_num6:
                edtNumber.append("6");
                break;
            case R.id.btn_num7:
                edtNumber.append("7");
                break;
            case R.id.btn_num8:
                edtNumber.append("8");
                break;
            case R.id.btn_num9:
                edtNumber.append("9");
                break;
            case R.id.btn_cong:
                a = a = Integer.parseInt(edtNumber.getText().toString());
                c = '+';
                edtNumber.append("+");
                edtNumber.setText("");
                break;
            case R.id.btn_tru:
                a = Integer.parseInt(edtNumber.getText().toString());
                c = '-';
                edtNumber.append("-");
                edtNumber.setText("");
                break;
            case R.id.btn_nhan:
                a = Integer.parseInt(edtNumber.getText().toString());
                c = 'x';
                edtNumber.append("x");
                edtNumber.setText("");
                break;
            case R.id.btn_chia:
                a = Integer.parseInt(edtNumber.getText().toString());
                c = '/';
                edtNumber.append("/");
                edtNumber.setText("");
                break;
            case R.id.btn_point:
                edtNumber.append(".");
                break;
            case R.id.btn_result:
                b = Integer.parseInt(edtNumber.getText().toString());
                if (c == '+') result = a + b;
                if (c == '-') result = a - b;
                if (c == 'x') result = a * b;
                if (c == '/') result = a / b;
                txtResult.setText(result + "");
                break;
            case R.id.btn_clearNumber:
                break;
            case R.id.btn_clearAll:
                edtNumber.setText("");
                break;
            case R.id.btn_delete:
                BaseInputConnection a = new BaseInputConnection(edtNumber,true);
                a.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

