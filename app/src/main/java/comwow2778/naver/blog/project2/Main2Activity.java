package comwow2778.naver.blog.project2;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main2Activity extends AppCompatActivity {
    Switch s1;
    Button b1,b2;
    TextView t1,t2,t3,t4,t5,t6;
    EditText e1,e2,e3;
    Chronometer c1;
    DatePicker d1;
    TimePicker d2;
    FrameLayout f1;
    LinearLayout L1,L2;
    GridLayout L3,L4;
    int i =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("레스토랑 예약 시스템");
        s1= (Switch)findViewById(R.id.s1);
        b1= (Button)findViewById(R.id.b1);
        b2= (Button)findViewById(R.id.b2);
        e1= (EditText)findViewById(R.id.e1);
        e2= (EditText)findViewById(R.id.e2);
        e3= (EditText)findViewById(R.id.e3);
        t1= (TextView)findViewById(R.id.t1);
        t2= (TextView)findViewById(R.id.t2);
        t3= (TextView)findViewById(R.id.t3);
        t4= (TextView)findViewById(R.id.t4);
        t5= (TextView)findViewById(R.id.t5);
        t6= (TextView)findViewById(R.id.t6);
        c1= (Chronometer)findViewById(R.id.c1);
        d1= (DatePicker)findViewById(R.id.d1);
        d2= (TimePicker)findViewById(R.id.d2);
        f1= (FrameLayout)findViewById(R.id.f1);
        L1= (LinearLayout)findViewById(R.id.L1);
        L2= (LinearLayout)findViewById(R.id.L2);
        L3= (GridLayout)findViewById(R.id.L3);
        L4= (GridLayout)findViewById(R.id.L4);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(s1.isChecked()==true){
                    c1.setBase(SystemClock.elapsedRealtime());
                    c1.start();
                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    page(i);
                }
                else{
                    t1.setVisibility(View.INVISIBLE);
                    f1.setVisibility(View.INVISIBLE);
                    c1.setVisibility(View.INVISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                    b1.setVisibility(View.INVISIBLE);
                    c1.stop();
                    c1.setBase(SystemClock.elapsedRealtime());
                }
            }
        });
    }






    void onmyclick(View v){
        if(v.getId() == R.id.b1){
            i--;
            page(i);
        }
        else if(v.getId() == R.id.b2){
            i++;
            page(i);
        }
        else if(v.getId() ==R.id.b10){
            next();
        }

    }

    void page(int i) {
        if (i == 1) {
            t1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
            f1.setVisibility(View.VISIBLE);
            L1.setVisibility(View.VISIBLE);
            b1.setEnabled(false);
            b2.setEnabled(true);
            L2.setVisibility(View.INVISIBLE);
        }
        else if (i == 2) {
            L1.setVisibility(View.INVISIBLE);
            L2.setVisibility(View.VISIBLE);
            b1.setEnabled(true);
            b2.setEnabled(true);
            L3.setVisibility(View.INVISIBLE);

        }
        else if (i == 3) {
            L2.setVisibility(View.INVISIBLE);
            L3.setVisibility(View.VISIBLE);
            L4.setVisibility(View.INVISIBLE);
            b2.setEnabled(true);

        }
        else if (i == 4) {
            data();
            L3.setVisibility(View.INVISIBLE);
            b2.setEnabled(false);
            L4.setVisibility(View.VISIBLE);
        }
    }
    void data(){
        int month = d1.getMonth();
        int day = d1.getDayOfMonth();
        int year = d1.getYear();
        int hour = d2.getHour();
        int minutes = d2.getMinute();

        t2.setText(year + "년 " + month + "월 " + day+"일");
        t3.setText(hour + "시 " + minutes + "분");

        String a = e1.getText().toString();
        String b = e2.getText().toString();
        String c = e3.getText().toString();

        int adult = Integer.parseInt(a);
        int teen = Integer.parseInt(b);
        int child = Integer.parseInt(c);

        t4.setText(adult + "명");
        t5.setText(teen + "명");
        t6.setText(child + "명");
    }

    void next(){
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
}
