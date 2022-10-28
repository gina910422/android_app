package com.cornez.tapbuttoncounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    //MODEL
    private Counter count;

    //VIEW
    private TextView n1;
    private TextView n2;
    private TextView ans1;
    private TextView ans2;
    private TextView ans3;
    int lock = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        count = new Counter();
        n1 = (TextView) findViewById(R.id.textView_num1);
        n2 = (TextView) findViewById(R.id.textView_num2);
        ans1 = (TextView) findViewById(R.id.textView_ans1);
        ans2 = (TextView) findViewById(R.id.textView_ans2);
        ans3 = (TextView) findViewById(R.id.textView_ans3);
    }

    public void countInc(View view){
        if(lock==0){
            count.addCount();
            n1.setText(count.getCount().toString());
            n2.setText(count.getCount().toString());
        }
    }

    public void countDec(View view){
        if(lock==0){
            count.deCount();
            n1.setText(count.getCount().toString());
            n2.setText(count.getCount().toString());
        }
    }

    public void countComp(View view){
        if(lock==0){
            lock=1;
        }
        else{
            lock=0;
        }
        count.compCount();
        ans1.setText(count.getAns1().toString());
        ans2.setText(count.getAns2().toString());
        ans3.setText(count.getAns3().toString());
    }

    public void countReset(View view){
        count.resetCount();
        n1.setText(count.getCount().toString());
        n2.setText(count.getCount().toString());
        ans1.setText(count.getAns1().toString());
        ans2.setText(count.getAns2().toString());
        ans3.setText(count.getAns3().toString());
        lock=0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
