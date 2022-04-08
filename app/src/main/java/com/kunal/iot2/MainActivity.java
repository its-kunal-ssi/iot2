package com.kunal.iot2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

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
            powerbtn.
            veh.put("power", )
        });

        veh.put("horn",1);
        veh.put("power",1);
        veh.put("headlight",0);

        vehRef.setValue(veh);
    }
}