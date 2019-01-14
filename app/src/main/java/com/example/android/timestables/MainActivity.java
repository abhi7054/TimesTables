package com.example.android.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public void generateTimesTable(int timesTableNumber) {
        ListView timesTablesListView=findViewById(R.id.timesTablesListView);
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int j = 1; j <= 10; j++)

        {
            timesTableContent.add(Integer.toString(j * timesTableNumber));

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final SeekBar timesTablesSeekbar=findViewById(R.id.timesTableSeekbar);

        timesTablesSeekbar.setMax(20);
        timesTablesSeekbar.setProgress(10);
        generateTimesTable(10);
        timesTablesSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timesTableNumber;

                if(i<min){
                    timesTableNumber=min;
                    timesTablesSeekbar.setProgress(min);
                }
                else
                {
                    timesTableNumber=i;
                }
                    generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        
    }
}
