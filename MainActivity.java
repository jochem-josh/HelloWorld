package com.example.melodygenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    char key;
    String note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toastA(View view){
        Toast myToast = Toast.makeText(this, "Writing in A major",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastB(View view){
        Toast myToast = Toast.makeText(this, "Writing in B major",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastC(View view){
        Toast myToast = Toast.makeText(this, "Writing in C major",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastD(View view){
        Toast myToast = Toast.makeText(this, "Writing in D major",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastE(View view){
        Toast myToast = Toast.makeText(this, "Writing in E major",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastF(View view){
        Toast myToast = Toast.makeText(this, "Writing in F major",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastG(View view){
        Toast myToast = Toast.makeText(this, "Writing in G major",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastScale1(View view){
        Toast myToast = Toast.makeText(this, "Starting on 1",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastScale2(View view){
        Toast myToast = Toast.makeText(this, "Starting on 2",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastScale3(View view){
        Toast myToast = Toast.makeText(this, "Starting on 3",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastScale4(View view){
        Toast myToast = Toast.makeText(this, "Starting on 4",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastScale5(View view){
        Toast myToast = Toast.makeText(this, "Starting on 5",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastScale6(View view){
        Toast myToast = Toast.makeText(this, "Starting on 6",
                Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void toastScale7(View view){
        Toast myToast = Toast.makeText(this, "Starting on 7",
                Toast.LENGTH_SHORT);
        myToast.show();
    }


}
