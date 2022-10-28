package com.cornez.shippingcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MyActivity extends Activity {
    //DATA MODEL FOR SHIP ITEM
    private ShipItem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE

    private EditText heightET;
    private EditText weightET;
    private EditText ageET;
    private TextView ansTV;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_2);

        //CREATE THE DATA MODEL FOR STORING THE ITEM TO BE SHIPPED
        shipItem = new ShipItem();

        heightET = (EditText) findViewById(R.id.editText_height);
        weightET = (EditText) findViewById(R.id.editText_weight);
        ageET = (EditText) findViewById(R.id.editText_age);

        ansTV = (TextView) findViewById(R.id.ans);

        heightET.addTextChangedListener(heightTextWatcher);
        weightET.addTextChangedListener(weightTextWatcher);
        ageET.addTextChangedListener(ageTextWatcher);

        button = (Button)findViewById(R.id.sex);
    }
    int i = 1;
    public void buttonOnClick1(View view){
        if(i==1){
            i=0;
            button.setText("女性");
        }
        else if(i==0){
            i=1;
            button.setText("男性");
        }
    }
    int x=0,y=0,z=0;
    public void buttonOnClick2(View view){
        if(x==1&&y==1&&z==1){
            if(i==1){
                shipItem.setting1();
            }
            else if(i==0){
                shipItem.setting2();
            }
            displayShipping();
        }
        else{
            wrong();
        }
    }
    public void buttonOnClick3(View view){
        shipItem.setHeight(0.0);
        shipItem.setWeight(0.0);
        shipItem.setAge(0);
        heightET.setText(null);
        heightET.setHint("0.0 公分");
        weightET.setText(null);
        weightET.setHint("0.0 公斤");
        ageET.setText(null);
        ageET.setHint("0 歲");
        ansTV.setText(null);
    }
    private TextWatcher heightTextWatcher = new TextWatcher() {
        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED
        public void onTextChanged(CharSequence s,
                                  int start, int before, int count){
            //CATCH AN EXCEPTION WHEN THE INPUT IS NOT A NUMBER
            try {
                shipItem.setHeight(Double.parseDouble(s.toString()));
                x=1;
            }catch (NumberFormatException e){
                shipItem.setHeight(0.0);
                x=0;
            }
        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s,
                                      int start, int count, int after){}
    };
    private TextWatcher weightTextWatcher = new TextWatcher() {
        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED
        public void onTextChanged(CharSequence s,
                                  int start, int before, int count){
            //CATCH AN EXCEPTION WHEN THE INPUT IS NOT A NUMBER
            try {
                shipItem.setWeight(Double.parseDouble(s.toString()));
                y=1;
            }catch (NumberFormatException e){
                shipItem.setWeight(0.0);
                y=0;
            }
        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s,
                                      int start, int count, int after){}
    };
    private TextWatcher ageTextWatcher = new TextWatcher() {
        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED
        public void onTextChanged(CharSequence s,
                                  int start, int before, int count){
            //CATCH AN EXCEPTION WHEN THE INPUT IS NOT A NUMBER
            try {
                shipItem.setAge((int) Double.parseDouble(s.toString()));
                z=1;
            }catch (NumberFormatException e){
                shipItem.setAge(0);
                z=0;
            }
        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s,
                                      int start, int count, int after){}
    };
    private void displayShipping() {
        //DISPLAY THE BASE COST, ADDED COST, AND TOTAL COST
        ansTV.setText(String.format("%.01f",
                shipItem.getBMR()));
    }
    private void wrong() {
        //DISPLAY THE BASE COST, ADDED COST, AND TOTAL COST
        ansTV.setText("請完整輸入!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

