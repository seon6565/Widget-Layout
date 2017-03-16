package comwow2778.naver.blog.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("학점 계산기");

    }

    public void onmyclick(View v){
        if(v.getId() == R.id.b1){
            cal();
        }
        else if(v.getId() == R.id.b2){
            reset();
        }

    }

    void cal(){
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);

        String a = e1.getText().toString();
        String b = e2.getText().toString();
        String c = e3.getText().toString();

        int i = Integer.parseInt(a);
        int j = Integer.parseInt(b);
        int k = Integer.parseInt(c);
        int total = i+j+k;
        int avg = total/3;
        if(avg>=90){

        }
        else if(avg>=80 && avg<90){

        }
        else if(avg>=70 && avg<80){

        }
        else if(avg>=60 && avg<70){

        }
        else{

        }
    }

    void reset(){

    }
}
