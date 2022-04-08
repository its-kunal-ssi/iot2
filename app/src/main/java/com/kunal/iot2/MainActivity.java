package com.kunal.iot2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vehRef = database.getReference("vehicle");
        Map<String, Integer> veh = new HashMap();

        ToggleButton powerbtn = findViewById(R.id.togglePower);
        ToggleButton headLightbtn = findViewById(R.id.toggleHeadlight);
        ToggleButton hornbtn = findViewById(R.id.toggleHorn);
        Button savebtn = findViewById(R.id.buttonSave);
        Button findbtn = findViewById(R.id.buttonFind);



        savebtn.setOnClickListener(view -> {

            powerbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        veh.put("power",1);
                    } else {
                        veh.put("power",0);
                    }
                }
            });

            headLightbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        veh.put("headlight",1);
                    } else {
                        veh.put("headlight",0);
                    }
                }
            });
            hornbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        veh.put("horn",1);
                        Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                    } else {
                        veh.put("horn",0);
                    }
                }
            });
            vehRef.setValue(veh);
            Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
        });


    }
}