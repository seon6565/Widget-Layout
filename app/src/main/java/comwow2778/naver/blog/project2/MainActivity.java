package comwow2778.naver.blog.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    TextView t1,t2;
    ImageView i1,i2,i3,i4,i5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("학점 계산기");
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        i1 = (ImageView)findViewById(R.id.i1);
        i2 = (ImageView)findViewById(R.id.i2);
        i3 = (ImageView)findViewById(R.id.i3);
        i4 = (ImageView)findViewById(R.id.i4);
        i5 = (ImageView)findViewById(R.id.i5);

    }

    void onmyclick(View v){
        if(v.getId() == R.id.b1){
            cal();
        }
        else if(v.getId() == R.id.b2){
            reset();
        }
        else if(v.getId() ==R.id.b10){
            next();
        }

    }

    void cal(){
        String a = e1.getText().toString();
        String b = e2.getText().toString();
        String c = e3.getText().toString();
        if(a.isEmpty() || b.isEmpty() || c.isEmpty()){
            t1.setText("0점");
            t2.setText("0점");
        }
        else {
            int i = Integer.parseInt(a);
            int j = Integer.parseInt(b);
            int k = Integer.parseInt(c);
            int total = i + j + k;
            int avg = total / 3;
            if (avg >= 90) {
                t1.setText(total+"점");
                t2.setText(avg+"점");
                i1.setVisibility(View.VISIBLE);
            } else if (avg >= 80 && avg < 90) {
                t1.setText(total+"점");
                t2.setText(avg+"점");
                i2.setVisibility(View.VISIBLE);
            } else if (avg >= 70 && avg < 80) {
                t1.setText(total+"점");
                t2.setText(avg+"점");
                i3.setVisibility(View.VISIBLE);
            } else if (avg >= 60 && avg < 70) {
                t1.setText(total+"점");
                t2.setText(avg+"점");
                i4.setVisibility(View.VISIBLE);
            } else {
                t1.setText(total+"점");
                t2.setText(avg+"점");
                i5.setVisibility(View.VISIBLE);
            }
        }
    }

    void reset(){
        t1.setText("0점");
        t2.setText("0점");
        e1.setText("");
        e2.setText("");
        e3.setText("");
        i1.setVisibility(View.INVISIBLE);
        i2.setVisibility(View.INVISIBLE);
        i3.setVisibility(View.INVISIBLE);
        i4.setVisibility(View.INVISIBLE);
        i5.setVisibility(View.INVISIBLE);
        Toast.makeText(MainActivity.this, "초기화 되었습니다.", Toast.LENGTH_SHORT).show();
    }

    void next(){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
