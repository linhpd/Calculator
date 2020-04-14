package vn.edu.my_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Integer;
import java.lang.String;


import java.lang.Double;

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

    private Button btnPoint;
    private Button btnClearAll;
    private Button btnDelete;

    private Spinner spinner1;
    private Spinner spinner2;



    String[] country = {"USA-Dollar","VN-Dong","Eng-Pound","Euro-Euro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter sp1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        sp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(sp1);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter sp2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        sp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(sp2);

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


        btnPoint = findViewById(R.id.btn_point);
        btnClearAll = findViewById(R.id.btn_clearAll);
        btnDelete = findViewById(R.id.btn_delete);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
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
        btnPoint.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    void convert() {
        double temp = Double.parseDouble(edtNumber.getText().toString());
        if (spinner1.getSelectedItem().equals("USA-Dollar")) {
            if (spinner2.getSelectedItem().equals("USA-Dollar")) {
                txtResult.setText(edtNumber.getText().toString());
            }
            if (spinner2.getSelectedItem().equals("VN-Dong")) {
                temp = temp * 23000;
                txtResult.setText(String.valueOf(temp));
            }
            if (spinner2.getSelectedItem().equals("Eng-Pound")) {
                temp = temp * 0.8;
                txtResult.setText(String.valueOf(temp));
            }
            if (spinner2.getSelectedItem().equals("Euro-Euro")) {
                temp = temp * 0.9;
                txtResult.setText(String.valueOf(temp));
            }
        }
        else if (spinner1.getSelectedItem().equals("VN-Dong")) {
            if (spinner2.getSelectedItem().equals("VN-Dong")) {
                txtResult.setText(edtNumber.getText().toString());
            }
            if (spinner2.getSelectedItem().equals("USA-Dollar")) {
                temp = temp / 23000;
                txtResult.setText(String.valueOf(temp));
            }
            if (spinner2.getSelectedItem().equals("Eng-Pound")) {
                temp = temp / 30000;
                txtResult.setText(String.valueOf(temp));
            }
            if (spinner2.getSelectedItem().equals("Euro-Euro")) {
                temp = temp / 25000;
                txtResult.setText(String.valueOf(temp));
            }
        }
        else if (spinner1.getSelectedItem().equals("Eng-Pound")) {
            if (spinner2.getSelectedItem().equals("Eng-Pound")) {
                txtResult.setText(edtNumber.getText().toString());
            }
            if (spinner2.getSelectedItem().equals("VN-Dong")) {
                temp = temp * 30000;
                txtResult.setText(String.valueOf(temp));
            }
            if (spinner2.getSelectedItem().equals("USA-Dollar")) {
                temp = temp / 0.8;
                txtResult.setText(String.valueOf(temp));
            }
            if (spinner2.getSelectedItem().equals("Euro-Euro")) {
                temp = temp * 1.13;
                txtResult.setText(String.valueOf(temp));
            }
        }
        else if (spinner1.getSelectedItem().equals("Euro-Euro")) {
            if (spinner2.getSelectedItem().equals("Euro-Euro")) {
                txtResult.setText(edtNumber.getText().toString());
            }
            if (spinner2.getSelectedItem().equals("VN-Dong")) {
                temp = temp * 25000;
                txtResult.setText(String.valueOf(temp));
            }
            if (spinner2.getSelectedItem().equals("Eng-Pound")) {
                temp = temp / 1.13;
                txtResult.setText(String.valueOf(temp));
            }
            if (spinner2.getSelectedItem().equals("USA-Dollar")) {
                temp = temp / 0.9;
                txtResult.setText(String.valueOf(temp));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_num0:
                edtNumber.append("0");
                convert();
                break;
            case R.id.btn_num1:
                edtNumber.append("1");
                convert();
                break;
            case R.id.btn_num2:
                edtNumber.append("2");
                convert();
                break;
            case R.id.btn_num3:
                edtNumber.append("3");
                convert();
                break;
            case R.id.btn_num4:
                edtNumber.append("4");
                convert();
                break;
            case R.id.btn_num5:
                edtNumber.append("5");
                convert();
                break;
            case R.id.btn_num6:
                edtNumber.append("6");
                convert();
                break;
            case R.id.btn_num7:
                edtNumber.append("7");
                convert();
                break;
            case R.id.btn_num8:
                edtNumber.append("8");
                convert();
                break;
            case R.id.btn_num9:
                edtNumber.append("9");
                convert();
                break;
            case R.id.btn_point:
                edtNumber.append(".");
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

