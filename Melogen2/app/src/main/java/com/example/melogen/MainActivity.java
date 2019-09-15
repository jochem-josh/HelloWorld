package com.example.melogen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String startKey;
    int startDeg;

    public void keyOfEF(View view)
    {
        startKey="E♭";
    }
    public void keyOfBF(View view)
    {
        startKey="B♭";
    }
    public void keyOfF(View view)
    {
        startKey="F";
    }
    public void keyOfC(View view)
    {
        startKey="C";
    }
    public void keyOfG(View view
    {
        startKey="G";
    }
    public void keyOfD(View view)
    {
        startKey="D";
    }
    public void keyOfA(View view)
    {
        startKey="A";
    }
    public void startNote1(View view){
        startDeg=1;
    }
    public void startNote2(View view){
        startDeg=2;
    }
    public void startNote3(View view){
        startDeg=3;
    }
    public void startNote4(View view){
        startDeg=4;
    }
    public void startNote5(View view){
        startDeg=5;
    }
    public void startNote6(View view){
        startDeg=6;
    }
    public void startNote7(View view){
        startDeg=7;
    }
    public void Melogen(View view){
        StructuredMelodyPlayer one= new StructuredMelodyPlayer(startKey,startDeg,16,100);
    }
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
    public void toastScale1(View view){
        Toast myToast = Toast.makeText(this, "Starting on 1",
                Toast.LENGTH_SHORT);
        myToast.show();
    }

}